package characters;

import map.*;

public abstract class Character {
  private Point position;
  private boolean isAlive;

  public Character (int x, int y) {
    this.position = new Point (x, y);
    this.isAlive = true;
  }

  //acho que dá pra fazer um enum com direções mas eu to com muita preguiça sorry
  public abstract void walk (int d) {
    if (d == 0) this.position = new Point (this.position.getX() - 1, this.position.getY());
    if (d == 1) this.position = new Point (this.position.getX(), this.position.getY() - 1);
    if (d == 2) this.position = new Point (this.position.getX() + 1, this.position.getY());
    if (d == 3) this.position = new Point (this.position.getX(), this.position.getY() + 1);
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
