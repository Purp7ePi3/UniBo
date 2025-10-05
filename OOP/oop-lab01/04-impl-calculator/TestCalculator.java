class Calculator{
  int NopDone;
  double lastRes;

  void build(){
    this.NopDone = 0;
    this.lastRes = 0;
  }

  double add(double i, double j){
    this.NopDone++;
    lastRes = i + j;
    return lastRes;
  }

  double sub(double i, double j){
    this.NopDone++;
    lastRes = i - j;
    return lastRes;
  }

  double mul(double i, double j){
    this.NopDone++;
    lastRes = i * j;
    return lastRes;
  }

  double div(double i, double j){
    this.NopDone++;
    lastRes = i / j;
    return lastRes;
  }

}

class TestCalculator {
  public static void main(String[] args) {
	  /*
	   * Uncomment the code below once Calculator has been created!
	   */
	  
      Calculator calc = new Calculator();
      calc.build();
      System.out.println("1 + 2 =" + calc.add(1, 2));
      System.out.println("Operanzioni fatte: " + calc.NopDone + "\tUltimo risulatato: " + calc.lastRes);
      System.out.println("-1 - 2 =" + calc.sub(-1, 2));
      System.out.println("Operanzioni fatte: " + calc.NopDone + "\tUltimo risulatato: " + calc.lastRes);
      System.out.println("6 * 3 =" + calc.mul(6, 3));
      System.out.println("Operanzioni fatte: " + calc.NopDone + "\tUltimo risulatato: " + calc.lastRes);
      System.out.println("8 / 4 =" + calc.div(8, 4));
      System.out.println("Operanzioni fatte: " + calc.NopDone + "\tUltimo risulatato: " + calc.lastRes);
      System.out.println("ciao");
  }
}
