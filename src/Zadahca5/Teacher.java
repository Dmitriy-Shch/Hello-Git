package Zadahca5;

public class Teacher extends People {
    String subject;

    public Teacher(String name, int aeg, String profession, String subject) {
        super(name, aeg, profession);
        this.subject = subject;
    }

    @Override
    public String getProfession() {
        return profession;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String giveALesson() {
        return "The lesson was ended";
    }
}
