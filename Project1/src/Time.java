public class Time {
    private int second = 0 ;
    private int minute = 0 ;
    private int hour = 0 ;

    public Time(){}

    public Time(int second , int minute , int hour){
        // this.second = second ;
        // this.minute = minute ;
        // this.hour = hour ;
        setTime(second, minute, hour);
    }
    public int getSecond(){
        return this.second;
    }

    public int getMinute(){
        return this.minute;
    }

    public int getHour(){
        return this.hour;
    }

    public void setSecond(int second){
        if(second<0 || second>=60){
            throw new IllegalArgumentException("Second must be between 0 and 59.");
        }
        this.second = second;
    }

    public void setMinute(int minute){
        if(minute<0 || minute>=60){
            throw new IllegalArgumentException("Minute must be between 0 and 59.");
        }
        this.minute = minute;
    }

    public void setHour(int hour){
        if(hour<0 || hour>=24){
            throw new IllegalArgumentException("Hour must be between 0 and 23.");
        }
        this.hour = hour ;        
    }

    public void setTime(int second , int minute , int hour){
        // this.second = second ;
        // this.minute = minute ;
        // this.hour = hour ;
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    @Override
    public String toString(){
        return String.format("%02d.%02d.%02d", hour,minute,second);
    }
    /*
     * Advance the time by one second
     * Return the current Object to allow for method chainning
     * 
     */
    public Time nextSecond(){
        this.second++;
        if(this.second == 6){
            this.second = 0;
            this.minute++;
            if(this.minute == 60){
                this.minute = 0;
                this.hour++;
                if(this.hour == 24){
                    this.hour = 0;
                }
            }
        }
        return this;
    }
}