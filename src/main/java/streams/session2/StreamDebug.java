package streams.session2;

import java.util.stream.Stream;

public class StreamDebug {

    public static void main(String[] args) {
        String result = Stream.of("hi", "hello", "world")
                           .filter(s -> !s.contentEquals("hi"))
                           .reduce("",(s1,s2) -> s1 + s2);
        System.out.println(result);
    }


}
