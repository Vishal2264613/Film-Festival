import java.util.ArrayList;
import java.util.Scanner;
public class Customer {
    private String Name;
    private String emailAddress;
    private String Password;
    Scanner in = new Scanner(System.in);


    public Customer() {
    }

    public Customer(String Name, String emailAddress, String Password) {
        this.Name = Name;
        this.emailAddress = emailAddress;
        this.Password = Password;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    // Welcome screen on app
    public void welcomeScreen(){
        System.out.println();
        System.out.println("Hello, Welcome to the application: ");
   
    }
    // Validatiing user info
    ArrayList<Customer> array;
    public String[] logIn(ArrayList<Customer> arr){
        array = arr;
        String email;
        String pass;
        String[] flag = new String[5]; 

        //flag[1] = Index of customer
        //flag[2] = Index of customer
        // flag[] = "q";
        int flag2 = 0;
       
        System.out.println();
      
        System.out.print("Enter 1 to login or q to exit: ");
        String userinput = in.next();

        if(userinput.equals("1")){
            System.out.print("Email address: ");
            email = in.next();
    
            System.out.print("Password: ");
            pass = in.next();
            // CusIndex to set the user Position !!
            //  eg: - 0 = Vishal, 1 = Devjot, 2 = Mukul
            Integer cusIndex = 0;
            for(Customer c: arr){

            // Checking user details
            if(email.equals(c.emailAddress) && pass.equals(c.Password)){
                System.out.println("\nHello "+c.Name);
                System.out.println();
                System.out.println("You are Logged In");
                flag[1] = Integer.toString(cusIndex);
                flag[2] = c.Name;
                flag2 = 1;
                flag[0] = "1";
            }
            cusIndex++;
        }
        if(flag2 == 0){
            System.out.println("Wrong username and password Please try again");
            // this will update the values in flag
            flag = logIn(arr);
        }
 
            
        }else if(userinput.equals("q")){
            flag[0] = "q";
        }
        else{
            System.out.println("\ninvalid input try again!!");
            flag = logIn(arr);
        }
       return flag;
  
    }
    // Choices for user after login
    String[] inp = new String[5];
    public String[] afterLogIn(){
        // String input;
        
        System.out.println();
        
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1. See list of all movies");
        System.out.println("2. View in-person movie schedule");
        System.out.println("3. View ticket purchase history");
        System.out.println("4. Get link to online movie");
        System.out.println("5. Buy Tickets");
        System.out.println("6. Logout or return to login Screen");

        System.out.print("Enter your Choice: ");
        inp[0] = in.next();
       
        // System.out.println("Entered value is "+input);
        
        switch (inp[0]){
            case "1":
            inp[0] = "1";
            break;
            case "2":
            inp[0] = "2";
            break;
            case "3":
            inp[0] = "3";
            break;
            case "4":
            inp[0] = "4";
            break;
            case "5":
            inp[0] = "5";
            break;
            case "6":
            System.out.println("");
            System.out.println("You are Logged out");
            
            inp = logIn(array);

            if(inp[0] == "q"){
                inp[0] = "q";
            }else{
            inp[0] = "0";
            }
            //     input = afterLogIn();
            // }
            break;
            default:
            System.out.println("\nInvalid input try again!!");
            inp = afterLogIn();
            break;
        }
        return inp;
}


    @Override
    public String toString() {
        return "{" +
            " Name='" + getName() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            ", Password='" + getPassword() + "'" +
            "}";
    }

}