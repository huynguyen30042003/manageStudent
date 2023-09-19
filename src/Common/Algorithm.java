package Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import Model.StudentInfomation;

public class Algorithm {
    public static boolean isContinue() {
        String isNext;
        do {
            isNext = Library.validString("Do you want to continue (Y/N)? ");
        } while (!isNext.equalsIgnoreCase("Y") && !isNext.equalsIgnoreCase("N"));
        return isNext.equalsIgnoreCase("Y");
    }

    public static ArrayList<StudentInfomation> searchByName(ArrayList<StudentInfomation> dataStudent, String target) {
        ArrayList<StudentInfomation> result = new ArrayList<>();
        for (StudentInfomation student : dataStudent) {
            if (student.getStudentName().toLowerCase().contains(target.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    public static ArrayList<StudentInfomation> searchBysourse(ArrayList<StudentInfomation> dataStudent, String target) {
        ArrayList<StudentInfomation> result = new ArrayList<>();
        for (StudentInfomation student : dataStudent) {
            if (student.getCourseName().toLowerCase().contains(target.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    public static Integer searchByID(ArrayList<StudentInfomation> dataStudent, String target) {
        for (int i = 0; i < dataStudent.size(); i++) {
            if (dataStudent.get(i).getStudentId().toLowerCase().contains(target.toLowerCase())) {
                return i;
            }
        }
        return null;
    }

    public static boolean isUpdateOrDelete() {
        String isNext;
        do {
            isNext = Library.validString("Do you want to update (U) or delete (D) student?");
        } while (!isNext.equalsIgnoreCase("U") && !isNext.equalsIgnoreCase("D"));
        return isNext.equalsIgnoreCase("U");
    }

    public static ArrayList<StudentInfomation> searchById(ArrayList<StudentInfomation> dataStudent, String target) {
        ArrayList<StudentInfomation> result = new ArrayList<>();
        for (StudentInfomation student : dataStudent) {
            if (student.getStudentId().toLowerCase().contains(target.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }// tra ve 1 mang cac phan tu cung id

    public static void report(ArrayList<StudentInfomation> dataStudent) {
        ArrayList<String> studentIds = new ArrayList<>();
        for (StudentInfomation student : dataStudent) {
            String studentId = student.getStudentId();
            if (!studentIds.contains(studentId)) {
                studentIds.add(studentId);
            }
        }
        System.out.println(studentIds);
        for (String id : studentIds) {
            ArrayList<StudentInfomation> listId = searchById(dataStudent, id);
            int sourseJava = searchBysourse(listId, "Java").size();
            int sourseC = searchBysourse(listId, "C/C++").size();
            int sourseNet = searchBysourse(listId, ".Net").size();

            if (sourseJava != 0) {
                System.out.println(listId.get(0).getStudentName() + "|Java|" + sourseJava);
            }
            if (sourseC != 0) {
                System.out.println(listId.get(0).getStudentName() + "|C/C++|" + sourseC);
            }
            if (sourseNet != 0) {
                System.out.println(listId.get(0).getStudentName() + "|.Net|" + sourseNet);
            }

        }
    }
}