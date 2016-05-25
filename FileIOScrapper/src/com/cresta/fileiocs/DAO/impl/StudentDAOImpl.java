/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cresta.fileiocs.DAO.impl;

import com.cresta.fileiocs.DAO.StudentDAO;
import com.cresta.fileiocs.Student;
import com.cresta.fileiocs.Student;
import com.cresta.fileiocs.util.CSVHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Arbindra
 */
public class StudentDAOImpl implements StudentDAO
{ 
    private List<Student> studentList=new ArrayList<Student>();
    

    @Override
    public void insert(Student t) {
        studentList.add(t);
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void loadFromFile(String fileName) throws IOException {
        CSVHandler.read(fileName).forEach(e->{
            StringTokenizer tokens=new StringTokenizer(e,",");
            
            if(tokens.countTokens()>=6)
                {
                    Student s=new Student();
                    s.setId(Integer.parseInt(tokens.nextToken()));
                    s.setFirstName(tokens.nextToken());
                    s.setLastName(tokens.nextToken());
                    s.setEmail(tokens.nextToken());
                    s.setContactNo(tokens.nextToken());
                    s.setStatus(Boolean.parseBoolean(tokens.nextToken()));
                
                    insert(s);
                }
            
        });
    }

    @Override
    public void export(String filename) throws IOException{
        StringBuilder builder=new StringBuilder();
        for(Student s:studentList)
        {
            builder.append(s.toCSV());
        }
        CSVHandler.write(filename,builder.toString());
    }
    
}
