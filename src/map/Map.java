package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {
    private ArrayList<ArrayList<MapTile>> pointMatrix;
    //TODO: quando criar o mapa, lembra de contar esses dois atributos;
    private static int pastilleCounter, specialPastilleCounter;

    private static void MapRandom() {
        //creates random map
    }

    public Map(int numberOfFile) {
        String filename = "Map0" + numberOfFile + ".txt";
        pointMatrix = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            Integer lineNum = 0;
            while ((line = reader.readLine()) != null) {

                ArrayList<MapTile> mapLine = new ArrayList<>();
                Integer columnNum = 0;
                for (char c : line.toCharArray()) {
                    mapLine.add(discoverTile(c));
                }
                pointMatrix.add(mapLine);
                lineNum++;
            }
            reader.close();
            System.out.println(this.pointMatrix.toString());
        } catch (Exception e) {
            this.MapRandom();
            System.out.println(e.getMessage());
        }
    }

    private MapTile discoverTile(char c) {
        switch (c) {
            case ('='):
                return MapTile.WALL;
            case ('.'):
                return MapTile.PASTILLE;
            case ('0'):
                return MapTile.SPECIAL_PASTILLE;
            default:
                return MapTile.EMPTY;
        }
    }

    public int getPastilleCounter() {
        return Map.pastilleCounter;
    }

    public int getSpecialPastilleCounter() {
        return Map.specialPastilleCounter;
    }
}
