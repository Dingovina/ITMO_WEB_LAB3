package app.utils;

import app.models.Point;

public class Checker {
    public boolean check(Point p){
        return check(p.getX(), p.getY(), p.getR());
    }
    public boolean check(float x, float y, float r) {
        if (x >= 0 && y >= 0) {
            return check_right_top(x, y, r);
        }
        else if (x <= 0 && y <= 0) {
            return check_left_bottom(x, y, r);
        }
        else if (x >= 0 && y <= 0) {
            return check_right_bottom(x, y, r);
        }
        else if (x <= 0 && y >= 0) {
            return check_left_top(x, y, r);
        }
        return false;
    }

    private boolean check_left_top(float x, float y, float r) {
        return false;
    }

    private boolean check_right_top(float x, float y, float r) {
        return y <= -x + r / 2;
    }

    private boolean check_left_bottom(float x, float y, float r) {
        return x * x + y * y <= r * r;
    }

    private boolean check_right_bottom(float x, float y, float r) {
        return x <= r / 2 && y >= -r;
    }
}
