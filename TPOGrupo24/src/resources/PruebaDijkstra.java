package resources;

import algoritmos.Dijkstra;
import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoEstatico;
import implementaciones.GrafoTDA;

public class PruebaDijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrafoTDA grafo = new GrafoEstatico();
		grafo.InicializarGrafo();
		
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
		grafo.AgregarVertice(6);
		
		grafo.AgregarArista(1, 2, 2);
		grafo.AgregarArista(1, 4, 15);
		grafo.AgregarArista(1, 5, 4);
		grafo.AgregarArista(1, 6, 3);
		grafo.AgregarArista(2, 5, 2);
		grafo.AgregarArista(2, 3, 3);
		grafo.AgregarArista(3, 4, 6);
		grafo.AgregarArista(5, 6, 3);
		grafo.AgregarArista(5, 4, 1);
		grafo.AgregarArista(6, 4, 1);
		
		Dijkstra d = new Dijkstra();
		GrafoTDA graph = new GrafoEstatico();
		graph.InicializarGrafo();
		graph = d.dijkstra(grafo, 1);
		ConjuntoTDA vertices = new ConjuntoEstatico();
		vertices.InicializarConjunto();
		copiarConjuntos(graph.Vertices(), vertices);
		
		while(!vertices.ConjuntoVacio()) {
			int elem = vertices.Elegir();
			System.out.println("V:1 -----"+graph.PesoArista(1, elem)+"-----> "+elem);
			vertices.Sacar(elem);
		}
	}

	public static void copiarConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
		ConjuntoTDA auxA = new ConjuntoEstatico();
		auxA.InicializarConjunto();
		
		while(!a.ConjuntoVacio()) {
			int elem = a.Elegir();
			auxA.Agregar(elem);
			a.Sacar(elem);
		}
		
		while(!auxA.ConjuntoVacio()){
			int elem = auxA.Elegir();
			a.Agregar(elem);
			b.Agregar(elem);
			auxA.Sacar(elem);
		}
	}
}
