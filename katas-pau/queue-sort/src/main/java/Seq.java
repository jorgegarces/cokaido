import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Seq {
    private List<Person> sequence;

    public Seq(){
        sequence = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        sequence.add(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seq seq = (Seq) o;
        return Objects.equals(sequence, seq.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence);
    }
}