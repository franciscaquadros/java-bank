package org.academiadecodigo.javabank.test;

public class Test {

    public static void main(String[] args) {

        CheckingAccountTest checkingaccountTest = new CheckingAccountTest();
        SavingsAccountTest savingsAccountTest = new SavingsAccountTest();
        CustomerTest customerTest = new CustomerTest();
        BankTest bankTest = new BankTest();

        System.out.println("CheckingAccount: " + (checkingaccountTest.test() ? "OK" : "FAIL"));
        System.out.println("SavingsAccount: " + (savingsAccountTest.test() ? "OK" : "FAIL"));
        System.out.println("Customer: " + (customerTest.test() ? "OK" : "FAIL"));
        System.out.println("Bank: " + (bankTest.test() ? "OK" : "FAIL"));

    }


}
