import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AuthManager {
    private HashMap<String,String> users = new HashMap<>();
    private HashMap<String, ArrayList<String>> usersDetails = new HashMap<>();
    private Scanner input = new Scanner(System.in);
    private String loggedUser = null;

    public AuthManager() {
        dataStatic();
    }

    private void dataStatic() {
        String username = "@dmin";
        String password = "admin123";
        String fullName = "Admin";
        String address = "Cina";
        users.put(username, password);
        ArrayList<String> details = new ArrayList<>();
        details.add(fullName);
        details.add(address);
        usersDetails.put(username, details);
    }

    public void register(){
        System.out.println("\n=== Register User ===");
        System.out.print("Username: ");
        String username = input.nextLine().trim();
        if(username.isEmpty()){
            System.out.println("Username cannot be empty!");
            return;
        }
        String password = readPassword();
        if(password.isEmpty()){
            System.out.println("Password cannot be empty!");
            return;
        }
        System.out.print("Full Name: ");
        String fullName = input.nextLine().trim();
        if(fullName.isEmpty()){
            System.out.println("Full Name cannot be empty!");
            return;
        }
        System.out.print("Address: ");
        String address = input.nextLine();
        if(address.isEmpty()){
            System.out.println("Address cannot be empty!");
            return;
        }
        if(users.containsKey(username)){
            System.out.println("Username already exists!");
            return;
        }if(!username.contains("@")){
            System.out.println("Username must contain @");
            return;
        }if(password.length() < 8){
            System.out.println("Password must have at least 8 characters!");
            return;
        }
        users.put(username,password);
        ArrayList<String> details = new ArrayList<>();
        details.add(fullName);
        details.add(address);
        usersDetails.put(username,details);
        System.out.println("Registration successful!");
    }

    public void login(){
        System.out.println("\n=== Login ===");
        System.out.print("Username: ");
        String username = input.nextLine().trim();
        if(username.isEmpty()){
            System.out.println("Username cannot be empty!");
            return;
        }
        String password = readPassword();
        if(password.isEmpty()){
            System.out.println("Password cannot be empty!");
            return;
        }
        if(users.containsKey(username)&&users.get(username).equals(password)){
            loggedUser = username;
            ArrayList<String> details = usersDetails.get(username);
            String fullName = details.get(0);
            String address = details.get(1);
            System.out.println("\nLogin successful!");
            System.out.println("Welcome "+fullName+" ("+address+")");
        }else {
            System.out.println("Invalid username or password!");
        }
    }

    public void logout(){
        loggedUser = null;
        System.out.println("Logout successful!");
    }

    private String readPassword() {
        Console console = System.console();
        if (console != null) {
            char[] passwordChars = console.readPassword("Password: ");
            return new String(passwordChars).trim();
        }
        System.out.print("Password: ");
        return input.nextLine().trim();
    }
    
    public boolean isLoggedIn(){
        return loggedUser != null;
    }
    public String getLoggedInUser(){
        return loggedUser;
    }
}
