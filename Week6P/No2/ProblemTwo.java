package No2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class ProblemTwo {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(101, "Joe"),
                new Student(103, "Zulkifli"),
                new Student(102, "Riza"),
                new Student(104, "Alice"),
                new Student(105, "Joshua")
        );

        List<Student> ans = students.stream() // [1] Memulai operasi stream
                .sorted((s1, s2) -> {         // [2] Melakukan pengurutan dengan sorted()
                    
                    // Logika: Jika nama sama, bandingkan ID
                    if (s1.getName().equalsIgnoreCase(s2.getName())) {
                        return Integer.compare(s1.getId(), s2.getId()); // [3] Wrapper class Integer
                    } 
                    // Jika nama berbeda, bandingkan Nama secara Case-Insensitive
                    else {
                        return s1.getName().compareToIgnoreCase(s2.getName()); // [4] Metode String
                    }
                })
                .collect(Collectors.toList()); // [5] Operasi terminal collect

        for (Student student : ans) {
            System.out.println(student);
        }
    }
}