package characters.ghost;

import characters.Direction;
import characters.Figures;
import characters.GameContext;
import characters.Location;

import java.util.ArrayList;
import java.util.Arrays;

public class Evasive extends Figures {

    public Evasive (int x, int y) {
        super(x,y);
    }

    @Override
    public void move(GameContext gameContext){
        ArrayList<Location> ghostLocation = gameContext.getGhostLocations();
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

            for (Location l : ghostLocation) {
                distance += newLocation.distance(l);
            }

            if (distance >= biggestDistance) {
                biggestDistance = distance;
                direction = d;
            }
        }

        this.walk(direction, gameContext);
    }
}
