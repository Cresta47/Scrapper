/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cresta.fileiocs;

import com.cresta.fileiocs.DAO.StudentDAO;
import com.cresta.fileiocs.DAO.impl.StudentDAOImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Arbindra
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       StudentDAO stdDAO=new StudentDAOImpl();
       
        try {
            stdDAO.loadFromFile("students.csv");
            stdDAO.getAll().forEach(e->{
                System.out.println(e.toString());
            });
            stdDAO.insert(new Student(stdDAO.getAll().size()+1,"kutta","","","",false));
            stdDAO.export("students1.csv");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
    
}
}