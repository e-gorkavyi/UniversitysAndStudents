public class Main {
    public static void main(String[] args) {
        University university = new University(
                "НГТУ",
                "Новосибирский Государственный Технический Университет",
                "НЭТИ",
                1953,
                StudyProfile.IIGENEER);
        Student student = new Student(
                "Кузнецов Спиридон Никонорович",
                "НГТУ",
                2,
                4.2F);

        System.out.println("ВУЗ");
        System.out.println(university);
        System.out.println("Студент");
        System.out.println(student);
    }
}
