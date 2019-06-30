package characters.ghost;
import characters.Direction;
import characters.Figures;
import characters.GameContext;
import map.Maze;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Random extends Figures {

    public Random (int x, int y) {
        super(x,y);
        this.setCharRep('R');

    }

    @Override
    public void move(GameContext gameContext){
        boolean moved = false;
        int min = 0;
        int max = Direction.values().length-1;

        while (!moved) {
            Integer randomDirection = min + (int) (Math.random() * ((max - min) + 1));
            List<Direction> directions =  new LinkedList<Direction>(Arrays.asList(Direction.values()));

            Direction direction = directions.get(randomDirection);

            try {
                this.walk(direction, gameContext);
                moved = true;
            } catch (Exception e) {
                directions.remove(direction);
                max--;
            }
        }
    }
}
