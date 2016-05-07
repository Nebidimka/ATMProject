package ATM;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Zeizara on 5/15/2015.
 */
public class Receipt {
    public Receipt(){
        receipt+=("Receipt for the operations made at Aleksandr Skidelskiy Bank");
    }
    public static void addData(String input){
        receipt+=("\n"+input);
    }

    public static void saveReceipt() throws FileNotFoundException{
        String filepath = ("C:\\Users\\Zeizara\\IdeaProjects\\csci185\\Receipt.txt");
        PrintWriter out=new PrintWriter(filepath);
        out.println(receipt);
        out.close();
    }

    private static String receipt;
}
