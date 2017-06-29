package com.xyz.employeeadb;

/**
 * Created by Rashmi Chhabria on 9/28/2016.
 */
public class Employee {

    private int eid;
    private String ename;

    public Employee() {
    }

    public Employee(int eid, String ename) {
        this.eid = eid;
        this.ename = ename;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
