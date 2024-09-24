package skillfactory;

public enum StudyProfile {

    MEDICINE("Медицина"),
    IT("ИТ"),
    PHYLOSOPHY("Философия");

    private String name;

    StudyProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
