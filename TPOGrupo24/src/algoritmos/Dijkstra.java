package algoritmos;

import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoEstatico;
import implementaciones.GrafoTDA;

public class Dijkstra {
	public GrafoTDA dijkstra(GrafoTDA grafo, int vertice) {
		ConjuntoTDA visitados = new ConjuntoEstatico();
		visitados.InicializarConjunto(); //creo un conjunto para los grafos visitados
		
		ConjuntoTDA verticesGrafo=new ConjuntoEstatico(); //creo un conjunto para los vertices del grafo
		verticesGrafo.InicializarConjunto();
		verticesGrafo=grafo.Vertices();
		
		GrafoTDA grafoAux = new GrafoEstatico(); //creo un grafo auxiliar
		grafoAux.InicializarGrafo();
		
		while(!verticesGrafo.ConjuntoVacio()) {
			int v = verticesGrafo.Elegir();
			grafoAux.AgregarVertice(v);
			verticesGrafo.Sacar(v);
		}
		
		ConjuntoTDA ady = Adyacentes(grafo, vertice);
		
		while(ady.ConjuntoVacio()) {
			int v = ady.Elegir();
			int peso = grafo.PesoArista(vertice, v); //obtengo peso de esa arista entre vertice parametro y v
			grafoAux.AgregarArista(vertice, v, peso); //la agrego al grafo auxiliar
			ady.Sacar(v);//saco de adyacentes para que el while itere
		}
		
		ConjuntoTDA pendientes = grafo.Vertices();
		
		while(!pendientes.ConjuntoVacio()) {
			//busco el nodo con la arista de menor peso conectada al vertice parametro usando adyacentes
			ady = Adyacentes(grafo, vertice);
			int menor = grafo.PesoArista(vertice, pendientes.Elegir()); //elijo un adyacente aleatorio
			ConjuntoTDA pendientesWhile = pendientes;
			while(!ady.ConjuntoVacio()) {
				int x = pendientesWhile.Elegir();
				if(grafo.PesoArista(vertice, x) < menor) menor = grafo.PesoArista(vertice, x);
				pendientesWhile.Sacar(x);
			}
			visitados.Agregar(menor);
			pendientes.Sacar(menor);
			ConjuntoTDA auxPendientes = pendientes;
			while(!auxPendientes.ConjuntoVacio()) {
				int p = auxPendientes.Elegir();
				auxPendientes.Sacar(p);
				if(grafo.ExisteArista(menor, p)) {
					if(grafoAux.ExisteArista(vertice, p)) {
						if((grafoAux.PesoArista(vertice, menor) + grafo.PesoArista(menor, p)) < grafoAux.PesoArista(vertice, p)) {
							grafoAux.AgregarArista(vertice, p, grafoAux.PesoArista(vertice, menor) + grafo.PesoArista(menor, p));
						}
					}
					else {
						grafoAux.AgregarArista(vertice, p, grafoAux.PesoArista(vertice, menor) + grafo.PesoArista(menor, p));
					}
				}
			}
		}
		return grafoAux;
	}
	
	public ConjuntoTDA Adyacentes(GrafoTDA grafo, int nodoAct) {
	     ConjuntoTDA vertices = new ConjuntoEstatico(); 
	     vertices.InicializarConjunto();
	     ConjuntoTDA vAdyacentes = new ConjuntoEstatico(); 
	     vAdyacentes.InicializarConjunto();
	     vertices = grafo.Vertices();
	     if (vertices.Pertenece(nodoAct)){
	           vertices.Sacar(nodoAct);
	     while (!vertices.ConjuntoVacio()){
	             int vertice = vertices.Elegir();
	             vertices.Sacar(vertice);
	             if (grafo.ExisteArista(nodoAct, vertice)) {
	                  vAdyacentes.Agregar(vertice);
	            }
	               
	            }
	        }
	        return vAdyacentes;
	}
}
