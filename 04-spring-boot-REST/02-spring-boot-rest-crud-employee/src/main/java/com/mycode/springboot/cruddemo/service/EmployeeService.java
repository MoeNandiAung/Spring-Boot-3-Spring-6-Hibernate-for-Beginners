package com.mycode.springboot.cruddemo.service;

import com.mycode.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee save(Employee theEmployee);

    void deleteById(Integer id);
}
