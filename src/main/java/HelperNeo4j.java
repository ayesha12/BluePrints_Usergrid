import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.GraphFactory;
import com.tinkerpop.blueprints.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ayeshadastagiri on 6/18/15.
 */
public class HelperNeo4j {



    Graph graph = GraphFactory.open("src/main/resources/graph.properties");

    public void AddNode(String name, Enum nType){

        Vertex node = graph.addVertex(null);

        if(nType == GlobalVars.nodeType.PEOPLE){

            HashMap<String,List<Vertex>> persondetails = new HashMap<String, List<Vertex>>();

            List<Vertex> VisitNodes = new ArrayList<Vertex>();
            List<Vertex> FollowNodes = new ArrayList<Vertex>();
            List<Vertex> FollowedByNodes = new ArrayList<Vertex>();
            List<Vertex> infoNode = new ArrayList<Vertex>();

            node.setProperty("Name",name);
            node.setProperty("Type",GlobalVars.nodeType.PEOPLE);
            infoNode.add(node);

            persondetails.put("Node",infoNode);
            persondetails.put("Visits",VisitNodes);
            persondetails.put("Follows",FollowNodes);
            persondetails.put("FollowedBy",FollowedByNodes);

            GlobalVars.People.put(name,persondetails);

        }
        else if(nType == GlobalVars.nodeType.RESTAURANT){
            HashMap<String,List<Vertex>> restaurantdetails = new HashMap<String, List<Vertex>>();

            List<Vertex> infoNode = new ArrayList<Vertex>();
            List<Vertex> VisitedByNodes = new ArrayList<Vertex>();

            node.setProperty("Name",name);
            node.setProperty("Type",GlobalVars.nodeType.RESTAURANT);
            infoNode.add(node);

            restaurantdetails.put("Node",infoNode);
            restaurantdetails.put("VisitedBy",VisitedByNodes);

            GlobalVars.Restaurants.put(name,restaurantdetails);


        }


    }

}
