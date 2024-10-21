package skillfactory.models;

import skillfactory.enums.StudyProfile;

import java.util.List;

public class Statistics {

    private StudyProfile studyProfile;
    private float avgExamScore;
    private int countStudentsByProfile;
    private int countUniversitiesByProfile;
    private List<String> nameOfUniversities;

    public Statistics(StudyProfile studyProfile, float avgExamScore, int countStudentsByProfile, int countUniversitiesByProfile, List<String> nameOfUniversities) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.countStudentsByProfile = countStudentsByProfile;
        this.countUniversitiesByProfile = countUniversitiesByProfile;
        this.nameOfUniversities = nameOfUniversities;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getCountStudentsByProfile() {
        return countStudentsByProfile;
    }

    public void setCountStudentsByProfile(int countStudentsByProfile) {
        this.countStudentsByProfile = countStudentsByProfile;
    }

    public int getCountUniversitiesByProfile() {
        return countUniversitiesByProfile;
    }

    public void setCountUniversitiesByProfile(int countUniversitiesByProfile) {
        this.countUniversitiesByProfile = countUniversitiesByProfile;
    }

    public List<String> getNameOfUniversities() {
        return nameOfUniversities;
    }

    public void setNameOfUniversities(List<String> nameOfUniversities) {
        this.nameOfUniversities = nameOfUniversities;
    }
}
