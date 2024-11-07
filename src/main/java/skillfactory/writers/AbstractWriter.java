package skillfactory.writers;

import skillfactory.models.EducationInfo;

import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractWriter {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    public void generateFile(EducationInfo educationInfo, String pathFile){
        try {
            File file = new File(pathFile + getPathDirectory());
            if (!file.exists()) {
                file.mkdir();
                log.info("New directory " + getPathDirectory().substring(1) + " created");
            } else {
                log.info("Directory " + getPathDirectory().substring(1) + " already exists");
            }
            file = new File(pathFile + getPathDirectory() + "/" + getFileName());
            if (file.createNewFile()) {
                log.info("New file created");
            } else {
                log.warning("File already exists");
            }

            convert(educationInfo, file);
            log.info("File generated successful");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error when generating file", e);
        }
    }

    public String getFileName() {
        return String.format("req_%s.xml", new Date().getTime());
    }

    abstract void convert(EducationInfo educationInfo, File file) throws Exception;

    abstract String getPathDirectory();
}
