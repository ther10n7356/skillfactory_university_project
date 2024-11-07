package skillfactory.models;

import com.google.gson.annotations.SerializedName;
import skillfactory.enums.StudyProfile;

import jakarta.xml.bind.annotation.XmlElement;

public class University {
    @SerializedName("universityIdentifier")
    private String id;
    @SerializedName("universityName")
    private  String fullName;
    @SerializedName("universityShortName")

    private String shortName;
    @SerializedName("year")
    private int yearOfFoundation;
    @SerializedName("specialization")
    private StudyProfile mainProfile;

    @XmlElement(name = "universityId")
    public String getId() {
        return id;
    }

    @XmlElement(name = "universityName")
    public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "universityProfile")
    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile.getName() +
                '}';
    }
}
