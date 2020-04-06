/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Jessie
 */
public class Employee {
    private int id;
    private String name;
    private ArrayList<Certificate> cert;

    public Employee() {
    }

    public Employee(int id, String name, ArrayList<Certificate> cert) {
        this.id = id;
        this.name = name;
        this.cert = cert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Certificate> getCert() {
        return cert;
    }

    public void setCert(ArrayList<Certificate> cert) {
        this.cert = cert;
    }
    
    
}
