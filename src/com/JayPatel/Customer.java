package com.JayPatel;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Double> transactions;
    private String name;


    public Customer(String customerName, Double initialAmount) {
        this.name = customerName;
        this.transactions = new ArrayList<Double>();
        addMoney(initialAmount);
    }

    public void addMoney(Double amount){
        this.transactions.add(amount);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }


    
   //  public static Customer createContact(String name, Double amount){
   //     return new Customer(name, amount);
   // }
}
