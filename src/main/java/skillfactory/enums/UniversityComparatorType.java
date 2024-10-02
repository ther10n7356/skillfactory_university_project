package skillfactory.enums;

import skillfactory.comparators.IUniversityComparator;
import skillfactory.comparators.universites.UniversityFullNameComparator;
import skillfactory.comparators.universites.UniversityIdComparator;
import skillfactory.comparators.universites.UniversityShortNameComparator;
import skillfactory.comparators.universites.UniversityStudyProfileComparator;

public enum UniversityComparatorType {
    ID_COMPARATOR,
    FULL_NAME_COMPARATOR,
    SHORT_NAME_COMPARATOR,
    YEAR_OF_FOUNDATION,
    STUDY_PROFILE_COMPARATOR;
}
