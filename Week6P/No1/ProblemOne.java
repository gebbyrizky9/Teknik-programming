package No1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Implementasi class Employee
class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // Override metode toString agar output sesuai dengan yang diharapkan
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

public class ProblemOne {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        // Catatan: Data disesuaikan agar cocok dengan output yang Anda harapkan di prompt
        list.add(new Employee("Alice", 50000));
        list.add(new Employee("Bob", 70000));
        list.add(new Employee("John", 10000));
        list.add(new Employee("Rob", 40000));

        // Melakukan proses filtering/sorting menggunakan Stream API
        List<Employee> sortedEmp = list.stream() // [1] Ubah list ke stream
                // [2] dan [3] Mengurutkan employee berdasarkan nama
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                // [4] dan [5] Mengumpulkan hasil akhir ke dalam list
                .collect(Collectors.toList());

        for(Employee e : sortedEmp){
            System.out.println(e);
        }
    }
}