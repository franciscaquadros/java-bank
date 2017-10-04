package org.academiadecodigo.javabank.domain;

public class CheckingAccount extends Account {

    private double fee;

    public CheckingAccount(int id, double fee){
        super(id);
        this.fee = fee;
    }

    public double getFee(){
        return fee;
    }

    public void deductFee(){
        if(getBalance()>fee){
            this.setBalance(this.getBalance()-fee);
        }
    }

    public AccountType getAccountType(){
        return AccountType.CHECKING;
    }

}
