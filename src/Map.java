import java.io.File;
import java.util.HashMap;

public class Map {
    enum MapTiles{
        PASTILLE,
        SPECIALPASTILLE,
        WALL,
        EMPTY
    }

    private HashMap<MapTiles, MapTiles> map;

    private Map(){
        //creates random map
    }

    private Map (File f){
        //creates Map from text file
    }


}
