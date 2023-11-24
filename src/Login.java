
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author shubh
 */
public class Login {
    
    private static String userUsername, userPassword;
    public static boolean userIncorrect;
    //public static boolean userNotFound;
    
    public static void loginUser(String username, String password) throws FileNotFoundException
    {
        try(Scanner input = new Scanner(System.in);)
        {
            
            Scanner scan = new Scanner(new File(username + ".txt"));
        
            while(scan.hasNextLine())
            {
                userUsername = scan.nextLine();
                userPassword = scan.nextLine();
            }

            if (username.equals(userUsername) && password.equals(userPassword))
            {
                System.out.println("Login Successful!");
                LoginScreen label = new LoginScreen();
                userIncorrect = true;
            }
            else
            {
                System.out.println("Wrong username or password.");
                userIncorrect = false;
            }
        } catch(Exception e) {
            System.out.println("Username or password not found.");
            //userNotFound = false;
        }
    }
    
}
