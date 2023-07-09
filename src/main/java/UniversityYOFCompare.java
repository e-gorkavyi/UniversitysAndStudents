public class UniversityYOFCompare implements UniversityComparator {
    @Override
    public int compare(University a, University b) {
        return Integer.compare(a.getYearOfFoundation(), b.getYearOfFoundation());
    }
}
