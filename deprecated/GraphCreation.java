/**
 * Created by nishitarao on 6/18/15.
 */


public class GraphCreation {

    public static void main(){

        HelperNeo4j.AddNode("Alex", GlobalVars.nodeType.PEOPLE);
        HelperNeo4j.AddNode("Barney", GlobalVars.nodeType.PEOPLE);
        HelperNeo4j.AddNode("Carrie", GlobalVars.nodeType.PEOPLE);
        HelperNeo4j.AddNode("Don", GlobalVars.nodeType.PEOPLE);
        HelperNeo4j.AddNode("Eric", GlobalVars.nodeType.PEOPLE);
        HelperNeo4j.AddNode("Farah", GlobalVars.nodeType.PEOPLE);
        HelperNeo4j.AddNode("Gary", GlobalVars.nodeType.PEOPLE);

        HelperNeo4j.AddNode("Amici", GlobalVars.nodeType.RESTAURANT);
        HelperNeo4j.AddNode("BerrydAlive", GlobalVars.nodeType.RESTAURANT);
        HelperNeo4j.AddNode("Casablanca", GlobalVars.nodeType.RESTAURANT);
        HelperNeo4j.AddNode("Dominos", GlobalVars.nodeType.RESTAURANT);
        HelperNeo4j.AddNode("EmilyDiner", GlobalVars.nodeType.RESTAURANT);
        HelperNeo4j.AddNode("FillingStation", GlobalVars.nodeType.RESTAURANT);

        HelperNeo4j.Visits("Alex", "Amici");
        HelperNeo4j.Visits("Alex", "Casablanca");
        HelperNeo4j.Visits("Carrie", "Casablanca");
        HelperNeo4j.Visits("Don", "Amici");
        HelperNeo4j.Visits("Don", "Casablanca");
        HelperNeo4j.Visits("Don", "Dominos");
        HelperNeo4j.Visits("Eric", "FillingStation");
        HelperNeo4j.Visits("Farah", "FillingStation");

        HelperNeo4j.Follows("Barney", "Alex");
        HelperNeo4j.Follows("Eric", "Don");
        HelperNeo4j.Follows("Alex", "Farah");

        HelperNeo4j.FollowedBy("Alex", "Carrie");
        HelperNeo4j.FollowedBy("Eric", "Gary");

    }

}
