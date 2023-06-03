package module_11;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class FifthTask {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        var firstIterator = first.iterator();
        var secondIterator = second.iterator();

        return Stream.generate(() -> {
                    if (firstIterator.hasNext() && secondIterator.hasNext()) {
                        return Stream.of(firstIterator.next(), secondIterator.next());
                    }

                    return null;
                }).takeWhile(Objects::nonNull)
                .flatMap(Function.identity());
    }

    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4);
        Stream<Integer> secondStream = Stream.of(10, 20, 30, 40, 50);

        Stream<Integer> zippedStream = zip(firstStream, secondStream);

        zippedStream.forEach(System.out::println);
    }
}