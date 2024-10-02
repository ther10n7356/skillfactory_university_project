package skillfactory.comparators.universites;

import org.apache.commons.lang3.StringUtils;
import skillfactory.comparators.IUniversityComparator;
import skillfactory.models.University;

public class UniversityStudyProfileComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        if (null == o1.getMainProfile()) {
            return 1;
        } else if (null == o2.getMainProfile()) {
            return -1;
        }
        return StringUtils.compare(o1.getMainProfile().getName(), o2.getMainProfile().getName());
    }
}
