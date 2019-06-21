package characters;

import map.*;

public abstract class Character {
  public Point position;
  private boolean isAlive;

  public Character (int x, int y) {
    this.position = new Point (x, y);
    this.isAlive = true;
  }

  public void walk (int d) {
    if (d == 0) this.position = this.position.up();
    if (d == 1) this.position = this.position.left();
    if (d == 2) this.position = this.position.down();
    if (d == 3) this.position = this.position.down();
  }

  //temos que sair adicionando exceções em todo canto desse projeto, crtz que ele vai reclamar
  public void die () {
    this.isAlive = false;
  }

  public Point getPosition () {
    return this.position;
  }

  public abstract char getRepresentation ();
}
