package streams.session2;

import java.util.stream.IntStream;

public class StreamEvaluation {
    public static void main(String[] args) {
        IntStream.of(1)
                 .peek(i -> {
                     throw new RuntimeException("Error");
                 }).findAny();
    }
}
