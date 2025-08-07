import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeModern {
    //use LocalTime to manage Time
    private LocalTime time ;

    public TimeModern(){
        this.time = LocalTime.of(0, 0, 0);
    }

    public TimeModern(int hour , int minute , int second){
        this.time = LocalTime.of(hour, minute, second);
    }

    public int getHour(){
        return time.getHour();
    }
    public int getMinute(){
        return time.getMinute();
    }
    public int getSecond(){
        return time.getSecond();
    }

    public TimeModern withTime(int hour , int minute , int second){
        return new TimeModern(hour,minute,second);
    }

    public TimeModern nextSecond(){
        //Call plusSecond(1) เพียงครั้งเดียว
        LocalTime newTime = this.time.plusSeconds(1);
        return new TimeModern(
            newTime.getHour(),
            newTime.getMinute(),
            newTime.getSecond()
        );
    }

    @Override
    public String toString(){
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }   
}