package beginner;


import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

public class AboutConstructors {

    class A {
        String someString = "a";

        public A() {
            someString += "x";
        }

    }

    class B extends A {
        public B() {
            someString += "g";
        }

    }

    @Koan
    public void simpleConstructorOrder() {
        assertEquals(new B().someString, "axg");
    }

    class Aa {
        String pepito = "a";
        String someString = "b";

        public Aa() {
            someString += "x";
        }

        public Aa(String s) {
            pepito += s;
        }
    }

    class Bb extends Aa {
        public Bb() {
            super();
            pepito += "g";
        }

    }

    @Koan
    public void complexConstructorOrder() {
        assertEquals(new Bb().pepito, "ag");
    }

}
