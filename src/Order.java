import java.util.Comparator;

public class Order {
    /**
     * Comparator to order people by name
     */
    public static Comparator<Person> byName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    };

    /**
     * Comparator to order students by year
     */
    public static Comparator<Student> byYear = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getYear() - o2.getYear();
        }
    };

}
