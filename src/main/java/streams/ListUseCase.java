package streams;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
                .collect(new Collector<T, List<T>, List<T>>() {
                    @Override
                    public Supplier<List<T>> supplier() {
                        return ArrayList::new;
                    }

                    @Override
                    public BiConsumer<List<T>, T> accumulator() {
                        return List::add;
                    }

                    @Override
                    public BinaryOperator<List<T>> combiner() {
                        return (left, right) -> {
                            left.addAll(right);
                            return left;
                        };
                    }

                    @Override
                    public Function<List<T>, List<T>> finisher() {
                        return Function.identity();
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return EnumSet.of(Characteristics.IDENTITY_FINISH);
                    }
                });
    }
}
