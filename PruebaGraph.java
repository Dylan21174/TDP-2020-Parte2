package Graph;

public class PruebaGraph {
	
	public static void main(String [] args) {
		
		Graph grafo = new Graph();
		
		//Añado los nodos a la estructura
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		
		//Añado arcos diferentes 
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 2);
		grafo.addEdge(3,4);
		
		//Remuevo el primer nodo y luego intento hacerlo nuevamente
		grafo.removeNode(1);
		grafo.removeNode(1);
			
		//Remuevo el arco e intento hacerlo otra vez
		grafo.removeEdge(3,4);
		grafo.removeEdge(3,4);
		
		//Remuevo un arco que no estaba en la estructura
		grafo.removeNode(5);
		
	}

}
