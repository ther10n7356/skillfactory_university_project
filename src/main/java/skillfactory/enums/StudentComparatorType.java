package skillfactory.enums;

import skillfactory.comparators.IStudentComparator;
import skillfactory.comparators.students.StudentAvgExamScoreComparator;
import skillfactory.comparators.students.StudentCourseNumberComparator;
import skillfactory.comparators.students.StudentFullNameComparator;
import skillfactory.comparators.students.StudentUniversityIdComparator;

public enum StudentComparatorType {
    FULL_NAME_COMPARATOR,
    COURSE_NUMBER_COMPARATOR,
    UNIVERSITY_ID_COMPARATOR,
    AVG_EXAM_SCORE_COMPARATOR;
}
