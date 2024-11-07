package skillfactory;

import skillfactory.comparators.IStudentComparator;
import skillfactory.comparators.IUniversityComparator;
import skillfactory.controllers.XssFileController;
import skillfactory.enums.StudentComparatorType;
import skillfactory.enums.UniversityComparatorType;
import skillfactory.models.EducationInfo;
import skillfactory.models.Statistics;
import skillfactory.models.Student;
import skillfactory.models.University;
import skillfactory.utils.ComparatorUtils;
import skillfactory.utils.JsonUtil;
import skillfactory.utils.StatisticUtil;
import skillfactory.writers.JsonWriter;
import skillfactory.writers.XlsWriter;
import skillfactory.writers.XmlWriter;

import java.io.IOException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class UniversityMain {

    private final static Logger log = Logger.getLogger(University.class.getName());

    public static void main(String[] args) {
        try {
            LogManager
                    .getLogManager()
                    .readConfiguration(
                    UniversityMain.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            log.log(Level.SEVERE, "Could not setup logger configuration: ", e);
        }

        log.info("Application starting");
        String fileName = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XssFileController.readUniversityInfo(fileName);
        List<Student> students = XssFileController.readStudentInfo(fileName);

        List<Statistics> statistics = StatisticUtil.collectStatistics(students, universities);
        XlsWriter.generateXlsFile(statistics, "statistics.xlsx");

        IUniversityComparator universityComparator = ComparatorUtils.getUniversityComparator(UniversityComparatorType.STUDY_PROFILE_COMPARATOR);
        IStudentComparator studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE_COMPARATOR);

        XmlWriter xmlWriter = new XmlWriter();
        EducationInfo educationInfo = new EducationInfo()
                .setStudents(students)
                .setUniversities(universities)
                .setLisOfStatistics(statistics);

        xmlWriter.generateFile(educationInfo, "src/main/resources");

        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.generateFile(educationInfo, "src/main/resources");
        log.info("Application finished");
    }
}
