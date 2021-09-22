public class OneTimeCode {
    private int code;


    public OneTimeCode() {
        int min = 10000;
        int max = 99999;
        code = (int)Math.floor(Math.random()*(max-min+1)+min);
        this.setCode(code);
    }

    public OneTimeCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    // public void genrateCode(){
    //     int min = 10000;
    //   int max = 99999;
    //     code = (int)Math.floor(Math.random()*(max-min+1)+min);
    //     this.setCode(code);
  

    // }

    @Override
    public String toString() {
        return 
           ""+ getCode() ;
    }

}
