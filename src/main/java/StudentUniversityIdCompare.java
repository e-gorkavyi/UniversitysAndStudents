import org.apache.commons.lang3.StringUtils;

public class StudentUniversityIdCompare implements StudentComparator{
    @Override
    public int compare(Student a, Student b) {
        return StringUtils.compare(a.getUniversityId(), b.getUniversityId());
    }
}
