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
    public void move(GameContext gameContext) {

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


}
