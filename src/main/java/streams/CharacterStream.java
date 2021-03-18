package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterStream {

    private static List<Character> toLetterList(List<String> strList) {
        return strList.stream()
                      .flatMapToInt(CharSequence::chars)
                      .filter(Character::isLetter)
                      .mapToObj(c -> (char)c)
                      .collect(Collectors.toList());
    }

}
