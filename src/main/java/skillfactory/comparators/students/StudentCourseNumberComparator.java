package skillfactory.comparators.students;

import skillfactory.comparators.IStudentComparator;
import skillfactory.models.Student;

public class StudentCourseNumberComparator implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
