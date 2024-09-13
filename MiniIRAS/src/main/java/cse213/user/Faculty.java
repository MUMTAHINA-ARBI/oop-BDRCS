package cse213.user;

import java.io.Serializable;
import java.time.LocalDate;

public class Faculty extends Employee implements Researcher, Serializable {

    private int noOfPublications;

    public Faculty() {
    }

    public Faculty(int noOfPublications) {
        this.noOfPublications = noOfPublications;
    }

    public Faculty(int id, String name, String gender, String email, LocalDate dob, LocalDate doj, String designation, String dept, float salary, int noOfPublications) {
        super(id, name, gender, email, dob, doj, designation, dept, salary);
        this.noOfPublications = noOfPublications;
    }

    public int getNoOfPublications() {
        return noOfPublications;
    }

    public void setNoOfPublications(int noOfPublications) {
        this.noOfPublications = noOfPublications;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", doj=" + doj +
                ", designation='" + designation + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", noOfPublications=" + noOfPublications +
                '}';
    }

    @Override
    public void applyForLeave(){
        //
    }

    @Override
    public void prepareResearchReport(){
        //
    }
}
