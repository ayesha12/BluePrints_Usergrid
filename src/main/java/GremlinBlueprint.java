import com.tinkerpop.blueprints.*;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.util.iterators.SingleIterator;

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
    static Vertex person1,person2,person3,restaurant1,restaurant2;
    static Edge link1,link2,link3,link4,link5;

    public static void CreateGraph(){
        person1 = GlobalVars.graph.addVertex(1);
        person2 = GlobalVars.graph.addVertex(2);
        person3 = GlobalVars.graph.addVertex(3);
        restaurant1 = GlobalVars.graph.addVertex(4);
        restaurant2 = GlobalVars.graph.addVertex(5);


        person1.setProperty("name","John");
        person2.setProperty("name","Mary");
        person3.setProperty("name","Nick");
        restaurant1.setProperty("name","SW");
        restaurant2.setProperty("name","PizzaHut");


        link1 = GlobalVars.graph.addEdge(null, person1, restaurant1, "Visits");
        link1 = GlobalVars.graph.addEdge(null, person1, restaurant2, "Visits");
        link2 = GlobalVars.graph.addEdge(null, person2, restaurant1, "Visits");
        link3 = GlobalVars.graph.addEdge(null, person3, restaurant1, "Visits");
        link4 = GlobalVars.graph.addEdge(null, person2, person1, "Follows");
        link5 = GlobalVars.graph.addEdge(null, person3, person2, "FollowedBy");


    }

    public static void TraverseGraph(String namePerson) throws ScriptException {

        GremlinPipeline pipe1 = new GremlinPipeline(GlobalVars.graph);

//        pipe.V("name", "John");
        pipe1.V("name",namePerson).out("Visits");

        for (Object nameRes :pipe1.property("name")) {
            System.out.println(nameRes); //prints the restaurant name the person visited
            GremlinPipeline pipe2 = new GremlinPipeline(GlobalVars.graph).V("name", (String) nameRes).in("Visits");
            for (Object nameP : pipe2.property("name")) {
                if(!nameP.equals(namePerson)){
                System.out.println(namePerson + " should follow " + nameP);}
            }

        }

            GremlinPipeline pipe2 = new GremlinPipeline(GlobalVars.graph);
            pipe2.V("name", namePerson).in("Follows");

            for (Object nameRes: pipe2.property("name")) {
                System.out.println(nameRes); //prints the person name who is following namePerson
            }


    }
    public static void main( String[] args ) throws ScriptException {
        String name = "John";
        //CreateGraph();
        TraverseGraph(name);
        GlobalVars.graph.shutdown();

    }

}
