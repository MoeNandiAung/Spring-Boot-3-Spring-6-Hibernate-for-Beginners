package com.mycode.springboot.aopdemo.dao;

import com.mycode.springboot.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
    public String getName();

    public void setName(String name);
    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    // add a new method: findAccounts()
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);








}
