package characters.ghost;

import characters.Figures;
import characters.GameContext;
import characters.Location;
import map.Maze;

public class Prestige extends Figures {

    public Prestige (int x, int y) {
        super(x,y);
        this.setCharRep('P');

    }

    @Override
    public void move(GameContext gameContext) {
        boolean moved = false;
        while(!moved){
            Integer min = 0;
            Maze m = gameContext.getMaze();

            Integer max = m.getColumnSize();
            Integer column = min + (int)(Math.random() * ((max - min) + 1));

            max = m.getLineSize();
            Integer line = min + (int)(Math.random() * ((max - min) + 1));

            try {
                m.isValidLocation(new Location(line, column));
                this.location = new Location (line, column);
                moved = true;
            } catch (Exception e) {

            }
        }
    }
}
