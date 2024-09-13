package cse213.user;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee extends User implements TaxPayer, Serializable {
    protected String designation, dept;
    protected float salary;

    public Employee() {
        //
    }

    public Employee(String designation, String dept, float salary) {
        this.designation = designation;
        this.dept = dept;
        this.salary = salary;
    }

    public Employee(int id, String name, String gender, String email, LocalDate dob, LocalDate doj, String designation, String dept, float salary) {
        super(id, name, gender, email, dob, doj);
        this.designation = designation;
        this.dept = dept;
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", doj=" + doj +
                ", designation='" + designation + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void applyForLoan(){
        //
    }
    public abstract void applyForLeave();

    @Override
    public Float calculateAndGetTaxPayable(){
        Float val = 0.0f;
        //
        return val;
    }

}
