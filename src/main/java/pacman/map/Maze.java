package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Maze {
    private ArrayList<ArrayList<MazeTile>> matrix;
    //TODO: quando criar o mapa, lembra de contar esses dois atributos;
    private int pastilleCounter, specialPastilleCounter = 0;
    private int lineSize, columnSize;

    private static void MapRandom() {
        //creates random map
    }

    public Maze(int numberOfFile) {
        String filename = "./src/main/java/resources/Map0" + numberOfFile + ".txt";
        matrix = new ArrayList<>();
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
                matrix.add(mapLine);
            }
            reader.close();
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
                this.pastilleCounter++;
                return MazeTile.PASTILLE;
            case ('o'):
                this.specialPastilleCounter++;
                return MazeTile.SPECIAL_PASTILLE;
            default:
                return MazeTile.EMPTY;
        }
    }

    public int getPastilleCounter() {
        return pastilleCounter;
    }

    public int getSpecialPastilleCounter() {
        return specialPastilleCounter;
    }

    public boolean isValidLocation(double line, double column) throws Exception {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                stringBuilder.append((matrix.get(i).get(j).charRep + " "));
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
