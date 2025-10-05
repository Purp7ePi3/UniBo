package it.unibo.bank.api;

public final class AccountHolder{
    
    final public String name;
    final public String surname;
    final public int id;
    public char[] txCount;
    
    public AccountHolder(final String name, final String surname, final int id){
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public int getUserID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AccountHolder {name='" + name + "', surname='" + surname + "', id=" + id + " ";
    }
    
}