import java.util.Collections;
import java.util.List;

public class OrderBy {
    public static void name(List<? extends Person> list){
        Collections.sort(list, Order.byName);
    }

    public static void year(List<Student> list){
        Collections.sort(list, Order.byYear);
    }
}
