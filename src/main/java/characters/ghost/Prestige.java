package characters.ghost;

import characters.Figures;
import characters.GameContext;

public class Prestige extends Figures implements Ghost {
    @Override
    public void move(GameContext gameContext) {
        boolean moved = false;
        while(!moved){
            Integer min = 0;
            Integer max = gameContext.getColumnSize();
            Integer column = min + (int)(Math.random() * ((max - min) + 1));

            max = gameContext.getLineSize();
            Integer line = min + (int)(Math.random() * ((max - min) + 1));

            if (gameContext.isValidLocation(line, column)){
                this.location.setY(line);
                this.location.setX(column);
                moved = true;
            }
        }
    }
}
