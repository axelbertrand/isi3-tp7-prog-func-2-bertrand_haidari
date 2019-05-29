import io.vavr.control.Try;
import java.io.FileInputStream;

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
        return Try.of(() -> {
            FileInputStream fis = new FileInputStream(filePath);
            byte[] b = new byte[100];
            fis.read(b, 0, 100);
            return new String(b);
        });
    }

    public static void main(String[] args) {
        System.out.println(divide(5.0, 0.0));

        divide2(5.0, 0.0)
        .onFailure(it -> System.out.println(it.getMessage()))
        .onSuccess(it -> System.out.println(it));

        readFile("test.txt")
        .onFailure(it -> System.out.println(it.getMessage()))
        .onSuccess(it -> System.out.println(it));
    }
}