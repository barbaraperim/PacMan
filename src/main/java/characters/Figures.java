package characters;

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

    protected void walk(Direction d) {
        if (d == Direction.UP) {
            this.location = this.location.up();
        }
        if (d == Direction.LEFT) {
            this.location = this.location.left();
        }
        if (d == Direction.DOWN) {
            this.location = this.location.down();
        }
        if (d == Direction.RIGHT) {
            this.location = this.location.right();
        }
    }

    public abstract void move(GameContext gameContext);

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
