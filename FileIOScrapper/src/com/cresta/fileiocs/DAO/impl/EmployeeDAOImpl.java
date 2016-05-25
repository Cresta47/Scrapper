/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cresta.fileiocs.DAO.impl;

import com.cresta.fileiocs.DAO.EmployeeDAO;
import com.cresta.fileiocs.Employee;
import com.cresta.fileiocs.util.CSVHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Arbindra
 */
public class EmployeeDAOImpl implements EmployeeDAO
{ 
    private List<Employee> empList=new ArrayList<Employee>();
    

    @Override
    public void insert(Employee t) {
        empList.add(t);
    }

    @Override
    public List<Employee> getAll() {
        return empList;
    }

    @Override
    public void loadFromFile(String fileName) throws IOException{
        CSVHandler.read(fileName).forEach(e->{
            StringTokenizer tokens=new StringTokenizer(e,",");
            
            if(tokens.countTokens()>=6)
                {
                    Employee employee=new Employee();
                    employee.setId(Integer.parseInt(tokens.nextToken()));
                    employee.setFirstName(tokens.nextToken());
                    employee.setLastName(tokens.nextToken());
                    employee.setEmail(tokens.nextToken());
                    employee.setContactNo(tokens.nextToken());
                    employee.setStatus(Boolean.parseBoolean(tokens.nextToken()));
                
                    insert(employee);
                }
            
        });
    }

    @Override
    public void export(String filename) {
    
    }
    
}
