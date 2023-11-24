package org.example.customers;

import org.example.flight.DBFlightDAO;
import org.example.flight.Flight;
import org.example.persistence.util.DAO;

import java.util.ArrayList;
import java.util.List;

public class CustomersDataStorage {
    public void addCustomersList(){
        DAO customersDAO = new DBCustomersDAO();

        List<Customers> customers = generateCustomers();

        for (Customers customer : customers) {
            customersDAO.add(customer);
        }
    }

    public List<Customers> generateCustomers(){
       List<Customers> customers = new ArrayList<>();

       customers.add(new Customers(0, "Olivia", "olivia@gmail.com", "+49134342464"));
        customers.add(new Customers(1, "John Doe", "john.doe@example.com", "+49123456789"));
        customers.add(new Customers(2, "Jane Smith", "jane.smith@example.com", "+49123456788"));
        customers.add(new Customers(3, "Michael Johnson", "michael.johnson@example.com", "+49123456787"));
        customers.add(new Customers(4, "Emily Davis", "emily.davis@example.com", "+49123456786"));
        customers.add(new Customers(5, "Daniel Brown", "daniel.brown@example.com", "+49123456785"));
        customers.add(new Customers(6, "Olivia Wilson", "olivia.wilson@example.com", "+49123456784"));
        customers.add(new Customers(7, "Christopher Lee", "christopher.lee@example.com", "+49123456783"));
        customers.add(new Customers(8, "Sophia Moore", "sophia.moore@example.com", "+49123456782"));
        customers.add(new Customers(9, "William Hall", "william.hall@example.com", "+49123456781"));
        customers.add(new Customers(10, "Emma Taylor", "emma.taylor@example.com", "+49123456780"));
        customers.add(new Customers(11, "Aiden Clark", "aiden.clark@example.com", "+49123456779"));
        customers.add(new Customers(12, "Ella White", "ella.white@example.com", "+49123456778"));
        customers.add(new Customers(13, "Caleb King", "caleb.king@example.com", "+49123456777"));
        customers.add(new Customers(14, "Lily Harris", "lily.harris@example.com", "+49123456776"));
        customers.add(new Customers(15, "Logan Adams", "logan.adams@example.com", "+49123456775"));
        customers.add(new Customers(16, "Grace Turner", "grace.turner@example.com", "+49123456774"));
        customers.add(new Customers(17, "Mason Scott", "mason.scott@example.com", "+49123456773"));
        customers.add(new Customers(18, "Ava Murphy", "ava.murphy@example.com", "+49123456772"));
        customers.add(new Customers(19, "Lucas Green", "lucas.green@example.com", "+49123456771"));
        customers.add(new Customers(20, "Harper Baker", "harper.baker@example.com", "+49123456770"));
        customers.add(new Customers(21, "Ethan Carter", "ethan.carter@example.com", "+49123456769"));
        customers.add(new Customers(22, "Madison Kelly", "madison.kelly@example.com", "+49123456768"));
        customers.add(new Customers(23, "Jackson Rivera", "jackson.rivera@example.com", "+49123456767"));
        customers.add(new Customers(24, "Avery Brooks", "avery.brooks@example.com", "+49123456766"));
        customers.add(new Customers(25, "Evelyn Price", "evelyn.price@example.com", "+49123456765"));
        customers.add(new Customers(26, "Carter Ward", "carter.ward@example.com", "+49123456764"));
        customers.add(new Customers(27, "Aria Hayes", "aria.hayes@example.com", "+49123456763"));
        customers.add(new Customers(28, "Grayson Foster", "grayson.foster@example.com", "+49123456762"));
        customers.add(new Customers(29, "Scarlett Simmons", "scarlett.simmons@example.com", "+49123456761"));
        customers.add(new Customers(30, "Liam Russell", "liam.russell@example.com", "+49123456760"));
        customers.add(new Customers(31, "Zoe Butler", "zoe.butler@example.com", "+49123456759"));
        customers.add(new Customers(32, "Lincoln Murphy", "lincoln.murphy@example.com", "+49123456758"));
        customers.add(new Customers(33, "Paisley Simmons", "paisley.simmons@example.com", "+49123456757"));
        customers.add(new Customers(34, "Owen Parker", "owen.parker@example.com", "+49123456756"));
        customers.add(new Customers(35, "Nova Ward", "nova.ward@example.com", "+49123456755"));
        customers.add(new Customers(36, "Leo Harris", "leo.harris@example.com", "+49123456754"));
        customers.add(new Customers(37, "Skylar Brooks", "skylar.brooks@example.com", "+49123456753"));
        customers.add(new Customers(38, "Aurora Reed", "aurora.reed@example.com", "+49123456752"));
        customers.add(new Customers(39, "Gabriel Turner", "gabriel.turner@example.com", "+49123456751"));
        customers.add(new Customers(40, "Sofia Collins", "sofia.collins@example.com", "+49123456750"));
        customers.add(new Customers(41, "Hudson Parker", "hudson.parker@example.com", "+49123456749"));
        customers.add(new Customers(42, "Aubrey Foster", "aubrey.foster@example.com", "+49123456748"));
        customers.add(new Customers(43, "Eli Clark", "eli.clark@example.com", "+49123456747"));

        return customers;
    }
}
