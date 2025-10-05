class dogs implements animal{
    int age;

    public dogs(){
        this.age = 10;

    }

    @Override
    public void noise(){
        System.out.println("Bau Bau");
    }
  
    @Override
    public void eat() {
        System.out.println("Eating dog food...");
    }
}

class cats implements animal{
    int age;

    public cats(){
        this.age = 10;

    }

    @Override
    public void noise(){
        System.out.println("Miao Miao");
    }
  
    @Override
    public void eat() {
        System.out.println("Eating cat food...");
    }
}