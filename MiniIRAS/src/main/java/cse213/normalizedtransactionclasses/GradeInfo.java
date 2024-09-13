package cse213.normalizedtransactionclasses;

public class GradeInfo {
    private String courseId, gradeReceived, semester;
    private int studentId, year;

    public GradeInfo() {
    }

    public GradeInfo(String courseId, String gradeReceived, String semester, int studentId, int year) {
        this.courseId = courseId;
        this.gradeReceived = gradeReceived;
        this.semester = semester;
        this.studentId = studentId;
        this.year = year;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGradeReceived() {
        return gradeReceived;
    }

    public void setGradeReceived(String gradeReceived) {
        this.gradeReceived = gradeReceived;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "GradeInfo{" +
                "courseId='" + courseId + '\'' +
                ", gradeReceived='" + gradeReceived + '\'' +
                ", semester='" + semester + '\'' +
                ", studentId=" + studentId +
                ", year=" + year +
                '}';
    }
}
