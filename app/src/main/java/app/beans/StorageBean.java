package app.beans;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import app.managers.DataBaseManager;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;

@Named("storage")
@ManagedBean
@ApplicationScoped
public class StorageBean implements Serializable {
    @Inject
    private DataBaseManager dataManager;
    private String timeZone;
    private static final long serialVersionUID = 1L;

    public void addPoint(PointBean point) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        point.checkHit();
        point.setTime(ZonedDateTime.now().toString());
        dataManager.addPoint(point);
    }

    public ArrayList<PointBean> getPoints() throws SQLException {
        ArrayList<PointBean> points = dataManager.getPoints();
        if (timeZone == null) {
            timeZone = "UTC";
        }
        for (PointBean point : points) {
            point.updateTimeZone(timeZone);
        }
        return points;
    }

    public void setTimeZone(String timeZone){
        this.timeZone = timeZone;
    }

    public String getTimeZone(){
        return timeZone;
    }   
}
