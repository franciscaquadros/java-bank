package org.academiadecodigo.javabank.domain;

public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(int id, float rate){
        super(id);
        this.interestRate=rate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void addInterest(){
        this.setBalance(this.getBalance()+interestRate);
    }

    public AccountType getAccountType(){
        return AccountType.SAVINGS;
    }

    @Override
    public void debit(double amount) {
        if(this.getBalance()-amount >= 100){
            this.setBalance(this.getBalance()-amount);
        }
    }
}
