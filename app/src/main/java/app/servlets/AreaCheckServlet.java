package app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import app.models.Point;
import app.utils.Checker;
import app.utils.Validator;
import app.utils.Config;
import app.utils.ResponseManager;
import app.utils.SessionManager;

public class AreaCheckServlet extends HttpServlet {
    private Validator validator = new Validator();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        long startTime = System.nanoTime();
        if (request.getAttribute("dispatched") == null) {
            response.sendRedirect(Config.ROOT_URL);
            return;
        }

        
        Point point = validator.validate(request.getParameter("x"), request.getParameter("y"), request.getParameter("r"), request.getParameter("drawn"));
        if (point.isValid()) {
            Checker checker = new Checker();
            point.setHit(checker.check(point.getX(), point.getY(), point.getR()));
            point.setCurTime(System.currentTimeMillis());
            point.setScriptTime(System.nanoTime() - startTime);

            SessionManager sessionManager = new SessionManager(request.getSession());
            sessionManager.addPoint(point);

            ResponseManager responseManager = new ResponseManager(response, 200);
            responseManager.setContentTypeJSON();
            responseManager.setBody(point);
            responseManager.send();
        }
        else{
            ResponseManager responseManager = new ResponseManager(response, 400);
            responseManager.setContentTypeJSON();
            responseManager.setBody("Wrong parameters");
            responseManager.send();   
        }
    }
}
