public class CharacterSource implements ISource {

    private final String value;

    public CharacterSource(String source) {
        this.value = source;
    }

    @Override
    public char getChar() {
        return 'p';
    }
}
