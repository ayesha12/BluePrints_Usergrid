import com.tinkerpop.blueprints.*;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import org.apache.tinkerpop.gremlin.util.Gremlin;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        link1 = GlobalVars.graph.addEdge(null, person1, restaurant1, "Visits");
        link2 = GlobalVars.graph.addEdge(null, person2, restaurant1, "Visits");
        link3 = GlobalVars.graph.addEdge(null, person3, restaurant1, "Visits");
        link4 = GlobalVars.graph.addEdge(null, person1, person2, "Follows");
        link5 = GlobalVars.graph.addEdge(null, person3, person2, "FollowedBy");


//        link1.setProperty("relation","likes");
//        link2.setProperty("relation","likes");
//        link3.setProperty("relation","likes");
//        link4.setProperty("relation","follows");
//        link5.setProperty("relation","followedby");


//        System.out.println("Edges of " + GlobalVars.graph);
//        for (Edge edge : GlobalVars.graph.getEdges()) {
//            System.out.println(edge.getProperty("relation"));
//        }
//
//        for (Vertex edge : GlobalVars.graph.getVertices()) {
//            Iterable<Edge> e1 = edge.getEdges(Direction.IN);
//            for (Edge e : e1){
////                System.out.println(e.getProperty("relation"));
//                if(e.getProperty("relation").equals("likes")){
//                    System.out.println("hello");
//                }
//
//            }
//        }
    }

    public static void TraverseGraph() throws ScriptException {


//        //ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = new ScriptEngineManager.getEngineByName("gremlin-groovy");
//
//
//        List results = new ArrayList();
//        Bindings bindings = engine.createBindings();
//        bindings.put("g", GlobalVars.graph);
////        bindings.put("v", GlobalVars.graph.getVertex(1));
//        engine.eval("g.V(1).name",bindings);

        GremlinPipeline pipe = new GremlinPipeline();
        pipe.start(GlobalVars.graph.getVertices());
//        pipe.start(GlobalVars.graph.getVertices());
        for (Object name :pipe.property("name")){
            System.out.println( name);
        }
//        pipe.start(GlobalVars.graph.getVertex(1));
//        pipe.property("name");
    }
    public static void main( String[] args ) throws ScriptException {
       CreateGraph();
       TraverseGraph();
        GlobalVars.graph.shutdown();

    }

}
