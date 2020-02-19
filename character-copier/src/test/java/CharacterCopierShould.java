import org.junit.Assert;
import org.junit.Test;

public class CharacterCopierShould {

    @Test
    public void copy_a_character_from_source_to_destination(){

        ISource source = new CharacterSource("pepito");
        CharacterDestination destination = new CharacterDestination();

        CharacterCopier copier = new CharacterCopier(source, destination);
        copier.copy();

        Assert.assertEquals('p', destination.getCharCopy());
    }
}
