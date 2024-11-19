package app.servlets;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import app.utils.Config;
import java.io.IOException;
public class ControllerServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
    HttpServletResponse res) throws ServletException,IOException {
        if (req.getParameter("x") != null &&
        req.getParameter("y") != null &&
        req.getParameter("r") != null) {
            RequestDispatcher areaDispatcher = req.getRequestDispatcher(Config.AREA_URL);
            req.setAttribute("dispatched", true);
            areaDispatcher.forward(req, res);
        } else {
            RequestDispatcher indexDispatcher = req.getRequestDispatcher(Config.INDEX_URL);
            indexDispatcher.forward(req, res);
        }
    }
}