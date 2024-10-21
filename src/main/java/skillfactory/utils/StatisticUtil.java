package skillfactory.utils;

import skillfactory.enums.StudyProfile;
import skillfactory.models.Statistics;
import skillfactory.models.Student;
import skillfactory.models.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticUtil {

    private StatisticUtil() {};

    public static List<Statistics> collectStatistics(List<Student> students, List<University> universities) {
        return Arrays.stream(StudyProfile.values())
                .map(s -> {
                    List<University> univers = universities.stream()
                            .filter(u -> u.getMainProfile() == s)
                            .collect(Collectors.toList());
                    List<Student> studs = students.stream()
                            .filter(st -> univers.stream().filter(u -> u.getId().equals(st.getUniversityId())).count() > 0)
                            .collect(Collectors.toList());

                    double avg = studs.stream().mapToDouble(Student::getAvgExamScore).average().orElse(0.0);

                    return new Statistics(
                            s,
                            (float)BigDecimal.valueOf(avg).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                            studs.size(),
                            univers.size(),
                            univers.stream().map(University::getShortName).collect(Collectors.toList())
                        );
                })
                .filter(st -> st.getCountUniversitiesByProfile() > 0)
                .collect(Collectors.toList());
    }
}
