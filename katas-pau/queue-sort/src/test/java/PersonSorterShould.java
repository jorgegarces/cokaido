import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersonSorterShould {

    @Test
    public void ensure_it_adds_one_person_to_the_list() {
        List<Person> onePerson = new ArrayList<>();
        onePerson.add(new Person("Jorge", 39));

        List<Person> testSequence = new ArrayList<>();
        testSequence.add(new Person("Jorge", 39));

        PersonSorter.sort(testSequence);

        Assert.assertEquals(testSequence, onePerson);
    }

    @Test
    public void ensure_it_sorts_two_people_by_age(){
        List<Person> twoPeople = new ArrayList<>();
        twoPeople.add(new Person("Jorge", 38));
        twoPeople.add(new Person("Carol", 34));

        List<Person> testSequence = new ArrayList<>();
        testSequence.add(new Person("Carol", 34));
        testSequence.add(new Person("Jorge", 38));

        PersonSorter.sort(testSequence);

        Assert.assertEquals(twoPeople, testSequence);
    }

    @Test
    public void ensure_it_sorts_people_by_age_and_then_alphabetically(){
        List<Person> multiplePeople = new ArrayList<>();
        multiplePeople.add(new Person("Chuck", 39));
        multiplePeople.add(new Person("Jorge", 38));
        multiplePeople.add(new Person("Carol", 34));
        multiplePeople.add(new Person("Ana", 32));
        multiplePeople.add(new Person("Ara", 32));

        List<Person> testSequence = new ArrayList<>();
        testSequence.add(new Person("Carol", 34));
        testSequence.add(new Person("Jorge", 38));
        testSequence.add(new Person("Ara", 32));
        testSequence.add(new Person("Chuck", 39));
        testSequence.add(new Person("Ana", 32));

        PersonSorter.sort(testSequence);

        Assert.assertEquals(multiplePeople, testSequence);
    }
}