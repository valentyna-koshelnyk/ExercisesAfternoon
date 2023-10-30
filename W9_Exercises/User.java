package W9_Exercises;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void assertCorrectAge(int age) {
        if(age < 0 || age >= 150) {
            throw new IllegalArgumentException("User age cannot be negative or higher than 150");
        }
    }

    public User(String name, String email, String phoneNumber, int age) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        assertCorrectAge(age);
        this.age = age;
    }

    public User() {
        System.out.println("Enter your name: ");
        this.name = sc.nextLine();
        System.out.println("Enter your email: ");
        this.email = sc.nextLine();
        System.out.println("Enter your phone number: ");
        this.phoneNumber = sc.nextLine();
        System.out.println("Enter your age: ");
        this.age = sc.nextInt();
        assertCorrectAge(age);
        }

    public  static User getUserInfo() {
        User user;
        return user = new User("Eve", "eve@gmail.com", "1767034455", 33);
    }

    @Override
    public String toString(){
        return String.valueOf(sb.append("|User's name:| ").append(name)
                .append("\n" + name + "'s email:| ").append(email)
                .append("\n" + name + "'s phone: | " ).append(phoneNumber)
                .append("\n" + name + "'s age: | ").append(age));
    }

    public StringBuilder stringToFile(){
        return sb.append(name + " | ")
                .append(email + " | ")
                .append(phoneNumber + " | ")
                .append(age + " | ");
    }

    public void getAddress(){
        User user = getUserInfo();
        System.out.println("Write your address: ");
        StringBuilder user1 = user.stringToFile();
        String address = sc.nextLine();
        address = String.valueOf(sb.append(" | " + address));

        try (FileWriter fw = new FileWriter("output.data");) {
            fw.write(String.valueOf(user1));
            fw.write(address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readInfo(){
        try(BufferedReader reader = new BufferedReader(new FileReader("output.data"))){
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUserBirthYear(){
        User user = getUserInfo();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int wasBorn = currentYear - user.getAge();
        System.out.println(sb.append(user.getName()).append(" was born in ").append(wasBorn));
    }

    public String getFavoriteBook(){
        List<Book> bookList = new ArrayList<>();
        Book bookOne = new Book("Harry Potter", "Rowling", 1998);
        Book bookTwo = new Book("Java Programming", "Anonymous", 1998);
        bookList.add(bookOne);
        bookList.add(bookTwo);
        String bookListString = bookList.toString();

        User user = getUserInfo();
        String userString = String.valueOf(user.stringToFile());
        StringBuilder str = sb.append(userString).append(bookListString);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter("output.data"))){
            bf.write(String.valueOf(str));
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bookListString;
    }

    public boolean isValidEmail(){
        String email = getUserInfo().email;
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void favoriteColour(){
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("output.data"))) {
           HashMap<Integer, String> colours = new HashMap<>();
           System.out.println("Do you like any of these colours? ");
           colours.put(1, "blue");
           colours.put(2, "yellow");
           colours.put(3, "red");
           colours.put(4, "black");
           colours.put(5, "white");
           colours.getOrDefault(6, "brown");
           colours.forEach((key, value) -> System.out.println(key + " " + value));
           System.out.println("If yes, put a number of your favorite colour: ");
           int input = sc.nextInt();
           User user = getUserInfo();
           String colour = null;
           String userString = String.valueOf(user.stringToFile());
            if (colours.containsKey(input)){
                 colour = colours.get(input).toString();
            }
           StringBuilder str = sb.append(userString).append(colour);
           bf.write(String.valueOf(str));
           System.out.println(colour);
       } catch(IllegalArgumentException e) {
            System.out.println("The colour with this number doesn't exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


 }




