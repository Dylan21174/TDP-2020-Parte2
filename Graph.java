package Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph {
	
	private Map<Integer,Integer> nodes;
	private Map<String,Edge> edges;
	private static Logger logger;
	
	public Graph() {
		this.nodes = new HashMap<Integer,Integer>();
		this.edges = new HashMap<String,Edge>();
		
		if(logger == null) {
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);		
			
			Logger rootLogger = logger.getParent();
			for(Handler h : rootLogger.getHandlers())
				h.setLevel(Level.OFF);
		}			
	}
	
	public void addNode(int node){
		  
		boolean estaN = this.nodes.containsKey(node);	
		if(!estaN) {		
			this.nodes.put(node, node);
			logger.fine("El nodo "+node+" fue añadido al grafo.");}
		else {
			logger.warning("El nodo ya estaba en el grafo.");	
		}
	}
	
	public void removeNode(int node){
		
		boolean estaN = this.nodes.containsKey(node);	
		if(estaN) {
			logger.fine("El nodo "+node+" fue eliminado al grafo.");
			this.nodes.remove(node, node);
		}
		else
			logger.warning("El nodo no estaba en el grafo.");	
	}
		
	public void addEdge(int node1, int node2) {
		boolean estaN1 = this.nodes.containsKey(node1);
		boolean estaN2 = this.nodes.containsKey(node2);
		
		Edge edge = new Edge(node1,node2);
		String key = node1 + "," + node2;
		Edge value = this.edges.put(key,edge);
		
		
		if(value != null) 
			logger.warning("El arco ya existia.");
		else {
			if(!estaN1 || !estaN2)		
				logger.warning("Alguno de los nodos no estaba en el grafo.");
			else {			
				this.edges.put(key,edge);	
				logger.fine("El arco formado por los nodos "+node1+" y "+node2+" fue agregado al grafo.");
			}
		}	
	}
	
	public void removeEdge(int node1, int node2){
		
		boolean estaN1 = this.nodes.containsKey(node1);
		boolean estaN2 = this.nodes.containsKey(node2);
		
		Edge edge = new Edge(node1,node2);
		String key = node1 + "," + node2;
		Edge value = this.edges.put(key,edge);
		
		if(value != null) {
			this.edges.remove(key,edge);	
			logger.fine("El arco formado por los nodos "+node1+" y "+node2+" fue eliminado del grafo.");	
		}
		else {
			if(!estaN1 || !estaN2)
				logger.warning("Alguno de los nodos no estaba en el grafo.");
			else
				logger.warning("El arco no existe en el grafo.");
		}
	}
}

