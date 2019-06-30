package characters.ghost;

import characters.Direction;
import characters.Figures;
import characters.GameContext;
import characters.Location;

import java.util.Arrays;
import java.util.List;

public class Stalker extends Figures {

    public Stalker (int x, int y) {
        super(x,y);
        this.setCharRep('S');
    }

    @Override
    public void move(GameContext gameContext){
        Location pacManLocation = gameContext.getPacManLocation();
        double distance, biggestDistance = 0;
        Direction direction = null;
        List<Direction> directions = Arrays.asList(Direction.values());
        Boolean moved = false;

        while (!moved){
            for (Direction d : directions) {
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

                if (distance >= biggestDistance) {
                    biggestDistance = distance;
                    direction = d;
                }
            }
            try{
                this.walk(direction, gameContext);
                moved = true;
            }catch (Exception e) {
                directions.remove(direction);
            }
        }

    }
}
