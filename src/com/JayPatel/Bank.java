package com.JayPatel;
import java.util.ArrayList;

public class Bank {

    String name;
    ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches =new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName)== null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName , double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null ){
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double amount){
        Branch branch =findBranch(branchName);
        if(branch !=null){
            branch.addCustomerTransaction(customerName,amount);
            return true;
        }
        return false;
    }

    private Branch findBranch(String Branchname){

        for (int i=0;i<this.branches.size();i++){
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(Branchname)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean transactionDetails){
        Branch branch =  findBranch(branchName);
        if (branch != null){

            System.out.println("List of customers of branch "+ branch.getName() );
            ArrayList<Customer> customers = branch.getCustomers();

            for (int i=0; i < customers.size(); i++) {
                System.out.println("Customer " + customers.get(i) + "[" + i+1 +"]");
                if (transactionDetails){
                    ArrayList<Double> transactions = customers.get(i).getTransactions();
                    for (int j=0; j < transactions.size() ; j++ ){
                        System.out.println("[" + (j+1) + "] Amount: "+ transactions.get(j));
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }
}