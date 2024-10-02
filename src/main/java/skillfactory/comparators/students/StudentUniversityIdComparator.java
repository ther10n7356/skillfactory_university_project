package skillfactory.comparators.students;

import org.apache.commons.lang3.StringUtils;
import skillfactory.comparators.IStudentComparator;
import skillfactory.models.Student;

public class StudentUniversityIdComparator implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
