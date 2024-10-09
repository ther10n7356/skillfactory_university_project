package skillfactory.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import skillfactory.models.Student;
import skillfactory.models.University;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new Gson();

    private JsonUtil() {}

    public static String getJsonFromStudent(Student student) {
        return gson.toJson(student);
    }

    public static String getJsonFromUniversity(University university) {
        return gson.toJson(university);
    }

    public static String getJsonFromListStudents(List<Student> students) {
        return gson.toJson(students);
    }

    public static String getJsonFromListUniversities(List<University> universities) {
        return gson.toJson(universities);
    }

    public static Student getStudentFromJson(String json) {
        return gson.fromJson(json, Student.class);
    }

    public static University getUniversityFromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    public static List<Student> getListStudentsFromJson(String json) {
        return gson.fromJson(json, new TypeToken<ArrayList<Student>>() {}.getType());
    }

    public static List<University> getListUniversitiesFromJson(String json) {
        return gson.fromJson(json, new TypeToken<ArrayList<University>>() {}.getType());
    }
}
