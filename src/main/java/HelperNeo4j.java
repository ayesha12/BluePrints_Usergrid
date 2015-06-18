import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.GraphFactory;
import com.tinkerpop.blueprints.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by ayeshadastagiri on 6/18/15.
 */
public class HelperNeo4j {



    static Graph graph = GraphFactory.open("src/main/resources/graph.properties");

    public static void AddNode(String name, Enum nType) {

        Vertex node = graph.addVertex(null);

        if (nType == GlobalVars.nodeType.PEOPLE) {

            HashMap<String, List<Vertex>> persondetails = new HashMap<String, List<Vertex>>();

            List<Vertex> VisitNodes = new ArrayList<Vertex>();
            List<Vertex> FollowNodes = new ArrayList<Vertex>();
            List<Vertex> FollowedByNodes = new ArrayList<Vertex>();
            List<Vertex> infoNode = new ArrayList<Vertex>();

            node.setProperty("Name", name);
            node.setProperty("Type", GlobalVars.nodeType.PEOPLE);
            infoNode.add(node);

            persondetails.put("Node", infoNode);
            persondetails.put("Visits", VisitNodes);
            persondetails.put("Follows", FollowNodes);
            persondetails.put("FollowedBy", FollowedByNodes);

            GlobalVars.People.put(name, persondetails);

        } else if (nType == GlobalVars.nodeType.RESTAURANT) {
            HashMap<String, List<Vertex>> restaurantdetails = new HashMap<String, List<Vertex>>();

            List<Vertex> infoNode = new ArrayList<Vertex>();
            List<Vertex> VisitedByNodes = new ArrayList<Vertex>();

            node.setProperty("Name", name);
            node.setProperty("Type", GlobalVars.nodeType.RESTAURANT);
            infoNode.add(node);

            restaurantdetails.put("Node", infoNode);
            restaurantdetails.put("VisitedBy", VisitedByNodes);

            GlobalVars.Restaurants.put(name, restaurantdetails);


        }
    }


        public static void Visits(String person, String restaurant){

            Vertex pNode = GlobalVars.People.get(person).get("Node").get(0);
            Vertex rNode = GlobalVars.Restaurants.get(restaurant).get("Node").get(0);
            Edge visitLink = graph.addEdge(null,pNode,rNode,"relation");

            visitLink.setProperty("relation","Visits");

            GlobalVars.Restaurants.get(restaurant).get("VisitedBy").add(pNode);
            GlobalVars.People.get(person).get("Visits").add(rNode);
            
        }




    public static void Follows(String followed, String follower){

        Vertex followedNode = GlobalVars.People.get(followed).get("Node").get(0);
        Vertex followerNode = GlobalVars.People.get(follower).get("Node").get(0);


        Edge edge1 = graph.addEdge(null, followedNode, followerNode, "Relation");

        GlobalVars.People.put()
    }
}
