public class CharacterSource implements ISource {

    private final String value;
    private int counter = 0;

    public CharacterSource(String source) {
        this.value = source;
    }

    @Override
    public char getChar() {
        char character = value.charAt(counter);
        counter++;
        return character;
    }
}
