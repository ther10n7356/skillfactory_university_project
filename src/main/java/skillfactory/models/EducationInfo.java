package skillfactory.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "root")
public class EducationInfo {

    @XmlElementWrapper(name = "studentInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> listStudents;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universitiesEntry")
    private List<University> listUniversities;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> listStatistics;

    public EducationInfo setStudents(List<Student> students) {
        this.listStudents = students;
        return this;
    }

    public EducationInfo setUniversities(List<University> universities) {
        this.listUniversities = universities;
        return this;
    }

    public EducationInfo setLisOfStatistics(List<Statistics> lisOfStatistics) {
        this.listStatistics = lisOfStatistics;
        return this;
    }
}
