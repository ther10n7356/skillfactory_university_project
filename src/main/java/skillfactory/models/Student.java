package skillfactory.models;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

public class Student {
    @SerializedName("studentName")
    private String fullName;
    @SerializedName("universityIdentifier")
    private String universityId;
    @SerializedName("course")
    private int currentCourseNumber;
    @SerializedName("avgScore")
    private float avgExamScore;

    @XmlElement(name = "studentName")
    public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "universityId")
    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    @XmlElement(name = "avgScore")
    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}
