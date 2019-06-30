package characters.ghost;

import characters.Direction;
import characters.Figures;
import characters.GameContext;
import characters.Location;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Stalker extends Figures {

    public Stalker (int x, int y) {
        super(x,y);
        this.setCharRep('S');
    }

    @Override
    public void move(GameContext gameContext){
        Location pacManLocation = gameContext.getPacManLocation();
        double distance, smallerDistance = 10000;
        Direction direction = null;
        List<Direction> directions =  new LinkedList<Direction>(Arrays.asList(Direction.values()));
        Boolean moved = false;

        while (!moved) {
            for (Direction d : directions) {
                Location newLocation = this.location.clone();
                distance = 0;
                switch (d) {
                    case RIGHT:
                        newLocation = newLocation.right();
                        break;
                    case DOWN:
                        newLocation = newLocation.down();
                        break;
                    case LEFT:
                        newLocation = newLocation.left();
                        break;
                    case UP:
                        newLocation = newLocation.up();
                        break;
                }

                distance += newLocation.distance(pacManLocation);

                if (distance < smallerDistance) {
                    smallerDistance = distance;
                    direction = d;
                }
            }
            try {
                this.walk(direction, gameContext);
                moved = true;
            } catch (Exception e) {
                directions.remove(direction);
            }
        }
    }
}
