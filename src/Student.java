public class Student extends Person{
    private Department department;
    private int year;
    private String group;

    public Student(String name, int age, int year, String group) {
        super(name, age);
        this.year = year;
        this.group = group;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }
}
