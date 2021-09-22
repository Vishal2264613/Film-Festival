public class InPerson extends Movie{
    private String address;
    private int maxCapacity;
    private String dateAndTime;
   

    public InPerson() {
    }

    public InPerson(String title, String director, String description, String genre, String runTime,String type,String address, int maxCapacity, String dateAndTime) {
        super(title, director, description, genre, runTime,type);
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.dateAndTime = dateAndTime;
    
    }

  

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getDateAndTime() {
        return this.dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\naddress: " + getAddress() + 
            "\nTickets Left: " + getMaxCapacity() + 
            "\ndateAndTime: " + getDateAndTime() +
            "\n";
    }

}
