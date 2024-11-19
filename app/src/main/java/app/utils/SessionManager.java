package app.utils;

import java.util.ArrayList;

import app.models.Point;
import jakarta.servlet.http.HttpSession;

public class SessionManager {
    private HttpSession session;
    public SessionManager(HttpSession session){
        this.session = session;
    }
    @SuppressWarnings("unchecked")
    public ArrayList<Point> getPointList() {
        ArrayList<Point> pointList = (ArrayList<Point>) session.getAttribute(Config.POINTS_ATTRIBUTE);
        if (pointList == null) {
            pointList = new ArrayList<Point>();
        }

        return pointList;
    };

    public void addPoint(Point point) {
        ArrayList<Point> pointList = getPointList();
        pointList.add(point);
        session.setAttribute(Config.POINTS_ATTRIBUTE, pointList);
        this.modify();
    }

    public void modify(){
        session.setAttribute(Config.LAST_MODIFIED_ATTRIBUTE, System.currentTimeMillis());
    }
}

