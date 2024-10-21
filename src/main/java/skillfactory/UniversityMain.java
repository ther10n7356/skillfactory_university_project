package skillfactory;

import skillfactory.comparators.IStudentComparator;
import skillfactory.comparators.IUniversityComparator;
import skillfactory.controllers.XssFileController;
import skillfactory.enums.StudentComparatorType;
import skillfactory.enums.UniversityComparatorType;
import skillfactory.models.Statistics;
import skillfactory.models.Student;
import skillfactory.models.University;
import skillfactory.utils.ComparatorUtils;
import skillfactory.utils.JsonUtil;
import skillfactory.utils.StatisticUtil;
import skillfactory.writers.XlsWriter;

import java.util.List;

public class UniversityMain {

    public static void main(String[] args) {
        String fileName = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XssFileController.readUniversityInfo(fileName);
        List<Student> students = XssFileController.readStudentInfo(fileName);
        System.out.println("=================================");
        System.out.println("=List of student in json format:=");
        System.out.println("=================================");
        String jsonStudents = JsonUtil.getJsonFromListStudents(students);
        System.out.println(jsonStudents);
        List<Student> newStudents = JsonUtil.getListStudentsFromJson(jsonStudents);
        System.out.println(String.format("Equals old and new collections: %s", students.size() == newStudents.size()));

        System.out.println("List of university in json format:");
        String jsonUniversities = JsonUtil.getJsonFromListUniversities(universities);
        System.out.println(jsonUniversities);
        List<University> newUniversities = JsonUtil.getListUniversitiesFromJson(jsonUniversities);
        System.out.println(String.format("Equals old and new collections: %s", universities.size() == newUniversities.size()));

        universities.forEach(u -> {
            String json = JsonUtil.getJsonFromUniversity(u);
            System.out.println(json);
            System.out.println(JsonUtil.getUniversityFromJson(json));
        });

        students.forEach(s -> {
            String json = JsonUtil.getJsonFromStudent(s);
            System.out.println(json);
            System.out.println(JsonUtil.getStudentFromJson(json));
        });

        System.out.println("============================");
        System.out.println("=        Статистика:       =");
        System.out.println("============================");
        List<Statistics> statistics = StatisticUtil.collectStatistics(students, universities);
        XlsWriter.generateXlsFile(statistics, "statistics.xlsx");

        System.out.println("============================");
        System.out.println("=       Университеты:      =");
        System.out.println("============================");
        IUniversityComparator universityComparator = ComparatorUtils.getUniversityComparator(UniversityComparatorType.STUDY_PROFILE_COMPARATOR);
        universities
                .stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
        System.out.println("============================");
        System.out.println("=        Студенты:         =");
        System.out.println("============================");
        IStudentComparator studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE_COMPARATOR);
        students
                .stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}
