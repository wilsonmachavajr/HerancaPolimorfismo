package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class ProgramHeranca {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Wilson", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        //UPCASTING - converter um objecto da subclasse para superclasse
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Katia", 1000.0, 500.0);
        Account acc3 = new SavingsAccount(1004, "Elpidia", 700.0, 0.01);

        //DOWNCASTING - converter um objecto da superclasse para subclasse
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        //BusinessAccount acc5 = (BusinessAccount) acc3;
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update");
        }

    }
}