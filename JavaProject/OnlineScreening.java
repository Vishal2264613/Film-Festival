public class OnlineScreening extends Movie{
    private String streamingPlatform;
    private String url;
   

    public OnlineScreening() {
    }

  
    public OnlineScreening(String title, String director, String description, String genre, String runTime,String type,String streamingPlatform, String url) {
        super(title, director, description, genre, runTime,type);
        this.streamingPlatform = streamingPlatform;
        this.url = url;
       
    }

  

    public String getStreamingPlatform() {
        return this.streamingPlatform;
    }

    public void setStreamingPlatform(String streamingPlatform) {
        this.streamingPlatform = streamingPlatform;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nstreamingPlatform: " + getStreamingPlatform() + 
            "\n";
    }

}
