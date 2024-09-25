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

public class XssFileController {

    private XssFileController() {}

    public static List<Student> readStudentInfo(String fileName) {
        Map<Integer, List<String>> data = getDataSheet(fileName, "Студенты");
        List<Student> students = new ArrayList<>();

        for (List<String> listValues: data.values()) {
            students.add(new Student.Builder()
                    .setUniversityId(listValues.get(0))
                    .setFullName(listValues.get(1))
                    .setCurrentCourseNumber((int)Double.parseDouble(listValues.get(2)))
                    .setAvgExamScore(Float.parseFloat(listValues.get(3)))
                    .build()
            );
        }
        return students;
    }

    public static List<University> readUniversityInfo(String fileName) {
        Map<Integer, List<String>> data = getDataSheet(fileName,"Университеты");
        List<University> universities = new ArrayList<>();

        for (List<String> listValues: data.values()) {
            universities.add(new University.Builder()
                    .setId(listValues.get(0))
                    .setFullName(listValues.get(1))
                    .setShortName(listValues.get(2))
                    .setYearOfFoundation((int)Double.parseDouble(listValues.get(3)))
                    .setMainProfile(StudyProfile.valueOf(listValues.get(4)))
                    .build()
            );
        }
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
            e.printStackTrace();
        }

        return data;
    }
}
