public class App {

    public static void main(String[] arguments) {
        Calculadora calculadora = new Calculadora(0);
        if (arguments[0].equals("add")) {
            String operator = "+";
            calculadora.add(Integer.parseInt(arguments[1]));
            calculadora.add(Integer.parseInt(arguments[2]));
            calculadora.resultado(operator, Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
            calculadora.multiply(4);
        }

        CalculadoraBinaria calculadoraBinaria = new CalculadoraBinaria();
        calculadoraBinaria.add(3);
    }
}