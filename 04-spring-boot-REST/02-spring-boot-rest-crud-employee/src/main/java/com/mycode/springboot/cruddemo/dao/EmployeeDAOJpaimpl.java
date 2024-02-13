package com.mycode.springboot.cruddemo.dao;

import com.mycode.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaimpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaimpl(EntityManager theEntityManager)
    { // constructor injection
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        // save employee
        Employee theEmployee = entityManager.merge(employee);
        // return the employee
        return theEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // delete by id
        // find the employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);
        // remove employee
        entityManager.remove(theEmployee);

    }
}
