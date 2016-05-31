import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra
{
    public static void computePaths(Vertex source)
 {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex F = new Vertex("F");
        Vertex K = new Vertex("K");
        Vertex R = new Vertex("R");
        Vertex M = new Vertex("M");
        Vertex O = new Vertex("O");
        Vertex Z = new Vertex("Z");
        Vertex P = new Vertex("P");
        Vertex J = new Vertex("J");
        Vertex D = new Vertex("D");
        
        // set the edges and weight
        A.adjacencies = new Edge[]{ new Edge(B, 10) };
        F.adjacencies = new Edge[]{ new Edge(K, 23) };
        R.adjacencies = new Edge[]{ new Edge(M, 8) };
        M.adjacencies = new Edge[]{ new Edge(R, 8) };
        K.adjacencies = new Edge[]{ new Edge(O, 40) };
        Z.adjacencies = new Edge[]{ new Edge(P, 18) };
        P.adjacencies = new Edge[]{ new Edge(Z, 18) };
        
        J.adjacencies = new Edge[]{ new Edge(K, 25) };
        D.adjacencies = new Edge[]{ new Edge(B, 11) };
        B.adjacencies = new Edge[]{ new Edge(D, 11) };
        
        M.adjacencies = new Edge[]{ new Edge(A, 8) };
        P.adjacencies = new Edge[]{ new Edge(R, 15) };
       
        

        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List<Vertex> path = getShortestPathTo(Z);
        System.out.println("Path: " + path);
    }
}