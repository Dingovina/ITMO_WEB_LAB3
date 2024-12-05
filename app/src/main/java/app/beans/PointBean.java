package app.beans;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import app.managers.HitManager;
import jakarta.inject.Named;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;

@Data
@Named("point")
@RequestScoped
@ManagedBean
public class PointBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private double x;
    private double y;
    private double r;
    private String time;
    private boolean hit;
    private boolean drawn;
    public PointBean(double x, double y, double r, boolean hit, boolean drawn, ZonedDateTime time){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.drawn = drawn;
        this.time = time.toString();
    }

    public PointBean(){
        this(0, 0, 1, false, false, ZonedDateTime.now());
    }

    public void checkHit(){
        hit = HitManager.isHit(this);
    }

    public void updateTimeZone(String timeZone){
        time = ZonedDateTime.parse(time)
        .withZoneSameInstant(java.time.ZoneId.of(timeZone))
        .format( DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
