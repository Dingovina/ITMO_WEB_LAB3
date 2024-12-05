package app.beans;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
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
    
    private static final long serialVersionUID = 1L;

    public void addPoint(PointBean point) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        point.checkHit();
        dataManager.addPoint(point);
    }

    public ArrayList<PointBean> getPoints() throws SQLException {
        return dataManager.getPoints();
    }
}
