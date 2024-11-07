package skillfactory.writers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import skillfactory.models.EducationInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter extends AbstractWriter {
    private Gson json = new GsonBuilder().setPrettyPrinting().create();

    @Override
    void convert(EducationInfo educationInfo, File file) throws Exception {
        String result = json.toJson(educationInfo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(result);
            writer.flush();
        }
    }

    @Override
    String getPathDirectory() {
        return "/jsonReg";
    }
}
