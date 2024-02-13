package com.mycode.springboot.aopdemo.dao;


import com.mycode.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOimpl implements AccountDAO{

    private String name;
    private String serviceCode;
    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB work: Adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println("I am doing exercise!");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+": in getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass()+": in setName()");

    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getServiceCode()");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in setServiceCode()");

        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
       return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        // for academic purposes .. simulate an exception
        if(tripWire)
        {
            throw new RuntimeException("No soup for you!!");
        }
        List<Account> myAccounts = new ArrayList<>();
        // create sample accouonts
        Account myAccount1 = new Account("Justine","Diamond");
        Account myAccount2 = new Account("Moe","Gold");
        myAccounts.add(myAccount1);
        myAccounts.add(myAccount2);
        // add them to our accounts list

        return myAccounts;    }
}
