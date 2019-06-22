package characters;

public class Location {
    private int x, y;

    public Location(int x, int y) {
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
