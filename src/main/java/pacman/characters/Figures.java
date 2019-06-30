package characters;

import map.Maze;

public abstract class Figures {
    //não deveria ser private tudo?
    public Location location;
    protected boolean alive;
    public char charRep;

    //pode remover esse método então?
    public Figures() {
    }

    public Figures(int x, int y) {
        this.location = new Location(x, y);
        this.alive = true;
    }

    protected void walk(Direction direction, GameContext gameContext){
        Location newLocation = this.location.clone();
        Maze m = gameContext.getMaze();
        switch (direction) {
            case UP:
                if (m.isValidLocation(newLocation.up())) {
                    this.location = this.location.up();
                }
                break;
            case LEFT:
                newLocation.left();
                if (m.isValidLocation(newLocation.left())) {
                    this.location = this.location.left();
                }
                break;
            case DOWN:
                newLocation.down();
                if (m.isValidLocation(newLocation.down())) {
                    this.location = this.location.down();
                }
                break;
            case RIGHT:
                newLocation.right();
                if (m.isValidLocation(newLocation.right())) {
                    this.location = this.location.right();
                }
                break;
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
