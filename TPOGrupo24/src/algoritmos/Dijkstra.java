package algoritmos;

import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoEstatico;
import implementaciones.GrafoTDA;

public class Dijkstra {
	public GrafoTDA dijkstra(GrafoTDA grafo, int vertice) { //grafo_parametro y vertice_parametro
		ConjuntoTDA visitados = new ConjuntoEstatico();
		visitados.InicializarConjunto(); //creo un conjunto para los grafos visitados
		visitados.Agregar(vertice);//agrego el vertice_parametro
		
		ConjuntoTDA verticesGrafo = new ConjuntoEstatico(); //creo un conjunto para los vertices del grafo
		verticesGrafo.InicializarConjunto();
		copiarConjuntos(grafo.Vertices(), verticesGrafo);
		
		GrafoTDA grafoAux = new GrafoEstatico(); //creo un grafo auxiliar
		grafoAux.InicializarGrafo();
		
		while(!verticesGrafo.ConjuntoVacio()) { //lleno el grafo auxiliar solamente con los vertices del grafo_parametro
			int v = verticesGrafo.Elegir();
			grafoAux.AgregarVertice(v);
			verticesGrafo.Sacar(v);
		}
		
		ConjuntoTDA adyA = new ConjuntoEstatico(); //adyacentes a vertice_parametro
		adyA.InicializarConjunto();
		adyA = adyacentes(grafo, vertice);
		
		//agrego las aristas entre el vertice_parametro y sus adyacentes, al grafo auxiliar
		while(!adyA.ConjuntoVacio()) {
			int v = adyA.Elegir();
			int peso = grafo.PesoArista(vertice, v); //obtengo peso de esa arista entre vertice_parametro y v
			grafoAux.AgregarArista(vertice, v, peso); //la agrego al grafo auxiliar
			adyA.Sacar(v);//saco de adyacentes para que el while itere
		}
		
		/*Creo el conjunto de vertices pendientes
		 *con todos los vertices del grafo_parametro menos el vertice_parametro*/
		copiarConjuntos(grafo.Vertices(), verticesGrafo);
		verticesGrafo.Sacar(vertice);
		ConjuntoTDA pendientes = new ConjuntoEstatico();
		pendientes.InicializarConjunto();
		copiarConjuntos(verticesGrafo, pendientes);
		
		ConjuntoTDA ady = new ConjuntoEstatico(); //adyacentes a vertice_parametro
		ady.InicializarConjunto();
		ady = adyacentes(grafoAux, vertice);
		
		//comienzo a llenar el grafo auxiliar con las aristas que correspondan a dijkstra
		while(!pendientes.ConjuntoVacio() && !ady.ConjuntoVacio()) {
			//busco el nodo con la arista de menor peso conectada al vertice_parametro usando adyacentes
			int menor = ady.Elegir(); //elijo un vertice aleatorio adyacente a vertice_parametro
			
			ConjuntoTDA adyWhile = new ConjuntoEstatico();
			adyWhile.InicializarConjunto();
			copiarConjuntos(ady, adyWhile);
			
			while(!adyWhile.ConjuntoVacio()) {
				int x = adyWhile.Elegir();
				if(grafoAux.PesoArista(vertice, x) <= grafoAux.PesoArista(vertice, menor)) {
					menor = x; //lo guardo si es menor o igual
				}
				adyWhile.Sacar(x);
			}
			/* Verifico si hay un camino mejor del vertice_parametro a p pasando por el menor */
			visitados.Agregar(menor);
			pendientes.Sacar(menor);
			ady.Sacar(menor);
			
			ConjuntoTDA auxPendientes = new ConjuntoEstatico();
			auxPendientes.InicializarConjunto();
			copiarConjuntos(pendientes, auxPendientes);
			
			while(!auxPendientes.ConjuntoVacio()) {
				int p = auxPendientes.Elegir();
				auxPendientes.Sacar(p);
				if(grafo.ExisteArista(menor, p)) {
					if(grafoAux.ExisteArista(vertice, p)) {
						if((grafoAux.PesoArista(vertice, menor) + grafo.PesoArista(menor, p)) <= grafoAux.PesoArista(vertice, p)) {
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
	
	public ConjuntoTDA adyacentes(GrafoTDA grafo, int nodoAct) {
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
	
	public void copiarConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
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
