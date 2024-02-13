package com.mycode.springboot.cruddemo.rest;

import com.mycode.springboot.cruddemo.dao.EmployeeDAO;
import com.mycode.springboot.cruddemo.entity.Employee;
import com.mycode.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // expose "/employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId)
    {
        Employee  theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }
    // add mapping for POST ./employees - add new employee


    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item .. instead of update
        theEmployee.setId(0);
        Employee employee = employeeService.save(theEmployee);

        return employee;
    }
    // add mapping for PUT /employees - update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }
    // add mapping for Detele /emplpoyees/{employeeId} - to delete an existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee dbEmployee = employeeService.findById(employeeId);

        if(dbEmployee == null)
        {
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - "+employeeId;
    }


}
