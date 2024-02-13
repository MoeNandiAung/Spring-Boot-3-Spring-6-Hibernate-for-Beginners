package com.mycode.springboot.aopdemo.dao;

import com.mycode.springboot.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
