package app.servlets;

import java.io.PrintWriter;
import java.util.ArrayList;

import app.models.Point;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import app.utils.Config;
@SuppressWarnings("unchecked")
public class HistoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        HttpSession session = request.getSession();
        ArrayList<Point> point_list = (ArrayList<Point>) session.getAttribute(Config.POINTS_ATTRIBUTE);
        response.setContentType(Config.JSON_CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        if (point_list == null) {
            point_list = new ArrayList<Point>();
        }

        out.println("[");
        for (int i = 0; i < point_list.size(); ++i) {
            Point point = point_list.get(i);
            out.println(printPoint(point));
            if (i < point_list.size() - 1) {
                out.println(",");
            }
        }
        out.println("]");
    }

    private String printPoint(Point point) {
        return"{" +
                "\"x\":" + point.getX() + "," +
                "\"y\":" + point.getY() + "," +
                "\"r\":" + point.getR() + "," +
                "\"hit\":" + point.isHit() + "," +
                "\"curTime\":" + point.getCurTime() + "," +
                "\"scriptTime\":" + point.getScriptTime() +
                "}";
    }
}
