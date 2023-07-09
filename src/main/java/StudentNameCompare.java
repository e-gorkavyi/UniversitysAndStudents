import org.apache.commons.lang3.StringUtils;

public class StudentNameCompare implements StudentComparator{
    @Override
    public int compare(Student a, Student b) {
        return StringUtils.compare(a.getFullName(), b.getFullName());
    }
}
