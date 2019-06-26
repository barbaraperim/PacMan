package characters.ghost;
import characters.Direction;
import characters.Figures;
import characters.GameContext;

import java.util.Arrays;

public class Random extends Figures implements Ghost {

    @Override
    public void move(GameContext gameContext) throws Exception{
        boolean moved = false;
        while (!moved) {
            int min = 0;
            int max = Direction.values().length;
            Integer randomDirection = min + (int) (Math.random() * ((max - min) + 1));

            Direction direction = Arrays.asList(Direction.values()).get(randomDirection);

            this.walk(direction, gameContext);
        }
    }
}
