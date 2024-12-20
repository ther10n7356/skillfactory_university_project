package skillfactory.comparators.universites;

import skillfactory.comparators.IUniversityComparator;
import skillfactory.models.University;

public class UniversityShortNameComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
