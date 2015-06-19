import com.tinkerpop.blueprints.*;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import org.apache.tinkerpop.gremlin.util.Gremlin;

/**
 * Created by ayeshadastagiri on 6/19/15.
 */
public class GremlinBlueprint {
    static Vertex person1,person2,person3,restaurant1;
    static Edge link1,link2,link3,link4,link5;

    public static void CreateGraph(){
        person1 = GlobalVars.graph.addVertex(1);
        person2 = GlobalVars.graph.addVertex(2);
        person3 = GlobalVars.graph.addVertex(3);
        restaurant1 = GlobalVars.graph.addVertex(4);


        person1.setProperty("name","John");
        person2.setProperty("name","Mary");
        person3.setProperty("name","Nick");
        restaurant1.setProperty("name","SW");

        link1 = GlobalVars.graph.addEdge(null, person1, restaurant1, "relation");
        link2 = GlobalVars.graph.addEdge(null, person2, restaurant1, "relation");
        link3 = GlobalVars.graph.addEdge(null, person3, restaurant1, "relation");
        link4 = GlobalVars.graph.addEdge(null, person1, person2, "relation");
        link5 = GlobalVars.graph.addEdge(null, person3, person2, "relation");


        link1.setProperty("relation","likes");
        link2.setProperty("relation","likes");
        link3.setProperty("relation","likes");
        link4.setProperty("relation","follows");
        link5.setProperty("relation","followedby");


        System.out.println("Edges of " + GlobalVars.graph);
        for (Edge edge : GlobalVars.graph.getEdges()) {
            System.out.println(edge.getProperty("relation"));
        }

        for (Vertex edge : GlobalVars.graph.getVertices()) {
            Iterable<Edge> e1 = edge.getEdges(Direction.IN);
            for (Edge e : e1){
//                System.out.println(e.getProperty("relation"));
                if(e.getProperty("relation").equals("likes")){
                    System.out.println("hello");
                }

            }
        }
    }

    public static void TraverseGraph(){
        GremlinPipeline pipe = new GremlinPipeline();
        System.out.println(pipe.start(GlobalVars.graph.getVertex(1)));

    }
    public static void main( String[] args ){
       CreateGraph();
        TraverseGraph();

        GlobalVars.graph.shutdown();

    }

}
