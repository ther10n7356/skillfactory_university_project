package skillfactory.writers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import skillfactory.models.EducationInfo;

import java.io.*;

public class XmlWriter extends AbstractWriter {

    public void convert(EducationInfo educationInfo, File file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(EducationInfo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(educationInfo, new FileWriter(file));
    }

    @Override
    String getPathDirectory() {
        return "/xmlReg";
    }
}
