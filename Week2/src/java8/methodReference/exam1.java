package java8.methodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class exam1 {
    List<Integer> list = Arrays.asList(1, 2, 8, 3, 4, 9, 0, 14, 5);

    public static void printOddNumber(int num) {
        if (num % 2 == 0) {
            System.out.println(num);
        }
    }

    static <T, R> List<R> convertToInteger(Function<T, R> function, List<T> source) {
        List<R> destiny = new ArrayList<>();
        for (T item : source) {
            R value = function.apply(item);
            destiny.add(value);
        }
        return destiny;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.forEach(e -> exam1.printOddNumber(e));
        list.forEach(exam1::printOddNumber);

        List<Integer> convert = convertToInteger(Integer::new,list);
    }
}
