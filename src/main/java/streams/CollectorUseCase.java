package streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectorUseCase {

    private static Map<String, List<String>> groupByDept(List<Student> list) {
        return list.stream()
                   .collect(HashMap::new,
                           (map, student) ->
                                   map.computeIfAbsent(student.getDept(), s -> new ArrayList<>())
                                      .add(student.getName()),
                           (m1, m2) -> {
                               for (Map.Entry<String, List<String>> entry : m1.entrySet())
                                   m2.merge(entry.getKey(),
                                           entry.getValue(),
                                           (v1, v2) -> {
                                               v1.addAll(v2);
                                               return v1;
                                           });
                           });
    }

    private static class Student {
        private final String name, dept;

        public Student(String name, String dept) {
            this.name = name;
            this.dept = dept;
        }

        public String getName() {
            return name;
        }

        public String getDept() {
            return dept;
        }
    }
}
