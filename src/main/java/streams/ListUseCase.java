package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListUseCase {

    public static void main(String[] args) {
        System.out.println(toList(IntStream.range(1, 10000)
                                           .boxed()));
    }

    private static <T> List<T> toList(Stream<T> stream) {
        return stream
                .parallel()
                .collect(() -> new ArrayList<>(),
                        (list, e) -> list.add(e),
                        (l1, l2) -> l1.addAll(l2));
    }
}
