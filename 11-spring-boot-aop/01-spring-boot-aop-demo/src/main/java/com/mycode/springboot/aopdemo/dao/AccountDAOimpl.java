package com.mycode.springboot.aopdemo.dao;


import com.mycode.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOimpl implements AccountDAO{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB work: Adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println("I am doing exercise!");
        return false;
    }
}
