import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountsThingy {

    private static String userUsername;
    private static String userPassword;

    public static void creatingUser() throws FileNotFoundException, IOException 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();

        File account = new File(username + ".txt");
                
        try (FileOutputStream oFile = new FileOutputStream(account, false)) {}

        FileWriter myWriter = new FileWriter(username + ".txt");
        myWriter.write(username + "\n");
        myWriter.write(password);
        myWriter.close();

        newLoginUser(username);

        input.close();
    }

    public static void newLoginUser(String username) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(username + ".txt"));
        Scanner input = new Scanner(System.in);
        
        while(scan.hasNextLine())
        {
            userUsername = scan.nextLine();
            userPassword = scan.nextLine();
        }

        System.out.print("Username: ");
        String inputUser = input.nextLine();

        System.out.print("Password: ");
        String inputPassword = input.nextLine();

        if (inputUser.equals(userUsername) && inputPassword.equals(userPassword))
        {
            System.out.println("Login Successful!");
        }
        else
        {
            System.out.println("Wrong username or password.");
        }

        input.close();
                
    }
    
    public static void loginUser() throws FileNotFoundException 
    {
        try(Scanner input = new Scanner(System.in);)
        {
            System.out.print("Username: ");
            String inputUser = input.nextLine();
        
            Scanner scan = new Scanner(new File(inputUser + ".txt"));
        
            while(scan.hasNextLine())
            {
                userUsername = scan.nextLine();
                userPassword = scan.nextLine();
            }

            System.out.print("Password: ");
            String inputPassword = input.nextLine();

            if (inputUser.equals(userUsername) && inputPassword.equals(userPassword))
            {
                System.out.println("Login Successful!");
            }
            else
            {
                System.out.println("Wrong username or password.");
            }
        } catch(Exception e) {
            System.out.println("Wrong Username or Password");
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        Scanner scanning = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. Login to your Account \n2. Create your account");

            int inputType = scanning.nextInt();

            if (inputType == 1)
            {
                loginUser();
                break;
            }
            else if (inputType == 2)
            {
                creatingUser();
                break;
            }
            else
            {
                System.out.println("Wrong input.");
            }

        }

        scanning.close();
        
    }

}


    
