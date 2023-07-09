import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

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

        ArrayList<Student> students = reader.getStudents(sheetStudents);
        ArrayList<University> universities = reader.getUnivetsities(sheetUniversities);

        System.out.println("---------------- Students: -------------");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("---------------- Universities: -------------");
        for (University university : universities) {
            System.out.println(university);
        }
    }
}
