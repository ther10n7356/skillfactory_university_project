package skillfactory;

import skillfactory.controllers.XssFileController;
import skillfactory.models.Student;
import skillfactory.models.University;

import java.util.List;

public class UniversityMain {

    public static void main(String[] args) {
        String fileName = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XssFileController.readUniversityInfo(fileName);
        List<Student> students = XssFileController.readStudentInfo(fileName);

        System.out.println("Университеты:");
        universities.forEach(System.out::println);

        System.out.println("Студенты:");
        students.forEach(System.out::println);
    }
}
