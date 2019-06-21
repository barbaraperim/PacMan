import map.*;

public class Score {
  private static final int pastilleValue = 1;
  private static final int specialPastilleValue = 10;
  private static final int ghostValue = 100;
  private static final int scoreToLife = 10000;

  private static int initialLifes = 2;

  private int scoreMax, pastilleScore, ghostScore, paidForLife;
  private static Score s= null;

  //implements the "singleton" pattern;
  private Score () {
//    //TODO: Exceção: caso o mapa ainda não exista
//    this.scoreMax = Map.getPastilleCounter() * pastilleValue;
//    this.scoreMax += Map.getSpecialPastilleCounter() * specialPastilleValue;

    this.pastilleScore = 0;
    this.ghostScore = 0;
    this.paidForLife = 0;
  }
  public Score getInstance () {
    if (s == null) s = new Score ();
    return s;
  }

  //methods to add scores
  public void scorePastille () {
    this.pastilleScore += pastilleValue;
  }
  public void scoreSpecialPastille () {
    this.pastilleScore += specialPastilleValue;
  }
  public void scoreGhost () {
    this.ghostScore += ghostValue;
  }

  //since we store many "types" of scores, we have to have a getScore that returns the "real" score;
//  public static int getScore () {
//    return pastilleScore - paidForLife + ghostScore;
//  }

  //QUANTIDADE MÍNIMA DE VIDAS PRO JOGO CONTINUAR É 1, SE CHEGAR A ZERO ACABOU
//  public static int lifeCount () {
//    return initialLifes + (this.getScore() / scoreToLife);
//  }
//  public void loseLife () {
//    if (this.lifeCount() > 0) {
//      if (initialLifes > 0) initialLifes --;
//      else (this.getScore() / scoreToLife > 0) paidForLife += scoreToLife;
//    }// TODO: exceção não há mais nada a perder
//  }

  //all gameover situations involve the score, so we made it the responsible for that task
  //the game ends when the life count reaches zero or we ate all pastilles (wich we know by comparing the score of eaten pastilles "score" and the total score we can obtain eating, "scoreMax")
//  public boolean endGame () {
//    return scoreMax == pastilleScore || this.lifeCount() == 0;
//  }

}
