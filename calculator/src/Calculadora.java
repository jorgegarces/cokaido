public class Calculadora {

    int result;
    public Calculadora(int number) {
        this.result = number;
    }

    public void add(int number) {
        result += number;
        //System.out.println(result);
    }

    public void sub(int number) {
        result -= number;
        //System.out.println(result);
    }

    public void resultado(String operator, int number1, int number2) {
        System.out.println(number1 + " " + operator + " " + number2  + " equals " + result);
    }

    public void multiply(int i) {

    }
}
