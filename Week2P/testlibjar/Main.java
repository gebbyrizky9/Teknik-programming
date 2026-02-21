import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MENGUJI FILE JAR ===");

        // Menguji class dari file JAR
        Department deptIT = new Department("IT Department");
        EmploymentType typePermanent = new EmploymentType("Permanent");
        
        Employee emp1 = new Employee(101, "Ahmad", deptIT, typePermanent, 5000000);
        
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);

        System.out.println("Nama Karyawan : " + service.getEmployee(101).getName());
        System.out.println("Departemen    : " + service.getEmployee(101).getDepartment().getName());
        System.out.println("Gaji Awal     : Rp" + service.getEmployee(101).getSalary());
        
        System.out.println("BERHASIL! Aplikasi berjalan menggunakan file JAR.");
    }
}