import java.util.ArrayList;
// import java.util.Scanner;

public class ProMain {
    
    public static void main(String[] args) {


    //This is for a while loop
     boolean a = true;

     //This is an array to store the used code
      ArrayList<OneTimeCode> usedCode = new ArrayList<OneTimeCode>();
      // This is an array to store the tiket history of user !!
      ArrayList<Ticket> ticketHistory = new ArrayList<Ticket>(); 

        // Random Object for calling
        Customer c = new Customer();  

        //Customer Object
        Customer VISHAL = new Customer("Vishal", "v1@gmail.com","pass");
        Customer DEVJOT = new Customer("Devjot", "d2@gmail.com","pass");
        Customer MUKUL = new Customer("Mukul", "m3@gmail.com","pass");

        //This is an array to store the customers
        ArrayList<Customer> cusArr = new ArrayList<Customer>(); 
        
        cusArr.add(VISHAL);
        cusArr.add(DEVJOT);
        cusArr.add(MUKUL);

        // Movie Objects

        Movie m1 = new InPerson("Venom: Let There Be Carnage", "Andy Serkis",
         "Venom springs into action when notorious serial killer Cletus Kasady transforms into the evil Carnage.",
          " Adventure/Superhero", "1h 30m","In-person", "255 Main Street Toronto", 3, "Monday Afternoon");

        Movie m2 = new InPerson("No Time To Die", "Cary Joji Fukunaga",
          "Recruited to rescue a kidnapped scientist, globe-trotting spy James Bond finds himself hot on the trail of a mysterious villain, who's armed with a dangerous new technology.",
           "Action/Adventure", "2h 43m","In-person", "12 Street Toronto", 3, "Tuesday Morning");

        Movie m3 = new InPerson("F9", "Justin Lin",
           "Dom Toretto is living the quiet life off the grid with Letty and his son, but they know that danger always lurks just over the peaceful horizon",
            "Action/Adventure", "2h 15m","In-person", "25 Street Torronto", 3, "Wednesday Evening");

        Movie m4 = new OnlineScreening("Army of the Dead", "Zack Snyder",
         "After a zombie outbreak in Las Vegas, a group of mercenaries takes the ultimate gamble by venturing into the quarantine zone for the greatest heist ever.",
          "Horror/Action", " 2h 28m","Online Screening", "Netflix", "https://www.netflix.com/in/title/81046394");

        Movie m5 = new OnlineScreening("Outside the Wire", "Mikael Håfström",
         "In the near future, a drone pilot sent into a war zone finds himself paired up with a top-secret android officer on a mission to stop a nuclear attack.",
         "Sci-fi,Action", "1h 55m", "Online Screening","Netflix", "https://www.netflix.com/in/title/81074110");
        Movie m6 = new OnlineScreening("The Big Sick", "Michael Showalter",
         "Kumail is a Pakistani comic, who meets an American graduate student named Emily at one of his stand-up shows", 
         "Romance/Drama", "2 hours","Online Screening", "Amazon prime", "https://www.amazon.com/Big-Sick-Kumail-Nanjiani/dp/B089Y8DYY9");
       
       // This an array to store the List of movies
       ArrayList<Movie> arr1 = new ArrayList<Movie>();
       arr1.add(m1);
       arr1.add(m2);
       arr1.add(m3);
       arr1.add(m4);
       arr1.add(m5);
       arr1.add(m6);

        // Calling a Welcome Screen Once !!
        c.welcomeScreen();

        // LogReturn is an array to store the return value from login method !!
        String logReturn[] = new String[5];

        //Calling a Login Method !!
        logReturn = c.logIn(cusArr);
        
        // If logReturn[0] is equal to 1 then user can login 
        //If logReturn[0] is equal to q then code will Exit !!
        if(logReturn[0] == "1"){

            // This is while loop for keep asking users What they want?
            while(a){
                // Array to store return array from afterLogin method
                String[] val =  new String[5];
                // Calling a afterLogin Method
                val = c.afterLogIn();
         
                // Calling the showOutputMethod    
                Ticket t = new Ticket();
               a = t.showOptionsOutput(val,logReturn,arr1,ticketHistory,usedCode,cusArr);    
            }
                   
        }else{
            System.out.println("Exit");
        }
    
    }

}
