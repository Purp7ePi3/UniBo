<?php
// Start session if not already started
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

$root_path = $_SERVER['DOCUMENT_ROOT'];
$base_url = "/DataBase";

// If user is already logged in, redirect to home page
if (isset($_SESSION['user_id'])) {
    header("Location: $base_url/public/index.php");
    exit;
}

// Include database configuration
require_once '../config/config.php';

$error_message = '';
$success_message = '';

// Check for banned user message
if (isset($_GET['is_active']) && $_GET['is_active'] == '0') {
    $error_message = 'Il tuo account è stato sospeso. Contatta l\'amministratore per ulteriori informazioni.';
}

// Check for registration success message
if (isset($_GET['registered']) && $_GET['registered'] == '1') {
    $success_message = 'Registrazione completata con successo! Ora puoi effettuare il login.';
}

// Process login form submission
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'] ?? '';
    $password = $_POST['password'] ?? '';
    
    // Validate inputs
    if (empty($email) || empty($password)) {
        $error_message = "Per favore, inserisci sia l'email che la password.";
    } else {
        // Prepare SQL to check user credentials
        $sql = "SELECT id, username, email, password_hash, is_active, account_type_id FROM accounts WHERE email = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("s", $email);
        $stmt->execute();
        $result = $stmt->get_result();
        
        if ($result->num_rows === 1) {
            $user = $result->fetch_assoc();
            
            // Check if user is banned BEFORE checking password
            if ($user['is_active'] == 0) {
                $error_message = "Il tuo account è stato sospeso. Contatta l'amministratore per ulteriori informazioni.";
            } else {
                // Verify password - in production, use password_verify() instead of direct comparison
                if ($password == $user['password_hash']) {
                    // Password is correct and user is active, set session variables
                    $_SESSION['user_id'] = $user['id'];
                    $_SESSION['username'] = $user['username'];
                    $_SESSION['email'] = $user['email'];
                    
                    // Set admin status based on account_type_id
                    $_SESSION['is_admin'] = ($user['account_type_id'] == 1);
                    
                    // Check if "remember me" is checked
                    if (isset($_POST['remember']) && $_POST['remember'] == 'on') {
                        // Set cookie that expires in 30 days
                        setcookie('remember_user', $user['id'], time() + (86400 * 30), "/");
                    }
                    
                    // Check if there's a redirect URL
                    if (isset($_SESSION['redirect_url'])) {
                        $redirect = $_SESSION['redirect_url'];
                        unset($_SESSION['redirect_url']);
                        header("Location: $redirect");
                    } else {
                        header("Location: $base_url/public/index.php");
                    }
                    exit;
                } else {
                    $error_message = "Password errata. Per favore riprova.";
                }
            }
        } else {
            $error_message = "Nessun account trovato con questa email.";
        }
    }
}

// Include header - use absolute path to ensure CSS loads correctly
include_once $root_path . $base_url . '/public/partials/header.php';
?>

<section class="auth-container">
    <div class="auth-box">
        <h1>Accedi al tuo account</h1>
        
        <?php if (!empty($error_message)): ?>
            <div class="alert alert-danger">
                <?php echo htmlspecialchars($error_message); ?>
            </div>
        <?php endif; ?>
        
        <?php if (!empty($success_message)): ?>
            <div class="alert alert-success">
                <?php echo htmlspecialchars($success_message); ?>
            </div>
        <?php endif; ?>
        
        <form action="login.php" method="POST" class="auth-form">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="<?php echo htmlspecialchars($_POST['email'] ?? ''); ?>" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="form-options">
                <div class="remember-me">
                    <input type="checkbox" id="remember" name="remember">
                    <label for="remember">Ricordami</label>
                </div>
                <div class="forgot-pwd">
                    <a href="forgot_password.php">Password dimenticata?</a>
                </div>
            </div>
            
            <button type="submit" class="btn-primary btn-full">Accedi</button>
        </form>
        
        <div class="auth-link">
            Non hai un account? <a href="register.php">Registrati ora</a>
        </div>
    </div>
</section>

<?php
// Include footer - use absolute path to ensure CSS loads correctly
include '../public/partials/footer.php';
?>