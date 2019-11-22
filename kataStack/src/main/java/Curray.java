import java.util.ArrayList;

public class Curray<T>{
    private ArrayList<T> stack = new ArrayList<T>();

    public T pop() {
        if (stack.size() == 0) throw new NullPointerException();
        return stack.remove(stack.size() - 1);

    }

    public void push(T item) {
        stack.add(item);
    }

    /*public int stackSize() {
        return stack.size();
    }*/

}
