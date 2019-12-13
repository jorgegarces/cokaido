import org.junit.Assert;
import org.junit.Test;

public class QueueSortShould {

    @Test
    public void ensure_it_adds_one_person_to_the_list() {
        QueueSort queueSort = new QueueSort();
        Seq singlePerson = new Seq();
        singlePerson.addPerson(new Person("Jorge", 39));

        Seq testSequence = new Seq();
        testSequence.addPerson(new Person("Jorge", 39));

        Assert.assertTrue(testSequence.equals(queueSort.sort(singlePerson)));
    }
}