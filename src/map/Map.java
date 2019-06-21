package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {
    private ArrayList<ArrayList<MapPoint>> pointMatrix;
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

                ArrayList<MapPoint> mapLine = new ArrayList<>();
                Integer columnNum = 0;
                for (char c : line.toCharArray()) {
                    MapPoint mapPoint = new MapPoint(lineNum, columnNum, c);
                    mapLine.add(mapPoint);
                    columnNum++;
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

    public int getPastilleCounter() {
        return Map.pastilleCounter;
    }

    public int getSpecialPastilleCounter() {
        return Map.specialPastilleCounter;
    }
}
