import java.util.Scanner;

class number{
    int number = 0;
    int ntry = 0;
    
    void build(int n){
        switch (n) {
            case 1:
                this.number = (int)(Math.random() * 10 + 1);
                this.ntry = 5;
                System.out.println("You got " + this.ntry + " trys between 10 numbers");
                break;
            case 2:
                this.number = (int)(Math.random() * 15 + 1);
                this.ntry = 5;
                System.out.println("You got " + this.ntry + " trys between 15 numbers");
                break;
            case 3:
                this.number = (int)(Math.random() * 20 + 1);
                this.ntry = 5;
                System.out.println("You got " + this.ntry + " trys between 20 numbers");
                break;
            default:
                break;
        }
    }

    int guessed(int g){
        if(g < this.number){
            return 0;
        }if (g > this.number) {
            return 1;
        } else {
            return 2;
        }
    }

    void wrong(){
        this.ntry--;
    }

}


public class GuessTheNumber{
    public static void main(String[] args){
        number guess = new number();
        guess.number = 0;
        guess.ntry = 0;
        Scanner scanner = new Scanner(System.in);
        int diff = 0;
        System.out.print("Enter a number between 1 and 3: ");

        while (diff < 1 || diff > 3) {
            
            if(scanner.hasNextInt()){
                diff= scanner.nextInt();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                if(diff < 1 || diff > 3){
                    System.out.println("Enter a valid number between 1 and 3: ");
                }
                guess.build(diff);
            }else{
                System.out.println("Gimme a number");
                scanner.nextInt();
            }
        }
        System.out.println("Guess number is: " + guess.number);

        while(guess.ntry > 0){
            int find = scanner.nextInt();
            int r = guess.guessed(find);
            //Zio cane le avevo inveritte  e non andava nulla, stavo diventato scemo
            if (r == 0){ System.out.println("Higher than " + find + ", You still have: " + (guess.ntry-1) + " attempts" ); }
            if (r == 1){ System.out.println("Lower than " + find + ", you still have: " + (guess.ntry-1) + " attempts" ); }
            guess.wrong();
            if (r == 2){ System.out.println("Right!! You won with " + (guess.ntry) + " attempts left"); break; }

        }

        scanner.close(); 
    }
}