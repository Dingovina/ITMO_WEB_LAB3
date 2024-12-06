package app;

import java.time.format.DateTimeFormatter;

import app.Controller.RequestPoint;
import app.Controller.ResponsePoint;
import app.dto.PointDTO;

public class PointMapper {
    public static PointDTO requestToDTO(RequestPoint point){
        PointDTO pointDTO = new PointDTO();
        pointDTO.setX(point.getX());
        pointDTO.setY(point.getY());
        pointDTO.setR(point.getR());
        pointDTO.setDrawn(point.isDrawn());
        return pointDTO;
    }
    
    public static ResponsePoint dtoToResponse(PointDTO point){
        ResponsePoint responsePoint = new ResponsePoint();
        responsePoint.setX(point.getX());
        responsePoint.setY(point.getY());
        responsePoint.setR(point.getR());
        responsePoint.setHit(point.isHit());
        responsePoint.setTime(DateTimeFormatter.ofPattern("HH:mm:ss").format(point.getTime()));
        return responsePoint;
    }
}
