package app.models;

public class Point {
    private float x;
    private float y;
    private float r;
    private boolean hit;
    private boolean drawn;
    private boolean valid;
    private long curTime;
    private long scriptTime;

    public Point(float x, float y, float r, boolean hit, boolean drawn, long curTime, long scriptTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.drawn = drawn;
        this.curTime = curTime;
        this.scriptTime = scriptTime;
        this.valid = true;
    }
    public Point(){
        this(0, 0, 0, false, false, 0, 0);
        this.valid = false;
    }

    
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setCurTime(long curTime) {
        this.curTime = curTime;
    }

    public void setScriptTime(long scriptTime) {
        this.scriptTime = scriptTime;
    }
    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isDrawn(){
        return drawn;
    }

    public boolean isValid() {
        return valid;
    }

    public long getCurTime() {
        return curTime;
    }

    public long getScriptTime() {
        return scriptTime;
    }
}
