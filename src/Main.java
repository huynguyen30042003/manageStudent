import Controller.StudentManage;
import Model.StudentInfomation;

public class Main {
    public static void main(String[] args) {
        StudentInfomation studentInfomation = new StudentInfomation();
        new StudentManage(studentInfomation).run();
    }
}