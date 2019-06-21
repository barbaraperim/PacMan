package characters;

import map.Maze;

public abstract class Figures {
    public Location location;
    private boolean alive;
    public char charRep;

    public Figures() {}

    public Figures(int x, int y) {
        this.location = new Location(x, y);
        this.alive = true;
    }

    public void walk(int d) {
        if (d == 0) {
            this.location = this.location.up();
        }
        if (d == 1) {
            this.location = this.location.left();
        }
        if (d == 2) {
            this.location = this.location.down();
        }
        if (d == 3) {
            this.location = this.location.down();
        }
    }

    public abstract void move(Maze maze);

    //TODO adicionar exceçoes
    public void die() {
        setAlive(false);
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public char getCharRep() {
        return charRep;
    }

    public void setCharRep(char charRep) {
        this.charRep = charRep;
    }
}
