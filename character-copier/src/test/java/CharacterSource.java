public class CharacterSource implements ISource {

    private final char value;

    public CharacterSource(char source) {
        this.value = source;
    }

    @Override
    public char getChar() {
        return value;
    }
}
