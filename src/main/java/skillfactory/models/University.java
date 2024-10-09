package skillfactory.models;

import com.google.gson.annotations.SerializedName;
import skillfactory.enums.StudyProfile;

public class University {
    @SerializedName("universityIdentifier")
    private final String id;
    @SerializedName("universityName")
    private final String fullName;
    @SerializedName("universityShortName")
    private final String shortName;
    @SerializedName("year")
    private final int yearOfFoundation;
    @SerializedName("specialization")
    private final StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public static class Builder {
        private String id;
        private String fullName;
        private String shortName;
        private int yearOfFoundation;
        private StudyProfile mainProfile;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder setYearOfFoundation(int yearOfFoundation) {
            this.yearOfFoundation = yearOfFoundation;
            return this;
        }

        public Builder setMainProfile(StudyProfile mainProfile) {
            this.mainProfile = mainProfile;
            return this;
        }

        public University build() {
            return new University(id, fullName, shortName, yearOfFoundation, mainProfile);
        }
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
