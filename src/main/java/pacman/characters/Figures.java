package characters;

import map.Maze;

public abstract class Figures {
    protected Location location;
    protected boolean alive;
    protected char charRep;

    public Figures(int x, int y) {
        this.location = new Location(x, y);
        this.alive = true;
    }

    protected void walk(Direction direction, GameContext gameContext) throws Exception {
        Location newLocation = this.location.clone();
        Maze m = gameContext.getMaze();
        Boolean stuck = false;
        switch (direction) {
            case UP:
                if (m.isValidLocation(newLocation.up())) {
                    this.location = this.location.up();
                } else {
                    stuck = true;
                }
                break;
            case LEFT:
                if (m.isValidLocation(newLocation.left())) {
                    this.location = this.location.left();
                } else {
                    stuck = true;
                }
                break;
            case DOWN:
                if (m.isValidLocation(newLocation.down())) {
                    this.location = this.location.down();
                } else {
                    stuck = true;
                }
                break;
            case RIGHT:
                if (m.isValidLocation(newLocation.right())) {
                    this.location = this.location.right();
                } else {
                    stuck = true;
                }
                break;
        }

        if (stuck) {
            throw new Exception("Invalid Location");
        }
    }

    public abstract void move(GameContext gameContext);

    //TODO adicionar exceçoes
    public void die() {
        setAlive(false);
    }

    protected void setAlive(boolean alive) {
        this.alive = alive;
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


    public char getCharRep() {
        return charRep;
    }

    public void setCharRep(char charRep) {
        this.charRep = charRep;
    }

}
