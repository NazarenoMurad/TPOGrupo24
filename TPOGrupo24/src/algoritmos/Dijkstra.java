package algoritmos;

import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoEstatico;
import implementaciones.GrafoTDA;

public class Dijkstra {
	public GrafoTDA dijkstra(GrafoTDA grafo, int vertice) { //grafo_parametro y vertice_parametro
		ConjuntoTDA visitados = new ConjuntoEstatico();
		visitados.InicializarConjunto(); //creo un conjunto para los grafos visitados
		
		ConjuntoTDA verticesGrafo=new ConjuntoEstatico(); //creo un conjunto para los vertices del grafo
		verticesGrafo.InicializarConjunto();
		verticesGrafo=grafo.Vertices();
		
		GrafoTDA grafoAux = new GrafoEstatico(); //creo un grafo auxiliar
		grafoAux.InicializarGrafo();
		
		while(!verticesGrafo.ConjuntoVacio()) { //lleno el grafo auxiliar solamente con los vertices del grafo_parametro
			int v = verticesGrafo.Elegir();
			grafoAux.AgregarVertice(v);
			verticesGrafo.Sacar(v);
		}
		
		ConjuntoTDA ady = Adyacentes(grafo, vertice); //adyacentes a vertice_parametro
		
		//agrego las aristas entre el vertice_parametro y sus adyacentes, al grafo auxiliar
		while(ady.ConjuntoVacio()) {
			int v = ady.Elegir();
			int peso = grafo.PesoArista(vertice, v); //obtengo peso de esa arista entre vertice_parametro y v
			grafoAux.AgregarArista(vertice, v, peso); //la agrego al grafo auxiliar
			ady.Sacar(v);//saco de adyacentes para que el while itere
		}
		
		ConjuntoTDA pendientes = grafo.Vertices();
		
		//comienzo a llenar el grafo auxiliar con las aristas que correspondan a dijkstra
		while(!pendientes.ConjuntoVacio()) {
			//busco el nodo con la arista de menor peso conectada al vertice_parametro usando adyacentes
			
			int menor = grafoAux.Vertices().Elegir(); //elijo un vertice aleatorio adyacente a vertice_parametro
			ConjuntoTDA pendientesWhile = pendientes;
			while(!pendientesWhile.ConjuntoVacio()) {
				int x = pendientesWhile.Elegir();
				if(grafoAux.PesoArista(vertice, x) < grafoAux.PesoArista(vertice, menor)) menor = x; //lo guardo si es menor
				pendientesWhile.Sacar(x);
			}
			/* Verifico si hay un camino mejor del vertice_parametro a p pasando por el menor */
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
