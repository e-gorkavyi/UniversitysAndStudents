public class StudentCurrentCourseNumberCompare implements StudentComparator{
    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(a.getCurrentCourseNumber(), b.getCurrentCourseNumber());
    }
}
