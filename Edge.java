package Graph;

public class Edge {
	
	int node1,node2;
	
	public Edge(int node1, int node2) {
		this.node1 = node1;
		this.node2 = node2;
		
	}
	//setters:
		public void setNode1(int node) {
			node1=node;
		}
		public void setNode2(int node) {
			node2=node;
		}
		//getters:
		public int getNode1() {
			return node1;
		}
		public int getNode2() {
			return node2;
		}
	}

