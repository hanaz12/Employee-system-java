package main.config;

public class Schema {
    private int locationX,locationY,sizeX,sizeY;
    private boolean isVisible;
    public Schema() {
        // Default values
        this.locationX = 300;
        this.locationY = 150;
        this.sizeX=1180;
        this.sizeY=650;
        this.isVisible = true;
    }
    public int getLocationY() {
        return locationY;
    }
    public int getLocationX() {
        return locationX;
    }
    public boolean isVisible() {
        return isVisible;
    }
    public int sizeX() {
        return sizeX;
    }
    public int sizeY() {
        return sizeY;
    }
}