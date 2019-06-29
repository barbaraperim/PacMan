package characters.ghost;

import characters.Direction;
import characters.Figures;
import characters.GameContext;
import characters.Location;

import java.util.Arrays;

public class Stalker extends Figures {
    @Override
    public void move(GameContext gameContext){
        Location pacManLocation = gameContext.getPacManLocation();
        double distance, biggestDistance = 0;
        Direction direction = null;

        for (Direction d : Arrays.asList(Direction.values())) {
            Location newLocation = this.location.clone();
            distance = 0;
            switch (d){
                case RIGHT:
                    newLocation.right();
                    break;
                case DOWN:
                    newLocation.down();
                    break;
                case LEFT:
                    newLocation.left();
                    break;
                case UP:
                    newLocation.up();
                    break;
            }


            distance += newLocation.distance(pacManLocation);


            if (distance > biggestDistance) {
                biggestDistance = distance;
                direction = d;
            }
        }

        this.walk(direction, gameContext);
    }
}
