/**
 * Created by nishitarao on 6/18/15.
 */


public class GraphCreation {

    public static void main(){

        HelperNeo4j.AddNode("Alex", PEOPLE);
        HelperNeo4j.AddNode("Barney", PEOPLE);
        HelperNeo4j.AddNode("Carrie", PEOPLE);
        HelperNeo4j.AddNode("Don", PEOPLE);
        HelperNeo4j.AddNode("Eric", PEOPLE);
        HelperNeo4j.AddNode("Farah", PEOPLE);
        HelperNeo4j.AddNode("Gary", PEOPLE);

        HelperNeo4j.AddNode("Amici", RESTAURANTS);
        HelperNeo4j.AddNode("BerrydAlive", RESTAURANTS);
        HelperNeo4j.AddNode("Casablanca", RESTAURANTS);
        HelperNeo4j.AddNode("Dominos", RESTAURANTS);
        HelperNeo4j.AddNode("EmilyDiner", RESTAURANTS);
        HelperNeo4j.AddNode("FillingStation", RESTAURANTS);

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


        FollowedBy("Alex", "Carrie");
        FollowedBy("Eric", "Gary");

    }

}
