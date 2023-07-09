import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.Iterator;

public class XLSXRead {
    private XLSXRead() {}

    public static final XLSXRead INSTANCE = new XLSXRead();

    public ArrayList<Student> getStudents(XSSFSheet studentsSheet) {
        ArrayList<Student> students = new ArrayList<>();

        Iterator<Row> iteratorStudents = studentsSheet.iterator();
        iteratorStudents.next();

        Row studentRow;
        while(iteratorStudents.hasNext()) {
            studentRow = iteratorStudents.next();
            students.add(new Student(
                    studentRow.getCell(1).getStringCellValue(),
                    studentRow.getCell(0).getStringCellValue(),
                    (int) studentRow.getCell(2).getNumericCellValue(),
                    (float) studentRow.getCell(3).getNumericCellValue()
            ));
        }

        return students;
    }

    public ArrayList<University> getUnivetsities(XSSFSheet universitiesSheet) {
        ArrayList<University> universities = new ArrayList<>();

        Iterator<Row> iteratorUniversities = universitiesSheet.iterator();
        iteratorUniversities.next();

        Row universityRow;
        while ((iteratorUniversities.hasNext())) {
            universityRow = iteratorUniversities.next();
            universities.add(new University(
                    universityRow.getCell(0).getStringCellValue(),
                    universityRow.getCell(1).getStringCellValue(),
                    universityRow.getCell(2).getStringCellValue(),
                    (int) universityRow.getCell(3).getNumericCellValue(),
                    StudyProfile.valueOf(universityRow.getCell(4).getStringCellValue())
            ));
        }

        return universities;
    }
}
