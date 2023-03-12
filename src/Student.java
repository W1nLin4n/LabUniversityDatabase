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

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Department getDepartment() {
        return department;
    }
}
