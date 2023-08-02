package Comparators;

import Main.University;

public class UniversityMainProfileCompare implements UniversityComparator {
    @Override
    public int compare(University a, University b) {
        return a.getMainProfile().compareTo(b.getMainProfile());
    }
}
