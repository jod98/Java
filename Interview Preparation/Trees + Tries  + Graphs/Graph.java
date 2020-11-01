import java.util.*;                                                               // import dependencies

// Initiating Graph Class (Collection of Vertices and Edges)
public class Graph <T> {                                                           // <T> = class is generic (data independent). Supports all objects + types (int, char...)

    private Map<T, List<T> > map = new HashMap<>();                               // hashmap to store the edges in the graph

    // Add Vertex
    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());                                          // puts new vertex in graph (represented as linkedlist)
    }

    // Add Edge (between source and destination)
    public void addEdge(T source, T destination, boolean bidirectional)
    {
        if (!map.containsKey(source))                                             // if no source, create vertex
            addVertex(source);

        if (!map.containsKey(destination))                                        // if no destination, create vertex
            addVertex(destination);

        map.get(source).add(destination);                                         // now get source and add destination
        if (bidirectional == true) {
            map.get(destination).add(source);                                     // if bidirectional... get destination and add source
        }
    }

    // Print No. Of Vertices
    public void getVertexCount() {
        System.out.println("The graph has " + map.keySet().size() + " vertex");
    }

    // Print No. Of Edges
    public void getEdgesCount(boolean bidirection) {
        int count = 0;                                                           // count no. of edges (no hashmap function built in)
        for (T v : map.keySet()) {
            count += map.get(v).size();                                          // counting number of edges in graph
        }
        if (bidirection == true) {                                               // if bidirectional, then halve the count value so we don't recount same edge
            count = count / 2;
        }
        System.out.println("The graph has " + count + " edges.");
    }

    // Vertex Present?
    public void hasVertex(T s)
    {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    // Edge Present?
    public void hasEdge(T s, T d)
    {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between " + s + " and " + d + ".");
        }
    }

    // Print Adjacency List
    @Override // overiding parameters etc. of a method in super-class (parent-class)
    public String toString()
    {
        StringBuilder builder = new StringBuilder();                              // creating modifiable string (string-builder)

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");                                  // iterating over all vertices, adding to adjacency list

            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");                               // itearating over all edges, adding to adjacency list
            }
            builder.append("\n");                                                 // add newline for easier viewing
        }
        return (builder.toString());                                              // return adjacency list
    }

    public static void main(String args[]) {
        Graph<Integer> g = new Graph<Integer>();                              // graph object created

        // Since the graph is bidirectional,boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);                      // add Edge between Vertex (0, 1)
        g.addEdge(0, 4, true);                      // add Edge between Vertex (0, 1)
        g.addEdge(1, 2, true);                      // add Edge between Vertex (0, 1)
        g.addEdge(1, 3, true);                      // add Edge between Vertex (0, 1)
        g.addEdge(1, 4, true);                      // add Edge between Vertex (0, 1)
        g.addEdge(2, 3, true);                      // add Edge between Vertex (0, 1)
        g.addEdge(3, 4, true);                      // add Edge between Vertex (0, 1)

        System.out.println("Graph:\n" + g.toString());                        // print graph

        g.getVertexCount();                                                   // print no. of vertices

        g.getEdgesCount(true);                                       // print no. of edges

        // tells whether the edge is present or not.
        g.hasEdge(3, 4);                                                // edge present between vertex (3, 4)?

        g.hasVertex(5);                                                    // vertex present at (5)?
    }
}
