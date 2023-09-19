package Model;

import java.util.ArrayList;

import Common.Library;

public class StudentInfomation {
    private String studentId;
    private String studentName;
    private int semester;
    private String courseName;

    public StudentInfomation() {

    }

    public StudentInfomation(String studentId, String studentName, int semester, String courseName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void input(ArrayList<StudentInfomation> dataStudent) {
        setStudentId(Library.validStudentID("Input valid student id", dataStudent));
        setStudentName(Library.validString("Input valid student name"));
        setSemester(Library.getInt("Input valid semester", 1, 10));
        setCourseName(Library.validSourse("Input valid sourse"));
    }

    @Override
    public String toString() {
        return "StudentInfomation [studentId=" + studentId + ", studentName=" + studentName + ", semester=" + semester
                + ", courseName=" + courseName + "]";
    }
}
