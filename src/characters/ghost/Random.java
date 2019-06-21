package characters.ghost;

import characters.Figures;
import characters.GameContext;

public class Random extends Figures implements Ghost {

    @Override
    public void move(GameContext gameContext) {
        boolean moved = false;
        while(!moved){
            int min = 1;
            int max = 4;
            Integer randomDirection = min + (int)(Math.random() * ((max - min) + 1));

//            if (gameContext.isValidLocation(line, column)){
//                this.location.setY(line);
//                this.location.setX(column);
//                moved = true;
//            }
        }
    }
}
