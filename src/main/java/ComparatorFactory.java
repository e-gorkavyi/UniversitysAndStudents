public class ComparatorFactory {
    public static StudentComparator getStudentComparator(StudentCompareType compareType) {
        switch (compareType) {
            case NAME -> {
                return new StudentNameCompare();
            }
            case AVG_SCORE -> {
                return new StudentAvgExamScoreCompare();
            }
            case UNIVERSITY_ID -> {
                return new StudentUniversityIdCompare();
            }
            case CURRENT_COURSE -> {
                return new StudentCurrentCourseNumberCompare();
            }
        }
        return null;
    }

    public static UniversityComparator getUniversityComparator(UniversityCompareType compareType) {
        switch (compareType) {
            case ID -> {
                return new UniversityIdCompare();
            }
            case FULL_NAME -> {
                return new UniversityFullNameCompare();
            }
            case SHORT_NAME -> {
                return new UniversityShortNameCompare();
            }
            case YEAR_OF_FOUNDATION -> {
                return new UniversityYOFCompare();
            }
            case MAIN_PROFILE -> {
                return new UniversityMainProfileCompare();
            }
        }
        return null;
    }
}
