package resources;

import algoritmos.BFS;
import algoritmos.DFS;
import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoEstatico;
import implementaciones.GrafoTDA;

public class PruebaBFS {

	public static void main(String[] args) {
		ConjuntoTDA visitados=new ConjuntoEstatico();
		visitados.InicializarConjunto();
		GrafoTDA grafo=new GrafoEstatico();
		grafo.InicializarGrafo();
		grafo.AgregarVertice(0);
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
	
		
		grafo.AgregarArista(0, 1, 1);
		grafo.AgregarArista(0, 2, 1);
		grafo.AgregarArista(1, 5, 1);
		grafo.AgregarArista(2, 3, 1);
		grafo.AgregarArista(3, 4, 1);
		
		
		
		
		
		System.out.println("BFS");
		System.out.println("Los nodos del grafo son:");
		BFS alg=new BFS();
		alg.bfs(grafo, 0, visitados);

	}

}
