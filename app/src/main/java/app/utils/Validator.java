package app.utils;

import java.util.ArrayList;

import app.models.Point;

public class Validator {
    private ArrayList<Float> x_values = new ArrayList<Float>(java.util.Arrays.asList(-2f, -1.5f, -1f, -0.5f, 0f, 0.5f, 1f, 1.5f, 2f));
    private float min_y = -3f;
    private float max_y = 5f;
    private float min_r = 1f;
    private float max_r = 4f;
    public Point validate(String x, String y, String r, String drawn) {
        Point point = new Point();
        try{
            point.setX(Float.parseFloat(x));
            point.setY(Float.parseFloat(y));
            point.setR(Float.parseFloat(r));
        } catch (Exception e) {
            point.setValid(false);
            return point;
        }
        point.setValid(validate_data(
            point.getX(),
            point.getY(),
            point.getR()
        ));
        try{
           point.setDrawn(Boolean.parseBoolean(drawn));
        } catch (Exception e) {
            point.setDrawn(false);
        }
        point.setValid(point.isValid() || (point.isDrawn() && validate_r(point.getR())));

        return point;
    }

    private boolean validate_data(float x, float y, float r) {
        return validate_x(x) && validate_y(y) && validate_r(r);
    }

    private boolean validate_x(float x) {
        return x_values.contains(x);
    }

    private boolean validate_y(float y) {
        return min_y <= y && y <= max_y;
    }

    private boolean validate_r(float r) {
        return min_r <= r && r <= max_r;
    }
}
