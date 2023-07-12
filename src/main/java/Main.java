import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resource = Main.class.getResource("universityInfo.xlsx");
        assert resource != null;
        final String FILE_NAME = Paths.get(resource.toURI()).toFile().getAbsolutePath();

        FileInputStream inputStream = new FileInputStream(FILE_NAME);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheetStudents = workbook.getSheet("Студенты");
        XSSFSheet sheetUniversities = workbook.getSheet("Университеты");

        XLSXRead reader = XLSXRead.INSTANCE;

        List<Student> students = reader.getStudents(sheetStudents);
        List<University> universities = reader.getUnivetsities(sheetUniversities);

        StudentComparator studentNameCompare =
                ComparatorFactory.getStudentComparator(StudentCompareType.NAME);
        StudentComparator studentAVGScoreCompare =
                ComparatorFactory.getStudentComparator(StudentCompareType.AVG_SCORE);
        StudentComparator studentCurrCourceCompare =
                ComparatorFactory.getStudentComparator(StudentCompareType.CURRENT_COURSE);
        StudentComparator studentUniversityIDCompare =
                ComparatorFactory.getStudentComparator(StudentCompareType.UNIVERSITY_ID);

        UniversityComparator universityIDCompare =
                ComparatorFactory.getUniversityComparator(UniversityCompareType.ID);
        UniversityComparator universityFullNameCompare =
                ComparatorFactory.getUniversityComparator(UniversityCompareType.FULL_NAME);
        UniversityComparator universityShortNameCompare =
                ComparatorFactory.getUniversityComparator(UniversityCompareType.SHORT_NAME);
        UniversityComparator universityYOFCompare =
                ComparatorFactory.getUniversityComparator(UniversityCompareType.YEAR_OF_FOUNDATION);
        UniversityComparator universityMainProfileCompare =
                ComparatorFactory.getUniversityComparator(UniversityCompareType.MAIN_PROFILE);

//        System.out.println("------------ Students by average score desc --------------");
//        assert studentAVGScoreCompare != null;
//        students.stream().sorted(studentAVGScoreCompare).forEach(System.out::println);
//
//        System.out.println("------------ Universities by year of foundation asc --------------");
//        assert universityYOFCompare != null;
//        universities.stream().sorted(universityYOFCompare).forEach(System.out::println);

        String studentsJSON = JsonUtil.studentCollectionSerialize(students);
        System.out.println(studentsJSON);

        String universityJSON = JsonUtil.universityCollectionSerialize(universities);
        System.out.println(universityJSON);

        List<Student> studentList = JsonUtil.studentCollectionDeserialize(studentsJSON);
        List<University> universityList = JsonUtil.universityCollectionDeserialize(universityJSON);

        if (students.size() == studentList.size())
            System.out.println("Student collection sizes equal");
        else
            System.out.println("Student collection sizes NOT equal");

        if (universities.size() == universityList.size())
            System.out.println("Student collection sizes equal");
        else
            System.out.println("Student collection sizes NOT equal");

        students.stream().forEach(e ->
            {
                String s = JsonUtil.studentSerialize(e);
                System.out.println(s);
                System.out.println(JsonUtil.studentDeserialize(s));
            }
        );
        universities.stream().forEach(e ->
                {
                    String u = JsonUtil.universitySerialize(e);
                    System.out.println(u);
                    System.out.println(JsonUtil.universityDeserialize(u));
                }
        );
    }
}
