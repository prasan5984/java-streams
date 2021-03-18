package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorUseCase {

    private static Map<String, List<String>> groupByDept(List<Student> list) {
        return list.stream()
                   .collect(
                           Collectors.groupingBy(
                                   Student::getDept,
                                   Collectors.mapping(Student::getName, Collectors.toList())
                           )
                   );
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
