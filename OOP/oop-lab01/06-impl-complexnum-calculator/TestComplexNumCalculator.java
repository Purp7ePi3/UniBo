class TestComplexNumCalculator {
  public static void main(String[] args) {
      /*
       * 1) Testare la classe ComplexNumCalculator con le seguenti operazioni
       *    tra numeri complessi:
       *
       * - add(1+2i, 2+3i) = 3+5i
       *
       * - sub(4+5i, 6+7i) = -2-2i
       *
       * - mul(8+2i, 3-i) = 24 - 2i
       *
       * - ... altre a piacere
       *
       * 2) Verificare il corretto valore dei campi nOpDone, lastRes
       *
       * 3) Fare altre prove con operazioni a piacere
       */
      ComplexNum c1 = new ComplexNum();
      c1.build(1, 2);

      ComplexNum c2 = new ComplexNum();
      c2.build(2, 3);
      c1.add(c2);
      c1.toStringRep();
 
      c1.build(4, 5);
      c2.build(6, 7);
      c1.sub(c2);
      c1.toStringRep();

      c1.build(8, 2);
      c2.build(3, -1);
      c1.mul(c2);
      c1.toStringRep();
      System.out.println("Operazioni fatte su c1: " + c1.nOpDone);
      c1.add(c1);
      System.out.println("Operazioni fatte su c1: " + c1.nOpDone);
      System.out.println("Operazioni fatte su c2: " + c2.nOpDone);

  }
}
