/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 09.03.16
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public int addition(int first, int second) {
        return first + second;
    }
    public int subsctraction(int first, int second) {
        return first - second;
    }
    public int multiplication(int first, int second) {
        return first * second;
    }
    public float division(float first, float second) {
        if (second == 0) {
            throw new IllegalArgumentException("division by 0");
        }
        return first / second;
    }
    public double root(double first) {
        return Math.sqrt(first);
    }
    public double power(double first, double value) {
        if (value == 0) {
            throw new IllegalArgumentException("value should not equal zero");
        }
        return Math.pow(first,value);
    }


    int fibonacci(int n) {
        if (n<0)
            throw new IllegalArgumentException("vrong value");

        int n0 = 1, n1 = 1, n2;

        for(int i = 0; i < n; i++){
            n2=n0+n1;
            if (i == n-1)
                return n2;
            n0=n1;
            n1=n2;
        }
        return 0;
    }
}
