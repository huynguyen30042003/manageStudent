package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Common.Algorithm;
import Common.Library;
import Model.StudentInfomation;
import View.Menu;

public class StudentManage extends Menu<String> {
    static String[] options = { "Create", "Find and Sort", "Update/Delete", "Report", "Exit" };

    ArrayList<StudentInfomation> dataStudent = new ArrayList<StudentInfomation>();

    protected Library library;
    protected Algorithm algorithm;

    public StudentManage(StudentInfomation studentInfomation) {
        super("WELCOME TO STUDENT MANAGEMENT", options);

    }

    @Override
    public void execute(int n) {

        switch (n) {
            case 1:
                System.out.println(options[n - 1]);
                while (true) {
                    if (dataStudent.size() < 10) {
                        StudentInfomation studentInfomation = new StudentInfomation();
                        System.out.println("student " + (dataStudent.size() + 1) + "th");
                        studentInfomation.input(dataStudent);
                        dataStudent.add(studentInfomation);
                    } else if (Algorithm.isContinue()) {
                        StudentInfomation studentInfomation = new StudentInfomation();
                        System.out.println("student " + (dataStudent.size() + 1) + "th");
                        studentInfomation.input(dataStudent);
                        dataStudent.add(studentInfomation);
                    } else {
                        break;
                    }
                }
                break;
            case 2:
                System.out.println(options[n - 1]);
                String target;
                target = Library.validString("Input valid search");
                ArrayList<StudentInfomation> findNameArrayList = Algorithm.searchByName(dataStudent, target);
                Collections.sort(findNameArrayList, new Comparator<StudentInfomation>() {
                    @Override
                    public int compare(StudentInfomation o1, StudentInfomation o2) {
                        return o1.getStudentName().compareTo(o2.getStudentName());
                    }
                });
                System.out.println(findNameArrayList);
                break;
            case 3:
                System.out.println(options[n - 1]);
                String targetId;
                targetId = Library.validString("Input valid ID");
                int indexId = Algorithm.searchByID(dataStudent, targetId);
                System.out.println(dataStudent.get(indexId));
                if (Algorithm.isUpdateOrDelete()) {
                    StudentInfomation studentInfomation = new StudentInfomation();
                    System.out.println("Input valid update");
                    studentInfomation.input(dataStudent);
                    dataStudent.set(indexId, studentInfomation);
                } else {
                    dataStudent.remove(indexId);
                }
                System.out.println(dataStudent);
                break;
            case 4:
                System.out.println(options[n - 1]);
                Collections.sort(dataStudent, new Comparator<StudentInfomation>() {
                    @Override
                    public int compare(StudentInfomation o1, StudentInfomation o2) {
                        return o1.getStudentId().compareTo(o2.getStudentId());
                    }
                });
                Algorithm.report(dataStudent);
                break;
            case 5:
                System.out.println(options[n - 1]);
                System.exit(0);
                break;
        }
    }

}
