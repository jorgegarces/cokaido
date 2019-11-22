public class Calc {

    int result;
    public Calc(int number) {
        this.result = number;
    }

    public void add(int number) {
        result += number;
        System.out.println(result);
    }

    public void sub(int number) {
        result -= number;
        System.out.println(result);
    }
}