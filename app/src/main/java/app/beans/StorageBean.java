package app.beans;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import app.managers.DataBaseManager;
import jakarta.inject.Named;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;

@Named("storage")
@ManagedBean
@ApplicationScoped
public class StorageBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<PointBean> points = new ArrayList<>();

    public StorageBean() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        update();
    }

    public void addPoint(PointBean point) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        DataBaseManager dbManager = new DataBaseManager();
        dbManager.addPoint(point);
        update();
    }

    public void update() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        DataBaseManager dbManager = new DataBaseManager();
        points = dbManager.getPoints();
    }

    public ArrayList<PointBean> getPoints() {
        return points;
    }
}
