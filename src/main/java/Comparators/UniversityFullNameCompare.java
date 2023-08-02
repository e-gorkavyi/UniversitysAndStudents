package Comparators;

import Main.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityFullNameCompare implements UniversityComparator {
    @Override
    public int compare(University a, University b) {
        return StringUtils.compare(a.getFullName(), b.getFullName());
    }
}
