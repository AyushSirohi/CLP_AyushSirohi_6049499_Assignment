package cg.demo.task3;

import java.util.List;

public class SBU {

    private String sbuCode;
    private String sbuName;
    private String sbuHead;
    private List<Employee> empList;

    public SBU() {
    }

    public String getSbuCode() {
        return sbuCode;
    }

    public void setSbuCode(String sbuCode) {
        this.sbuCode = sbuCode;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public void showSbuDetails() {
        System.out.println("SBU details");
        System.out.println("---------------------");
        System.out.println("sbuCode=" + sbuCode + ", sbuHead=" + sbuHead + ", sbuName=" + sbuName);
        System.out.println("Employee details:");
        System.out.println(empList);
    }
}