package skillfactory.writers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import skillfactory.models.Statistics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    private XlsWriter() {};

    public static void generateXlsFile(List<Statistics> statistics, String pathFile){
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Статистика");
        Row header = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 11);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Profile");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Exam Score");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Students count");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Universities count");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("Universities");
        headerCell.setCellStyle(headerStyle);

        Row row = null;

        for (int i = 0; i < statistics.size(); i++) {
            row = sheet.createRow(i+1);
            Cell cell = row.createCell(0);
            cell.setCellValue(statistics.get(i).getStudyProfile().getName());
            cell = row.createCell(1);
            cell.setCellValue(statistics.get(i).getAvgExamScore());
            cell = row.createCell(2);
            cell.setCellValue(statistics.get(i).getCountStudentsByProfile());
            cell = row.createCell(3);
            cell.setCellValue(statistics.get(i).getCountUniversitiesByProfile());
            cell = row.createCell(4);
            cell.setCellValue(String.join(",", statistics.get(i).getNameOfUniversities()));
        }


        File file = new File(pathFile);

        try (FileOutputStream outputStream = new FileOutputStream(file);){
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
