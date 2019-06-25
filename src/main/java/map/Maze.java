package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Maze {
    private ArrayList<ArrayList<MazeTile>> pointMatrix;
    //TODO: quando criar o mapa, lembra de contar esses dois atributos;
    private static int pastilleCounter, specialPastilleCounter;
    private int lineSize, columnSize;

    private static void MapRandom() {
        //creates random map
    }

    public Maze(int numberOfFile) {
        String filename = "Map0" + numberOfFile + ".txt";
        pointMatrix = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            columnSize = 0;

            while ((line = reader.readLine()) != null) {
                if (line.length() > lineSize) {
                    lineSize = line.length();
                }

                ArrayList<MazeTile> mapLine = new ArrayList<>();

                for (char c : line.toCharArray()) {
                    mapLine.add(discoverTile(c));
                }

                columnSize++;
                pointMatrix.add(mapLine);
            }
            reader.close();
            System.out.println(this.pointMatrix.toString());
        } catch (Exception e) {
            this.MapRandom();
            System.out.println(e.getMessage());
        }
    }

    private MazeTile discoverTile(char c) {
        switch (c) {
            case ('='):
                return MazeTile.WALL;
            case ('.'):
                return MazeTile.PASTILLE;
            case ('0'):
                return MazeTile.SPECIAL_PASTILLE;
            default:
                return MazeTile.EMPTY;
        }
    }

    public int getPastilleCounter() {
        return Maze.pastilleCounter;
    }

    public int getSpecialPastilleCounter() {
        return Maze.specialPastilleCounter;
    }

    public boolean isValidLocation(int line, int column) throws Exception {
        //TODO correct condition
        if (line == 0 && column == 0) {
            throw new Exception(String.format("Invalid Location X: %s Y: %s", column, line));
        }
        return true;
    }

    public int getLineSize() {
        return lineSize;
    }

    public int getColumnSize() {
        return columnSize;
    }
}
