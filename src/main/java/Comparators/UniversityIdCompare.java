package Comparators;

import Main.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityIdCompare implements UniversityComparator {
    @Override
    public int compare(University a, University b) {
        return StringUtils.compare(a.getId(), b.getId());
    }
}