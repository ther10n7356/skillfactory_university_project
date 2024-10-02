package skillfactory;

import skillfactory.comparators.IStudentComparator;
import skillfactory.comparators.IUniversityComparator;
import skillfactory.controllers.XssFileController;
import skillfactory.enums.StudentComparatorType;
import skillfactory.enums.UniversityComparatorType;
import skillfactory.models.Student;
import skillfactory.models.University;
import skillfactory.utils.ComparatorUtils;

import java.util.List;

public class UniversityMain {

    public static void main(String[] args) {
        String fileName = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XssFileController.readUniversityInfo(fileName);
        List<Student> students = XssFileController.readStudentInfo(fileName);

        System.out.println("Университеты:");
        IUniversityComparator universityComparator = ComparatorUtils.getUniversityComparator(UniversityComparatorType.STUDY_PROFILE_COMPARATOR);
        universities
                .stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        System.out.println("Студенты:");
        IStudentComparator studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE_COMPARATOR);
        students
                .stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}
