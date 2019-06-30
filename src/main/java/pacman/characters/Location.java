package characters;

import java.awt.geom.Point2D;

public class Location extends Point2D{
    private double x, y;

    public Location(double x, double y) {
        this.setLocation(x, y);
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return getX() == location.getX() &&
                getY() == location.getY();
    }

    public Location clone(){
        return new Location(this.getX(), this.getY());
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public Location up() {
        return new Location(this.x - 1, this.y);
    }

    public Location left() {
        return new Location(this.x, this.y - 1);
    }

    public Location down() {
        return new Location(this.x + 1, this.y);
    }

    public Location right() {
        return new Location(this.x, this.y + 1);
    }
}
