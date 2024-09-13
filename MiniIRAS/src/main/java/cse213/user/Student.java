package cse213.user;

import cse213.normalizedtransactionclasses.GradeInfo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends User implements Serializable {
    protected String studDept, major, minor;
    protected float cgpa;
    protected int advisorId;

    public Student() {
    }

    public Student(int id, String name, String gender, String email, LocalDate dob, LocalDate doj, String studDept, String major, String minor, float cgpa, int advisorId) {
        super(id, name, gender, email, dob, doj);
        this.studDept = studDept;
        this.major = major;
        this.minor = minor;
        this.cgpa = cgpa;
        this.advisorId = advisorId;
    }

    public String getStudDept() {
        return studDept;
    }

    public void setStudDept(String studDept) {
        this.studDept = studDept;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(int advisorId) {
        this.advisorId = advisorId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", gender=" + gender + "\n" +
                //", pw='" + pw + '\'' +
                ", email=" + email +
                //", userType='" + userType + '\'' +
                ", dob=" + dob +
                ", doj=" + doj + "\n" +
                ", studDept=" + studDept +
                ", major=" + major +
                ", minor=" + minor + "\n" +
                ", cgpa=" + cgpa +
                ", advisorId=" + advisorId +
                '}';
    }
}
