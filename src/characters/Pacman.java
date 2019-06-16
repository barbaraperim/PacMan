//as we should have one pacman at a given moment, we should do it as a singleton

public class Pacman extends Characters {
  private boolean timeWithPowerUp; //the idea is to have it on zero and whe he eats the SpecialPastille we set a number to be the number of walks he can makes until not beeing powered up anymore;
  private static Pacman pacman = null;

  private Pacman (int x, int y) {
    super (x, y);
    this.timeWithPowerUp = 0;
  }
  public static Pacman getInstance () {
    if (pacman == null) pacman = new Pacman();
    return pacman;
  }

  @Override
  public void walk (int d) {
    Map map = Map.getInstance ();
    //a exceção de up, down, left ou right estar fora do mapa creio que não deva acontecer pois os limites do mapa são paredes.
    if (d == 0 && !map.isWall(this.position.up()   )) super(d); //up
    if (d == 0 && !map.isWall(this.position.left() )) super(d); //left
    if (d == 0 && !map.isWall(this.position.down() )) super(d); //down
    if (d == 0 && !map.isWall(this.position.right())) super(d); //right
  }

  public void getPowerUp () {
    this.timeWithPowerUp = 20;
  }
  public boolean isPoweredUp () {
    return this.timeWithPowerUp > 0;
  }
  public void passTimePowerUp () {
    this.timeWithPowerUp--;
  }
  public char getRepresentation () {
    return "C";
  }
}
