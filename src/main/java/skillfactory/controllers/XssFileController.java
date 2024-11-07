package skillfactory.controllers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import skillfactory.enums.StudyProfile;
import skillfactory.models.Student;
import skillfactory.models.University;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XssFileController {

    private final static Logger log = Logger.getLogger(XssFileController.class.getName());

    private XssFileController() {}

    public static List<Student> readStudentInfo(String fileName) {
        log.info("Start read sheet \"Студенты\" in file " + fileName);
        Map<Integer, List<String>> data = getDataSheet(fileName, "Студенты");
        List<Student> students = new ArrayList<>();

        for (List<String> listValues: data.values()) {
            students.add(new Student()
                    .setUniversityId(listValues.get(0))
                    .setFullName(listValues.get(1))
                    .setCurrentCourseNumber((int)Double.parseDouble(listValues.get(2)))
                    .setAvgExamScore(Float.parseFloat(listValues.get(3)))
            );
        }
        log.info("Finish read sheet \"Student\" in file " + fileName);
        return students;
    }

    public static List<University> readUniversityInfo(String fileName) {
        log.info("Start read sheet \"Университеты\" in file " + fileName);
        Map<Integer, List<String>> data = getDataSheet(fileName,"Университеты");
        List<University> universities = new ArrayList<>();

        for (List<String> listValues: data.values()) {
            universities.add(new University()
                    .setId(listValues.get(0))
                    .setFullName(listValues.get(1))
                    .setShortName(listValues.get(2))
                    .setYearOfFoundation((int)Double.parseDouble(listValues.get(3)))
                    .setMainProfile(StudyProfile.valueOf(listValues.get(4)))
            );
        }
        log.info("Finish read sheet \"Университеты\" in file " + fileName);
        return universities;
    }

    private static Map<Integer, List<String>> getDataSheet(String fileName, String listName) {
        File file = new File(fileName);
        Map<Integer, List<String>> data = new HashMap<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = workbook.getSheet(listName);

            int i = 1;
            for (Row row: sheet) {
                data.put(i, new ArrayList<String>());
                if (row.getRowNum() == 0) {
                    continue;
                }
                for (Cell cell: row) {
                    switch (cell.getCellType()) {
                        case STRING: {
                            data.get(i).add(cell.getStringCellValue());
                            break;
                        }
                        case NUMERIC: {
                            data.get(i).add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        }
                        default: data.get(i).add("");
                    }
                }
                i++;
            }

        } catch (IOException e) {
            log.log(Level.SEVERE, "Reading file failed", e);
        }

        return data;
    }
}
