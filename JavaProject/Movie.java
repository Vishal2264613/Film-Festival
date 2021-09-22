public class Movie {
    private String title;
    private String director;
    private String description;
    private String genre;
    private String runTime;
    private String type;

    public Movie() {
    }


    public Movie(String title, String director, String description, String genre, String runTime,String type) {
        this.title = title;
        this.director = director;
        this.description = description;
        this.genre = genre;
        this.runTime = runTime;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRunTime() {
        return this.runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return 
            "\ntitle: " + getTitle() + 
            "\ndirector: " + getDirector() + 
            "\ndescription: " + getDescription() +
            "\ngenre: " + getGenre() + 
            "\nrunTime: " + getRunTime() +
            "\nType: " + getType() ;
    }

}
