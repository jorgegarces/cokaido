import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QueueSortShould {

    @Test
    public void ensure_it_adds_one_person_to_the_list() {
        List<Person> onePerson = new ArrayList<>();
        onePerson.add(new Person("Jorge", 39));

        List<Person> testSequence = new ArrayList<>();
        testSequence.add(new Person("Jorge", 39));

        Assert.assertEquals(testSequence, QueueSort.sort(onePerson));
    }

    @Test
    public void test(){
        List<Person> twoPeople = new ArrayList<>();
        twoPeople.add(new Person("Jorge", 38));
        twoPeople.add(new Person("Carol", 34));

        List<Person> testSequence = new ArrayList<>();
        testSequence.add(new Person("Carol", 34));
        testSequence.add(new Person("Jorge", 38));

        Assert.assertEquals(testSequence, QueueSort(twoPeople));
    }
}