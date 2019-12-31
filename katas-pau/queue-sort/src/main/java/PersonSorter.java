import java.util.Collections;
import java.util.List;

public class PersonSorter {

    public static void sort(List<Person> list) {
        Collections.sort(list);
    }

    private static List<Person> customRecursiveSorter(List<Person> list) {
        int compared;
        for(int i = 0; i < list.size() -1; i++) {
            compared = list.get(i).compareTo(list.get(i+1));
            changePosition(list, compared, i);
        }
        return list;
    }

    private static void changePosition(List<Person> list, int compared, int i) {
        Person temp;
        if (compared == -1) {
           temp = list.get(i);
           list.set(i, list.get(i+1));
           list.set(i+1, temp);
           customRecursiveSorter(list);
        }
    }
}