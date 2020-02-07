public class MyClass extends SuperClass {
    private double varDouble;

    public void publicMethod() {

    }
    public void hiddenMethod() {

    }
    @Override
    public void setVarDouble(double var) {
        this.varDouble = var;
    }
    @Override
    public double getVarDouble() {
        return
                varDouble;
    }
}