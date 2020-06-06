public class Date {
   private int day;
   private int month;
   private int year;

    public Date(int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int d){
        this.day = d;
    }

    public void setMonth(int m){
        this.month = m;
    }
    public void setYear(int y){
        this.year = y;
    }


}
