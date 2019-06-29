//as we should have one pacman at a given moment, we should do it as a singleton
package characters;

public class Pacman extends Figures {
    private int timeWithPowerUp; //the idea is to have it on zero and whe he eats the SpecialPastille we set a number to be the number of walks he can makes until not beeing powered up anymore;
    private Score score;

    public Pacman(int x, int y) {
        super(x, y);
        this.setCharRep('C');
        this.timeWithPowerUp = 0;
    }

    @Override
    public void move(Direction d, GameContext gameContext) {
        this.walk(d, gameContext);
    }

    public void getPowerUp() {
        this.timeWithPowerUp = 20;
    }

    public boolean isPoweredUp() {
        return this.timeWithPowerUp > 0;
    }

    public void passTimePowerUp() {
        this.timeWithPowerUp--;
    }

    public void eat (GameContext gameContext) {
        Maze m = gameContext.getMaze();
        Score s = gameContext.getScore();
        MazeTile t = m.getMazeTile(this.location);
        switch (t) {
            case SPECIAL_PASTILLE:
                s.scoreSpecialPastille();
                maze.eatPastille (this.location);
                this.getPoweredUp();
                break;
            case PASTILLE:
                s.scoreSpecialPastille();
                maze.eatPastille (this.location);
                break;
        }
    }

    @Override
    public void die (GameContext gameContext) {
        Score s = gameContext.getScore ();
        if (s.lifeCount > 1) s.loseLife();
        else this.setAlive(false);
    }
}
