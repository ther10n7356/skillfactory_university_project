package skillfactory.utils;

import skillfactory.comparators.IStudentComparator;
import skillfactory.comparators.IUniversityComparator;
import skillfactory.comparators.students.StudentAvgExamScoreComparator;
import skillfactory.comparators.students.StudentCourseNumberComparator;
import skillfactory.comparators.students.StudentFullNameComparator;
import skillfactory.comparators.students.StudentUniversityIdComparator;
import skillfactory.comparators.universites.*;
import skillfactory.enums.StudentComparatorType;
import skillfactory.enums.UniversityComparatorType;

public class ComparatorUtils {

    private ComparatorUtils() {}

    public static IStudentComparator getStudentComparator(StudentComparatorType comparator) {
        switch (comparator) {
            case UNIVERSITY_ID_COMPARATOR: return new StudentUniversityIdComparator();
            case COURSE_NUMBER_COMPARATOR: return new StudentCourseNumberComparator();
            case AVG_EXAM_SCORE_COMPARATOR: return new StudentAvgExamScoreComparator();
            default: return new StudentFullNameComparator();
        }
    }

    public static IUniversityComparator getUniversityComparator(UniversityComparatorType comparator) {
        switch (comparator) {
            case ID_COMPARATOR: return new UniversityIdComparator();
            case SHORT_NAME_COMPARATOR: return new UniversityShortNameComparator();
            case STUDY_PROFILE_COMPARATOR: return new UniversityStudyProfileComparator();
            case YEAR_OF_FOUNDATION: return new UniversityYearComparator();
            default: return new UniversityFullNameComparator();
        }
    }
}
