package characters;

import map.*;

public class Score {
        //valor das coisas
      private final int pastilleValue = 1;
      private final int specialPastilleValue = 10;
      private final int ghostValue = 100;
      private final int scoreToLife = 10000;

      private int lifes = 2;

      private int scoreMax, pastilleScore, ghostScore, paidForLife;

      public Score (GameContext gameContext) {
          Maze maze =gameContext.getMaze();
          this.scoreMax = maze.getPastilleCounter() * pastilleValue;
          this.scoreMax += maze.getSpecialPastilleCounter() * specialPastilleValue;

          this.pastilleScore = 0;
          this.ghostScore = 0;
          this.paidForLife = 0;
      }

        //methods to add scores
      public void scorePastille () {
          this.pastilleScore += pastilleValue;
          this.getALife();
      }
      public void scoreSpecialPastille () {
          this.pastilleScore += specialPastilleValue;
          this.getALife();
      }
      public void scoreGhost () {
          this.ghostScore += ghostValue;
          this.getALife();
      }

      private void getALife() {
          if (getScore() > scoreToLife) {
              paidForLife += scoreToLife;
              lifes++;
          }
      }

      //since we store many "types" of scores, we have to have a getScore that returns the "real" score;
      public int getScore () {
       return pastilleScore - paidForLife + ghostScore;
     }

      public int lifeCount () {
           return lifes;
      }

      public void loseLife () {
           this.lifes--;
      }

      //all gameover situations involve the score, so we made it the responsible for that task
      //the game ends when the life count reaches zero or we ate all pastilles (wich we know by comparing the score of eaten pastilles "score" and the total score we can obtain eating, "scoreMax")
     public boolean hasEnded () {
        return scoreMax == pastilleScore || this.lifeCount() < 0;
     }

}
