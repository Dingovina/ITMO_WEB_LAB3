package app.beans;
import lombok.Data;

import java.io.Serializable;

import app.managers.HitManager;
import jakarta.inject.Named;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;

@Data
@Named("point")
@SessionScoped
@ManagedBean
public class PointBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private double x;
    private double y;
    private double r;
    private boolean hit;
    private boolean drawn;

    public PointBean(double x, double y, double r, boolean hit, boolean drawn){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.drawn = drawn;
    }

    public PointBean(){
        this(0, 0, 1, false, false);
    }

    public void checkHit(){
        this.hit = HitManager.isHit(this);
    }

    public void setX(double x) {
        this.x = x;
        checkHit();
    }

    public void setY(double y) {
        this.y = y;
        checkHit();
    }

    public void setR(double r) {
        this.r = r;
        checkHit();
    }
}
