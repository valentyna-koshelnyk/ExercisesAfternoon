package W9C4_Serialization;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student implements Serializable {
    private List<String>courses = new ArrayList<>();
    private List<String>hobbies = new ArrayList<>();
    private String name;
    private String age;
    private static final long serialVersionUID = 1L;
    private static String filename = "students.out";


    public Student(String name, String age, String address, double GPA) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.GPA = GPA;
    }

    private String address;
    private double GPA;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String ... strings){
        courses.addAll(Arrays.asList(strings));
    }
    public void addHobby(String ... strings){
        hobbies.addAll(Arrays.asList(strings));
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student " +
                "name: " + name + '\'' +
                ", age: " + age + '\'' +
                ", address: " + address + '\'' +
                ", GPA = " + GPA +
                " ";
    }

    public static Student[] getStudents(){
        // Student Maria
        Student maria = new Student("Maria" ,"32","Berlin", 3.7);
        maria.addCourse("Physics", "Cryptography");
        maria.addHobby("dancing", "reading");

      // Student Max
        Student max = new Student("Max" ,"18","New York", 2.1);
        max.addCourse("Maths", "Ukrainian");
        max.addHobby("football", "reading");

        // Student Olivia

        Student olivia = new Student("Olivia" ,"1","Berlin", 1.3);
        olivia.addCourse("Literature", "Counting");
        olivia.addHobby("playing piano", "reading");

        return new Student[]{maria, max, olivia};
    }
    public static void updateInfo() {
        try {
            Scanner sc = new Scanner(System.in);

            Student[] students = (Student[]) SerializationUtils.deserialize(filename);

            System.out.println("What's your name?");
            String input = sc.nextLine();
            Student result = null;
            for (Student s : students) {
                if (input.equals(s.getName())) {
                    result = s;
                    break;
                }
            }
            System.out.println("Update your GPA: ");
            double updatedGPA = sc.nextDouble();
            result.setGPA(updatedGPA);

            System.out.println("Update your address");
            String updatedAddress = sc.nextLine();
            result.setAddress(updatedAddress);

            System.out.println("Update your hobby");
            String updatedHobby = sc.nextLine();
            result.addHobby(updatedHobby);

            System.out.println("Update your course");
            String updatedCourse = sc.nextLine();
            result.addCourse(updatedCourse);

            SerializationUtils.serialize(result, filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        try {
//            SerializationUtils.serialize(getStudents(), filename);
//            Student[] students = (Student[])  SerializationUtils.deserialize(filename);
//            System.out.println(Arrays.toString(students));
//        } catch (IOException e) {
//            System.out.println("Exception occurred");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

       try {
           updateInfo();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

}