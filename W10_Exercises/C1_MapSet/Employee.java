package W10_Exercises.C1_MapSet;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class Employee {
    private String name;
    private int id;
    private String department;
    private String jobTitle;
    private int managerID;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
    public Employee(String name, int id, String department, String jobTitle, int managerID) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerID = managerID;
    }

    public Employee() {
    }
    private Map<Integer, Employee> employeesMap = new HashMap<>();
    private final Set<Employee> employeesSet = new HashSet<>();


    @Override
    public String toString(){
        return "\n Name: " + name + " | id | " + id + " | " + department + " | " + jobTitle + " | " + managerID;
    }

    public Set<Employee> getSetEmployees(){
        Employee employeeOne = new Employee("Olivia", 123, "Marketing", "Senior AccountManager", 456);
        Employee employeeTwo = new Employee("Jean", 213, "IT", "Senior Software Developer", 42);
        Employee employeeThree = new Employee("Max", 145, "IT", "Junior Software Developer", 42);
        Employee employeeFour = new Employee("Anna", 367, "IT", "Product Owner", 42);
        Employee employeeFive = new Employee("Valentyna", 105, "IT", "Junior Software Developer", 42);
        Employee employeeSix= new Employee("Max", 245, "HR", "Junior HR Manager", 156);

        employeesSet.add(employeeOne);
        employeesSet.add(employeeTwo);
        employeesSet.add(employeeThree);
        employeesSet.add(employeeFour);
        employeesSet.add(employeeFive);
        employeesSet.add(employeeSix);


        return employeesSet;
    }

    public Map<Integer, Employee> getMapEmployees(){

        Employee employeeOne = new Employee("Olivia", 123, "Marketing", "Senior AccountManager", 456);
        Employee employeeTwo = new Employee("Jean", 213, "IT", "Senior Software Developer", 42);
        Employee employeeThree = new Employee("Max", 145, "IT", "Junior Software Developer", 42);
        Employee employeeFour = new Employee("Anna", 367, "IT", "Product Owner", 42);
        Employee employeeFive = new Employee("Valentyna", 105, "IT", "Junior Software Developer", 42);
        Employee employeeSix= new Employee("Max", 245, "HR", "Junior HR Manager", 156);

        employeesMap.put(employeeOne.id, employeeOne);
        employeesMap.put(employeeTwo.id, employeeTwo);
        employeesMap.put(employeeThree.id, employeeThree);
        employeesMap.put(employeeFour.id, employeeFour);
        employeesMap.put(employeeFive.id, employeeFive);
        employeesMap.put(employeeSix.id, employeeSix);

        return employeesMap;
    }

    public boolean searchEmployee(Employee obj){
        return employeesSet.contains(obj);
    }

    public void addInfoToMap(Integer id,  Employee obj){
        if (employeesMap.containsKey(id)) {
            throw new IllegalStateException("An employee with the following id '"+id+"' already exists.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        employeesMap.put(id, obj);
    }

    public void display(){
        System.out.println(employeesMap);
    }

    public Employee update(Integer id, Employee obj) {
        if (!employeesMap.containsKey(obj)) {
            throw new IllegalStateException("There is no employee to update for key '"+ id +"'.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        return employeesMap.put(id, obj);
    }

    public Employee addOrUpdate(Integer id, Employee obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        return employeesMap.put(id, obj);
    }

    public boolean remove(Integer id) {
        return employeesMap.remove(id) != null;
    }

    public boolean contains(Integer id){
        return employeesMap.containsKey(id);
    }

    public Map<Integer, Employee> filterDepartment(String department) {
        Map<Integer, Employee> filteredMap = employeesMap.entrySet()
                .stream()
                .filter(entry -> department.equalsIgnoreCase(entry.getValue().getDepartment()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        System.out.println("Filtered by department: " + filteredMap);
        return filteredMap;
    }

    public Map<Integer, Employee> filterJobTitle(String jobTitle) {
        Map<Integer, Employee> filteredMap = employeesMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getJobTitle().toLowerCase().contains(jobTitle.toLowerCase()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        System.out.println("Filtered by Job Title: " + filteredMap);
        return filteredMap;
    }

    public Map<Integer, Employee> filterManagerId(Integer ManagerID) {
        Map<Integer, Employee> filteredMap = employeesMap.entrySet()
                .stream()
                .filter(entry -> {
                    return ManagerID == entry.getValue().getManagerID();
                })
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        System.out.println("Filtered by Job Title: " + filteredMap);
        return filteredMap;
    }

    public void countEmployeesDepartment() {
        Map<String, Long> filteredMap = employeesMap.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        filteredMap.forEach((department, count) -> {
            System.out.println("Department: " + department + ", Employee Count: " + count);
        });
    }

    public int countingEmployees(){
       return employeesSet.size();
    }
}






