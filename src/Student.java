public class Student extends Person{
    private Department department;
    private int year;
    private String group;

    public Student(String name, int age, Department department, int year, String group) {
        super(name, age);
        this.department = department;
        this.year = year;
        this.group = group;
    }
}
