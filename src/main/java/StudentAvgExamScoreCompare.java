public class StudentAvgExamScoreCompare implements StudentComparator {
    @Override
    public int compare(Student a, Student b) {
        return Float.compare(b.getAvgExamScore(), a.getAvgExamScore());
    }
}
