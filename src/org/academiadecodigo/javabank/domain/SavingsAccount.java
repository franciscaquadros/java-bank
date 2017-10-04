package org.academiadecodigo.javabank.domain;

public class SavingsAccount extends Account{

    private double interestRate;
    public static final int MIN_SAVINGS_BALANCE = 100;

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
        if(this.getBalance()-amount >= MIN_SAVINGS_BALANCE){
            this.setBalance(this.getBalance()-amount);
        }
    }
}
