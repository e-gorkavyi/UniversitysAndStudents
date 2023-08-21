package XLSX;

import Statistics.Statistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class XLSXWriter {
    public static final XLSXWriter INSTANCE = new XLSXWriter();
    protected static final Logger logger = LogManager.getLogger();

    private XLSXWriter() {
    }

    public void create(List<Statistics> statistics, String filePath) throws IOException {
        String[] headers = {
                "Профиль",
                "Средний балл",
                "Студентов по профилю",
                "ВУЗов по профилю",
                "Наименования ВУЗов"
        };

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statSheet = workbook.createSheet("Статистика");

        XSSFCellStyle headerCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setItalic(true);
        font.setFontHeightInPoints((short) 11);
        headerCellStyle.setFont(font);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

        // Headers creation
        Row row = statSheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(headers[i]);
        }

        // Fill data to the table
        int rowNum = 1;
        for (Statistics statFields : statistics) {
            Row dataRow = statSheet.createRow(rowNum++);

            dataRow.createCell(0).setCellValue(statFields.getStudyProfile().toString());
            dataRow.createCell(1).setCellValue(statFields.getAvgExamScore());
            dataRow.createCell(2).setCellValue(statFields.getStudentsByProfile());
            dataRow.createCell(3).setCellValue(statFields.getUniversitiesByProfile());

            String uNames = "";
            Iterator<String> uNameIterator = statFields.getUniversitiesNames().iterator();
            while (uNameIterator.hasNext()) {
                uNames = uNames.concat(uNameIterator.next());
                if (uNameIterator.hasNext())
                    uNames = uNames.concat("; ");
            }
            dataRow.createCell(4).setCellValue(uNames);
        }

        // Auto width for columns
        for (int i = 0; i < headers.length; i++) {
            statSheet.autoSizeColumn(i);
        }

        try {
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            logger.error("File writing error.");
            System.exit(1);
        }

        logger.info("Output file written successfully.");
    }
}
