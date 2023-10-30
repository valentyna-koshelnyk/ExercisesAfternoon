//package W9C5_Deserialization;
//import java.io.*;
//import java.util.*;
//import java.util.stream.DoubleStream;
//
//public class Util implements Serializable {
//    private static String filename = "outputData.out";
//    List<Student> students = new ArrayList<>();
//
//    /**
//     * Serialize the given object and save it to given file
//     */
//
//    public static void serialize(Object obj, String fileName) throws IOException {
//        FileOutputStream fos = new FileOutputStream(fileName);
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(obj);
//        oos.close();
//    }
//
//    /**
//     * Deserialize to Object from given file
//     */
//    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
//        FileInputStream fis = new FileInputStream(fileName);
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        Object obj = ois.readObject();
//        ois.close();
//        return obj;
//    }
//
//    public static void searchStudent(List<Student> students, String searchTerm) {
//        System.out.println("Searching for: " + searchTerm);
//        boolean found = false;
//        for (Student student : students) {
//            if (student.getName().equals(searchTerm) || student.getStudentID().equals(searchTerm) || student.getHobbies().contains(searchTerm)) {
//                System.out.println("Student found:");
//                System.out.println("Name: " + student.getName());
//                System.out.println("Student ID: " + student.getStudentID());
//                System.out.println("Hobbies: " + student.getHobbies());
//                found = true;
//                break;
//            }
//        }
//        if (! found) {
//            System.out.println("Student not found.");
//        }
//    }
//
//    public static void findStudent() {
//        Student student1 = new Student("Alice", 20, List.of("Reading", "Traveling"), "12345");
//        Student student2 = new Student("Bob", 22, List.of("Gaming", "Cooking"), "12345");
//        List<Student> students = new ArrayList<>();
//        students.add(student1);
//        students.add(student2);
//
//        String filename = "studentDes";
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What would you like to find?");
//        String input = sc.nextLine();
//
//        try {
//            serialize(students, filename);
//            List<Student> deserializedStudents = (List<Student>) deserialize(filename);
//            searchStudent(deserializedStudents, input);
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteStudent() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What would you like to delete?");
//        String input = sc.nextLine();
//
//        try {
//            serialize(students, filename);
//            List<Student> deserializedStudents = (List<Student>) deserialize(filename);
//            searchStudent(deserializedStudents, input);
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("If you'd like to delete your record, write your id or your name: " + input);
//
//        boolean found = false;
//        for (Student student : students) {
//            if (student.getName().equals(input) || student.getStudentID().equals(input)) {
//                students.remove(student);
//                break;
//            }
//        }
//        if (! found) {
//            System.out.println("Student not found.");
//        }
//        System.out.println(students.toString());
//    }
//
//    public void calculateAvgGPA() {
//        Student student1 = new Student("Alice", 20, List.of("Reading", "Traveling"), "12345", 3.7);
//        Student student2 = new Student("Bob", 22, List.of("Gaming", "Cooking"), "12345", 2.5);
//        List<Student> students = new ArrayList<>();
//
//        students.add(student1);
//        students.add(student2);
//        try {
//            serialize(students, filename);
//            List<Student> deserializedStudents = (List<Student>) deserialize(filename);
//
//            OptionalDouble GPA = students.stream().mapToDouble(Student::getGpa)
//                    .average();
//            for (Student student : students) {
//                System.out.println(student.getName() + student.getHobbies());
//            }
//            System.out.println("Average GPA: " + GPA);
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void updateStudentInfo() {
//        Student student1 = new Student("Alice", 20, List.of("Reading", "Traveling"), "12345", 3.7);
//        Student student2 = new Student("Bob", 22, List.of("Gaming", "Cooking"), "12345", 2.5);
//        List<Student> students = new ArrayList<>();
//
//        students.add(student1);
//        students.add(student2);
//
//        System.out.println("Which field would you like to update?");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        }
//
//        for (Student student : students) {
//
//            if (student.getName().equals(input)) {
//                student.setName(input);
//            } else {
//                if (student.getHobbies().equals(input)) {
//                    student.setHobbies(Collections.singletonList(input));
//                } else {
//                    if (student.getCourses().equals(input)) {
//                        student.setCourses(Collections.singletonList(input));
//                    } else {
//                        if (student.getGrades().equals(input)) {
//                            student.setGrades(Collections.singletonList(input));
//                        }
//                    }
//                }
//            }
//        }
//        try {
//            serialize(students, "updatedFile");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
//
//
