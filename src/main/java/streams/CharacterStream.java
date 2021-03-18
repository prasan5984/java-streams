package streams;

import java.util.ArrayList;
import java.util.List;

public class CharacterStream {

    private static List<Character> toCharsList(List<String> strList) {
        return strList.stream()
                      .collect(ArrayList::new,
                              (l, s) -> {
                                  for (char c : s.toCharArray()) {
                                      if (Character.isLetter(c)) l.add(c);
                                  }
                              },
                              ArrayList::addAll);
    }

}
