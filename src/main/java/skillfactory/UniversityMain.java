package skillfactory;

import skillfactory.models.Student;
import skillfactory.models.University;

public class UniversityMain {

    public static void main(String[] args) {
        University university = new University.Builder()
                .setId("1")
                .setFullName("Московский государственный университет")
                .setShortName("МГУ")
                .setYearOfFoundation(6)
                .setMainProfile(StudyProfile.PHYLOSOPHY)
                .build();

        Student student = new Student.Builder()
                .setFullName("Иванов Иван")
                .setUniversityId("1")
                .setAvgExamScore(45.5f)
                .setCurrentCourseNumber(2)
                .build();

        System.out.println(university);
        System.out.println(student);
    }
}
