package algoritmos;

import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoTDA;


public class DFS {
	
	public void  dfs (GrafoTDA grafo, int nodoAct, ConjuntoTDA visitados ) {
		visitados.Agregar(nodoAct);
		System.out.println(nodoAct);
		ConjuntoTDA adyacentes=Adyacentes(grafo,nodoAct); //voy a buscar los adyacentes del nodoAct
		while(!adyacentes.ConjuntoVacio()) {
			int n=adyacentes.Elegir();
			adyacentes.Sacar(n);
			if(!visitados.Pertenece(n)) {
				dfs(grafo,n,visitados);
			}
		}
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
