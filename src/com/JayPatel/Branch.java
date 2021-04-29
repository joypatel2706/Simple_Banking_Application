package com.JayPatel;

import java.util.ArrayList;

public class Branch {

  String name;
  ArrayList<Customer> customers;

  public Branch(String name) {
    this.name = name;
    this.customers = new  ArrayList<Customer>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Customer> getCustomers() {
    return customers;
  }

  public boolean newCustomer(String customerName, double amount){
    if (findCustomer(customerName) == null){
      this.customers.add(new Customer(customerName,amount));
      return true;
    }
    return false;
  }

  public boolean addCustomerTransaction(String name,double amount){
    Customer existingCustomer = findCustomer(name);
    if (existingCustomer != null){
      existingCustomer.addMoney(amount);
      return true;
    }
    return false;
  }

  private Customer findCustomer(String name){

    for (int i=0;i<this.customers.size();i++){
      Customer checkedCustomer = this.customers.get(i);
      if (checkedCustomer.getName().equals(name)){
        return checkedCustomer;
      }
    }
    return null;
  }


}