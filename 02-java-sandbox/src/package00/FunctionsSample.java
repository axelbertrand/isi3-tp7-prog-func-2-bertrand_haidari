package package00;

import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface TriFunction<T, U, R, S> {
  S apply(T a, U b, R c);
}

public class FunctionsSample {

  public static void main(String[] args) {
    // <type of param, type of return>
    Function<String, String> concat42 = txt -> txt+"42";
    Function<Integer, Integer> add42 = value -> value + 42;

    System.out.println(
      concat42.apply("45")
    );

    System.out.println(
      add42.apply(45)
    );

    BiFunction<Double, Double, Double> add = (n1, n2) -> n1 + n2;

    System.out.println(
      add.apply(25., 42.)
    );

    TriFunction<Double, Double, Double, Double> volume = (n1, n2, n3) -> n1 * n2 * n3;

    System.out.println(
      volume.apply(25., 42., 12.)
    );
  }

}
