import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
public class Ticket {
    Movie movie;
    Customer customer;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
    LocalDateTime now = LocalDateTime.now(); ;
    String dateAndTimeOfPurchase;
    OneTimeCode otc = new OneTimeCode();
    

    public Ticket() {
    }

    public Ticket(Movie movie, Customer customer, String DnT) {
        this.movie = movie;
        this.customer = customer;
        this.dateAndTimeOfPurchase = DnT;
     
    }
   
    public String getDateAndTimeOfPurchase() {
        return this.dateAndTimeOfPurchase;
    }

    public void setDateAndTimeOfPurchase(String dateAndTimeOfPurchase) {
        this.dateAndTimeOfPurchase = dateAndTimeOfPurchase;
    }
  


    public OneTimeCode getOtc() {
        return this.otc;
    }

    public void setOtc(OneTimeCode otc) {
        this.otc = otc;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void displayInfo(){
        System.out.println("\n------ Congratulation "+getCustomer().getName()+", You just purchased a ticket------");
        System.out.println("\nTitle: "+getMovie().getTitle());
        System.out.println("Description: "+getMovie().getDescription());
        System.out.println("RunTime: "+getMovie().getRunTime());
        System.out.println("Type: "+getMovie().getType());
      

        if(this.movie instanceof OnlineScreening){
            OnlineScreening os = (OnlineScreening) this.movie;
            // System.out.println("Type: ");
            System.out.println("Platform: "+os.getStreamingPlatform());
            // System.out.println("Url: "+os.getUrl());
            System.out.println("One Time Code: "+otc.getCode());
            
            
        }
        else if(this.movie instanceof InPerson){
            InPerson ip = (InPerson) this.movie;
            // System.out.println("Type: "+ip.getType());
            // System.out.println("Tickets left: "+ ip.getMaxCapacity());
            System.out.println("Address: "+ip.getAddress());
            System.out.println("Date and time: "+ip.getDateAndTime());
          System.out.println("Type: "+getMovie().getType());
        }
        System.out.println("Date and time of Purchase: "+getDateAndTimeOfPurchase());
        
    }

    public boolean showOptionsOutput(String[] val,String[] logReturn, ArrayList<Movie> arr1,ArrayList<Ticket> ticketHistory,ArrayList<OneTimeCode> usedCode, ArrayList<Customer> cusArr){
        boolean a = true;
        switch (val[0]){
            case "0":
            break;
            case "1":
            // Output of all movies !!
            System.out.println("\n------ List of all the movies ------");
                for(Movie m : arr1){
                    System.out.println(m);
                }
            break;
            
            case "2":
            // Output of In-person Movies List !!
            System.out.println("\n------ List of In-person movies ------");
            for(Movie m : arr1){
                if(m instanceof InPerson){
                    System.out.println(m); 
                }
            }
            break;
            
            case "3":
            // View purchase History
            // Checking if user has purchased any ticket before
            if(ticketHistory.size() == 0){
                System.out.println("\nSorry, you haven't purchased any ticket yet!!!");
            }
            else {
                //Showing the puchase history
                // Count is used to print Movie 1, Movie 2, etc.
                int count = 1;
                // Flag is used to chech if there is any purchase history or not !!
                int flag = 0;
                System.out.println("\n------ Your purchase history -------");
                // For loop to print all the Purchased tickets
                for(Ticket tic : ticketHistory){
                    //Checking The user Name
                    // This block of code works if user logOut or return to the Login Screen!!
                    if(val[2] != null){
                        logReturn[2] = val[2];
                    }
                    // Checking the user name, So it will show the tickets of specific user !!
                    if(tic.getCustomer().getName().equals(logReturn[2])){

                        // This block of code will give an output of Online Screening with One time Code
                        if(tic.movie instanceof OnlineScreening){
                        System.out.println("\nMovie "+count+++" :");
                        System.out.println(tic.getMovie());
                        System.out.println("One time code: "+tic.getOtc());
                        System.out.println("Date and time of purchase: "+tic.getDateAndTimeOfPurchase());
                        flag = 1;
                        }
                        //THis else will give an output of In-person Movie
                        else{
                            InPerson ip = (InPerson) tic.movie;
                            System.out.println("\nMovie "+count+++" :");
                            System.out.println("Title: "+tic.getMovie().getTitle());
                            System.out.println("Direction: "+tic.getMovie().getDirector());
                            System.out.println("RunTime: "+tic.getMovie().getRunTime());
                            System.out.println("Genre: "+tic.getMovie().getGenre());
                            System.out.println("Type :"+tic.getMovie().getType());
                            System.out.println("Address: "+ip.getAddress());
                            System.out.println("Date and Time: "+ip.getDateAndTime());
                            System.out.println("Date and time of purchase: "+tic.getDateAndTimeOfPurchase());
                            flag = 1;
                        }
                        
                    }
                }
                
                if(flag == 0){
                    System.out.println("\nSorry, you haven't purchased any ticket yet!!!");
                }
            }

            break;
            case "4":
            // Access to Online movie 

            // System.out.println("\n------ Link for Online Movie ------");
            // Checking is there any ticket Purchased by user before
            if(ticketHistory.size() == 0){
                System.out.println("\nSorry, you haven't purchased any ticket yet!!!");
            }
            else {
                int count = 1;
                int flag = 0;
                int flag2 = 0;
                int flag3 = 0;
                System.out.println("\n------ Online Movies You have purchased -------");

                //This array list is to store Movie one time code
                ArrayList<OneTimeCode> storeOnlineScreening = new ArrayList<OneTimeCode>();
                
                // THis array list will show the url to user after Entering the one time code !!
                ArrayList<String> url = new ArrayList<String>();

                for(Ticket tic : ticketHistory){
                    // Checking the user is same or different
                    if(val[2] != null){
                        logReturn[2] = val[2];
                    }
                    // This block of code will show the purchased Online Screening movie tickets
                    // When user bought the ticket that time user name also stored in the ticket arrayList
                    //Checking which user is it?
                    if(tic.getCustomer().getName().equals(logReturn[2])){
                        if(tic.getMovie().getType().equals("Online Screening")){
                            // Print only Online screening movies
                            if(tic.movie instanceof OnlineScreening){
                                OnlineScreening os = (OnlineScreening) tic.movie;

                                // Adding the one TIme code to StoreOnlineScreening array
                                storeOnlineScreening.add(tic.getOtc());
                                // Adding the url to url array
                                url.add(os.getUrl());
                                System.out.println("Movie "+count+++" :");
                                System.out.println(tic.getMovie());
                                System.out.println("Date and time purchase: "+tic.getDateAndTimeOfPurchase());
                                flag = 1;
                            }
                    
                        }
                    }
                }
                if(flag == 0){
                    System.out.println("\nSorry, you haven't purchased any Online Screening ticket yet!!!");
                }
                // If there is any online movie then this line of code will work !!
                else{
                    Scanner in = new Scanner(System.in);
                    System.out.print("\nWhich Movie you wants to watch: ");
                    String inputVal = in.next(); 
                  
                    try 
                    { 
                      
                        Integer.parseInt(inputVal);
                       
                    }  
                    catch (NumberFormatException e)  
                    { 
                       
                       flag3 = 1;
                    } 
                    
                    if(flag3 == 0){
                        int UserInput = Integer.parseInt(inputVal);
                        if(UserInput >=1 && UserInput <= storeOnlineScreening.size()){
                            System.out.print("\nEnter the one time Code: ");
                            String codeInput = in.next();
                            
                            // Checking the user input with The One time Code 
                            // Checking if it is valid or not
                            if(codeInput.equals(storeOnlineScreening.get(UserInput - 1).toString())){
    
                                // Checking if the code has already been used !!
                                if(usedCode.isEmpty()){
                                    flag2 = 0;
                                    
                                }else {
                                   
                                    // Checking Loop
                                    for(int i = 0; i < usedCode.size(); i++){
                                        
                                      if(codeInput.equals(usedCode.get(i).toString())){
                                            flag2 = 1;
                                      }
                                    }
                                }
                                if(flag2 == 0){
                                    // If code never used before then this block of code will show the Url to user
                                    System.out.println("\nLink: "+url.get(UserInput - 1));
                                    //After showing the url !! ont time code will store to the usedCode Array. SO next time user 
                                    //cannot use the One time code again
                                    usedCode.add(storeOnlineScreening.get(UserInput - 1));
                                    break;
                                  
                                }else{
                                    System.out.println("\nThis code has already been used !!");
                                    break;
                                }
                              
                            }
                            else{
                                System.out.println("Wrong Code");
                                break;
                            }
                        }else{
                            System.out.println("Wrong Input Try again!!");
                            break;
                        }
                    }else{
                        System.out.println("\nInput is not an Integer Value!! Try it Again!!");
                    }
                    // Comparing the user Input with Array index !!
                    // SO our compiler knows which movie user selected
   
                    
                }
               
            } 
            break;

            case "5":
            System.out.println("\n------ Buy Ticket ------");
            int count = 1;
            int flag = 0;
            // This piece of code will show the list of movies  So users can enter the Movie which Movie they want to buy
            for(Movie m : arr1){
                System.out.println();
                System.out.println("Movie "+count+++" :");
                System.out.println("Title: "+m.getTitle());
                System.out.println("RunTime: "+m.getRunTime());
                System.out.println("Type: "+m.getType());
                // If movie is online then it will also show the Streaming platform
                if(m instanceof OnlineScreening){
                    OnlineScreening os = (OnlineScreening) m;
                    // System.out.println("Type: ");
                    System.out.println("Platform: "+os.getStreamingPlatform());
               
                }
                // If the moview is In-person then it will show the address and Date/Time
                else if(m instanceof InPerson){
                    InPerson ip = (InPerson) m;
                    // System.out.println("Type: "+ip.getType());
                    System.out.println("Tickets Left: "+ip.getMaxCapacity());
                    System.out.println("Address: "+ip.getAddress());
                    System.out.println("Date and time: "+ip.getDateAndTime());
                  
                }
              
            }
            //Taking input from user
            // Which movie ticket they want to buy !!
            Scanner in = new Scanner(System.in);
            System.out.print("\nWhich movie ticket you want to buy(eg:- 1,2,3 etc.): ");
            String input12 = in.next();
            try 
            { 
                Integer.parseInt(input12); 
               
            }  
            catch (NumberFormatException e)  
            { 
               flag = 1;
            } 
            if(flag == 0){
                Ticket ticket;
                if(val[1] != null){
                    logReturn[1] = val[1];
                }
                // this code will give The customer index !!
               
               int val1 = Integer.parseInt(logReturn[1]);
           
               int max = 0;
                int uInput =  Integer.parseInt(input12);
                    // int val3 = Integer.parseInt(logReturn[1]);
                    // Ticket Constructer has two Parameters 
                    //1. Movie 2. Customer
    
                    //cusArr.get(val1) will add the customer to the Ticket list !!
                    if(uInput > 0 && uInput <= arr1.size()){
                        String purchaseDateAndTime = dtf.format(now);
                    ticket = new Ticket(arr1.get(uInput - 1),cusArr.get(val1),purchaseDateAndTime);
                    if(arr1.get(uInput - 1) instanceof InPerson){
    
                        InPerson ip = (InPerson) ticket.getMovie();
                        max = ip.getMaxCapacity();
                        if(max <= 0){
                           
                            System.out.println("\nAll tickets are sold out");
                        }
                        else{
                            ticketHistory.add(ticket);
                            max--;
                            ip.setMaxCapacity(max);
                            ticket.displayInfo();
                        }
                    }
                    else{
                        ticketHistory.add(ticket);
                        ticket.displayInfo();
                    }
    
                }
                else{
                    System.out.println("\nInvalid input Try again !!");
                }
            
            }else{
                System.out.println("\nInput is not an Integer Value!! Try it Again!!");
            }
            break;
            case "q":
            a = false;
            System.out.println("Exit");
            break;
        }
        return a;
      }

    @Override
    public String toString() {
        return 
            " movie='" + getMovie() + "'" +
            ", customer='" + getCustomer() + "'" +
            "}";
    }

}
