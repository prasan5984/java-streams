package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListUseCase {

    public static void main(String[] args) {
        System.out.println(toList(IntStream.range(0, 10)
                                           .boxed()));
    }

    private static <T> List<T> toList(Stream<T> stream) {
        return stream.reduce(new ArrayList<>(), (l, e) -> {
            l.add(e);
            return l;
        }, (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        });
    }
}
