package app.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import app.models.Point;
import jakarta.servlet.http.HttpServletResponse;

public class ResponseManager {
    private HttpServletResponse response;
    private String body = "";
    public ResponseManager(HttpServletResponse response, int statusCode){
        this.response = response;
        this.response.setStatus(statusCode);
    }
    public void setBody(Point point){
        body = "{" +
                "\"x\":" + point.getX() + "," +
                "\"y\":" + point.getY() + "," +
                "\"r\":" + point.getR() + "," +
                "\"hit\":" + point.isHit() + "," +
                "\"curTime\":" + point.getCurTime() + "," +
                "\"scriptTime\":" + point.getScriptTime() +
                "}";
    }

    public void setBody(String message){
        body = message;
    }
    public void addHeader(String header, Object value){
        response.addHeader(header, String.valueOf(value));
    }
    
    public void setContentTypeJSON() {
        response.setContentType(Config.JSON_CONTENT_TYPE);
    }

    public void send() throws IOException{
        response.addHeader("Content-Length", String.valueOf(this.body.getBytes(StandardCharsets.UTF_8).length));
        response.getWriter().println(body);
    }
}
