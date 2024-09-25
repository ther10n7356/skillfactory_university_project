package skillfactory.enums;

public enum StudyProfile {

    MEDICINE("Медицина"),
    IT("ИТ"),
    LINGUISTICS("Лингвистика"),
    PHYSICS("Физика"),
    MATHEMATICS("Математика"),
    PHILOSOPHY("Философия");

    private String name;

    StudyProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
