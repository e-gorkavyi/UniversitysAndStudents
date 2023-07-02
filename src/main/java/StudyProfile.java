public enum StudyProfile {
    NOT_DEFINED("Не определён"),
    MEDICINE("Медицина"),
    IIGENEER("Инженерное дело"),
    OIL("Нефтедобыча"),
    MACHINES("Машиностоение"),
    ECONOMYCS("Экономика");

    private final String profile;

    public String getProfile() {
        return this.profile;
    }

    StudyProfile(String profile) {
        this.profile = profile;
    }
}
