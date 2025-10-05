class ComplexNum {
    /*
     * Inserire qui la dichiarazione dei campi della classe
     */
    double re;
    double im;
    int nOpDone;

    void build(double re, double im) {
        /*
         * Inserire qui l'inizializzazione dei campi con i parametri forniti in input
         */
        this.re = re;
        this.im = im;
    }

    boolean equal(ComplexNum num) {
        /*
         * Implementare il metodo in modo che restituisca true se e solo se il
         * numero complesso è uguale al parametro num passato in input
         */
        if(this.re == num.re && this.im == num.im){
            return true;
        }
        return false;
    }

    void add(ComplexNum num) {
        /*
         * Implementare il metodo in modo che venga aggiunto il numero complesso
         * passato in input - Rif. Appendice A1 (slide)
         */
        this.re = this.re + num.re;
        this.im = this.im + num.im;
        this.nOpDone++;
    }

    void sub(ComplexNum num){
        this.re = this.re - num.re;
        this.im = this.im - num.im; 
        this.nOpDone++;

    }

    void mul(ComplexNum num){
        this.re = this.re * num.re;
        this.im = this.im * num.im;
        this.nOpDone++; 
    }

    String toStringRep() {
        /*
         * Implementare il metodo in modo che restituisca una rappresentazione
         * testuale del numero complesso
         */
        if(this.im > 0){
            System.out.println((int)this.re + "+" + (int)this.im + "i");
        }else{
            System.out.println((int)this.re + "" + (int)this.im + "i");
        }
       
        return "";
    }
}