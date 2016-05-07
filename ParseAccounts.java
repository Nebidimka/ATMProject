package ATM;


import java.io.*;
import java.util.ArrayList;

/**
 * Created by Zeizara on 5/7/2015.
 */
public class ParseAccounts {
    public static void createCustomers() {

        ParseAccounts objectIO = new ParseAccounts();
        int count = 1;
        String filepath = "C:\\Users\\Zeizara\\IdeaProjects\\csci185\\CustomerData" + count + ".txt";
        File f = new File(filepath);
        if (!f.exists() || f.isDirectory()) {

            Customer customer1 = new Customer(1000001, 4758, new SavingsAccount(200), new CheckingAccount(100));
            objectIO.WriteObjectToFile(filepath, customer1);
            count++;
            filepath = "C:\\Users\\Zeizara\\IdeaProjects\\csci185\\CustomerData" + count + ".txt";
            Customer customer2 = new Customer(1000002, 5151, new SavingsAccount(200), new CheckingAccount(100000));
            objectIO.WriteObjectToFile(filepath, customer2);
            count++;
            filepath = "C:\\Users\\Zeizara\\IdeaProjects\\csci185\\CustomerData" + count + ".txt";
            Customer customer3 = new Customer(1000003, 9001, new SavingsAccount(200), new CheckingAccount(100000));
            objectIO.WriteObjectToFile(filepath, customer3);
            count++;
            filepath = "C:\\Users\\Zeizara\\IdeaProjects\\csci185\\CustomerData" + count + ".txt";
            Customer customer4 = new Customer(1000004, 1996, new SavingsAccount(200), new CheckingAccount(100000));
            objectIO.WriteObjectToFile(filepath, customer4);

        }
    }

    public static ArrayList<Customer> importCustomers(ArrayList<Customer> a) {

        ParseAccounts objectIO = new ParseAccounts();
        for (int i = 1; i < 5; i++) {

            String filepath = "C:\\Users\\Zeizara\\IdeaProjects\\csci185\\CustomerData" + i + ".txt";
            a.add((Customer) objectIO.ReadObjectFromFile(filepath));
        }
        return a;
    }

    public static void saveCustomers(ArrayList<Customer> a) {

        ParseAccounts objectIO = new ParseAccounts();
        for (int i = 0; i < a.size(); i++) {

            String filepath = "C:\\Users\\Zeizara\\IdeaProjects\\csci185\\CustomerData" + (int)(i+1) + ".txt";
            objectIO.WriteObjectToFile(filepath, a.get(i));

        }
    }

    public void WriteObjectToFile(String filepath, Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
