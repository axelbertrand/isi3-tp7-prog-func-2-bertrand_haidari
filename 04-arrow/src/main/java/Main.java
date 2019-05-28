package demo;

import arrow.core.Failure;
import arrow.core.Success;
import io.vavr.Try;
import java.io.FileInputStream;

public class Main {
    public static double divide(double a, double b) {
        return a / b;
    }

    public static Try<Double> divide2(Double dividend, Double divisor) {
        return Try.of(() -> dividend / divisor);
    }

    public static void main(String[] args) {
        System.out.println(divide(5.0, 0.0))

        divide2(5.0, 0.0).let {
            when(it) {
                is Failure -> println(it.exception.message)
                is Success -> println(it.value)
            }
        }
    }
}