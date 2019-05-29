import io.vavr.control.Try;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static double divide(double a, double b) {
        return a / b;
    }

    public static Try<Double> divide2(Double a, Double b) {
        Double res = a / b;
        if(res == Double.POSITIVE_INFINITY) {
            return Try.failure(new Exception("😡 Infinity"));
        }
        else {
            return Try.success(res);
        }
    }

    public static Try<String> readFile(String filePath) {
        Try<InputStream> fis = Try.of(new FileInputStream(filePath));
        return fis.map(it -> new String(it.read(new byte[100], 0, 100)));
    }

    public static void main(String[] args) {
        System.out.println(divide(5.0, 0.0));

        Try<Double> response = divide2(5.0, 0.0);
        response.onFailure(it -> System.out.println(it.getMessage()));
        response.onSuccess(it -> System.out.println(it));
    }
}