package W10_Exercises.C1_MapSet;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();

        Map<Integer, Employee> employees = employee.getMapEmployees();

        Map<Integer, Employee> filteredDepartment = employee.filterDepartment("IT");
        System.out.println(filteredDepartment);

        Map<Integer, Employee> filteredJobTitle = employee.filterJobTitle("Developer");
        System.out.println(filteredJobTitle);

        Map<Integer, Employee> filteredManagerID = employee.filterManagerId(42);
        System.out.println(filteredManagerID);

        employee.countEmployeesDepartment();

        Set<Employee> employeesSet = employee.getSetEmployees();
        System.out.println(employee.countingEmployees());
        
    }
}
