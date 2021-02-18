package resources;

import algoritmos.BFS;
import algoritmos.DFS;
import implementaciones.ColaEstatica;
import implementaciones.ColaTDA;
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
		grafo.AgregarVertice(6);
		grafo.AgregarVertice(7);
		
		grafo.AgregarVertice(8);
		grafo.AgregarVertice(9);
		
		
		grafo.AgregarArista(0, 1, 1);
		grafo.AgregarArista(0, 2, 1);
		grafo.AgregarArista(1, 5, 1);
		grafo.AgregarArista(2, 3, 1);
		grafo.AgregarArista(3, 4, 1);
		grafo.AgregarArista(4, 7, 1);
		grafo.AgregarArista(5, 6, 1);
		
		grafo.AgregarArista(8, 9, 1);
		
		
		
		System.out.println("BFS");
		System.out.println("Los nodos del grafo son:");
		BFS alg=new BFS();
		ColaTDA cola=new ColaEstatica();
		cola.InicializarCola();
		alg.bfs(grafo, 0, visitados,cola);
		System.out.println("vértices aislados:");
		alg.forest(grafo, visitados, cola);

	}

}
