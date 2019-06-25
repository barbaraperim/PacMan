package characters;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Figures {
    public Location location;
    private boolean alive;
    public char charRep;

    public Figures() {
    }

    public Figures(int x, int y) {
        this.location = new Location(x, y);
        this.alive = true;
    }

    protected void walk(Direction direction, GameContext gameContext) throws Exception{
        Location newLocation = this.location.clone();
        switch (direction) {
            case UP:
                newLocation.up();
                if (gameContext.isValidLocation(newLocation.getX(), newLocation.getY())) {
                    this.location = this.location.up();
                }
                break;
            case LEFT:
                newLocation.left();
                if (gameContext.isValidLocation(newLocation.getX(), newLocation.getY())) {
                    this.location = this.location.left();
                }
                break;
            case DOWN:
                newLocation.down();
                if (gameContext.isValidLocation(newLocation.getX(), newLocation.getY())) {
                    this.location = this.location.down();
                }
                break;
            case RIGHT:
                newLocation.right();
                if (gameContext.isValidLocation(newLocation.getX(), newLocation.getY())) {
                    this.location = this.location.right();
                }
                break;
        }
    }

    public abstract void move(GameContext gameContext) throws Exception;

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
