package resources;

import algoritmos.DFS;
import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoEstatico;
import implementaciones.GrafoTDA;


public class PruebaDFS {

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
		grafo.AgregarArista(0, 3, 1);
		grafo.AgregarArista(0, 4, 1);
		grafo.AgregarArista(1, 2, 1);
		grafo.AgregarArista(1, 5, 1);
		grafo.AgregarArista(2, 3, 1);
		grafo.AgregarArista(2, 4, 1);
		grafo.AgregarArista(3, 4, 1);
		grafo.AgregarArista(5, 4, 1);
		
		
		
		DFS alg=new DFS();
		alg.dfs(grafo, 0, visitados);
		
		/*ConjuntoTDA ady=new ConjuntoEstatico();
		ady.InicializarConjunto();
		ady=alg.Adyacentes(grafo, 0);
		while(!ady.ConjuntoVacio()) {
			int a=ady.Elegir();
			System.out.println(a);
			ady.Sacar(a);
			
		}*/
	}

}
