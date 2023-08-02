import Statistics.*;
import XLSX.XLSXRead;
import Main.*;
import XLSX.XLSXWriter;
import org.apache.poi.EmptyFileException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
        logger.info("--- Application started. ---");
        URL resource = Main.class.getResource("universityInfo.xlsx");
        assert resource != null;
        final String FILE_NAME = Paths.get(resource.toURI()).toFile().getAbsolutePath();
        try {
            FileInputStream inputStream = new FileInputStream(FILE_NAME);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheetStudents = workbook.getSheet("Студенты");
            XSSFSheet sheetUniversities = workbook.getSheet("Университеты");

            XLSXRead reader = XLSXRead.INSTANCE;

            List<Student> students = reader.getStudents(sheetStudents);
            List<University> universities = reader.getUnivetsities(sheetUniversities);

            List<Statistics> statistics = StatCalc.calculation(students, universities);

            XLSXWriter xlsxWriter = XLSXWriter.INSTANCE;
            xlsxWriter.create(statistics, "out/statistics.xlsx");
        } catch (FileNotFoundException e) {
            logger.error("Input file not found, exit.");
            System.exit(1);
        } catch (EmptyFileException e) {
            logger.error("File is empty or blocked.");
        }

        logger.info("--- Application finished. ---");
    }
}
