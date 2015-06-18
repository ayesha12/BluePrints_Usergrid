import java.util.HashMap;

/**
 * Created by ayeshadastagiri on 6/18/15.
 */
public class GlobalVars {

    public enum nodeType{
        PEOPLE,
        RESTAURANT
    }

    static HashMap<String,HashMap> People = new HashMap<String,HashMap>();
    static HashMap<String,HashMap> Restaurants = new HashMap<String,HashMap>();

}
