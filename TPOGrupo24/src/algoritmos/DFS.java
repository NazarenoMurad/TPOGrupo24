package algoritmos;

import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoTDA;


public class DFS {
	
	public void  dfs (GrafoTDA grafo, int nodoAct, ConjuntoTDA visitados ) {
		
		if(!visitados.Pertenece(nodoAct)) {
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
		forest(grafo,visitados);
	}
		
		
		
	/*	int cantVertGrafo=contarVertices(grafo.Vertices());
		int cantVertVisitados=contarVertices(visitados);
		if(cantVertGrafo>cantVertVisitados) {
		forest(grafo,visitados);
		}*/
	}
	
	/*public void forest(GrafoTDA grafo,ConjuntoTDA visitados) {
		ConjuntoTDA verticesGrafo=new ConjuntoEstatico();
		verticesGrafo.InicializarConjunto();
		verticesGrafo=grafo.Vertices();
		
		int cantVertGrafo=contarVertices(verticesGrafo);
		int cantVertVisitados=contarVertices(visitados);
		if(cantVertGrafo>cantVertVisitados) {
		
			int x=verticesGrafo.Elegir();
			while(visitados.Pertenece(x)) {
				
				 x=verticesGrafo.Elegir();
				 verticesGrafo.Sacar(x);
				 
			}
			
			if(visitados.Pertenece(x)) {
				dfs(grafo,x,visitados);
				
			}
			
		}
	}
	*/
	public void forest(GrafoTDA grafo,ConjuntoTDA visitados) {
		ConjuntoTDA verticesGrafo=new ConjuntoEstatico();
		verticesGrafo.InicializarConjunto();
		verticesGrafo=grafo.Vertices();
		
		
		while(!verticesGrafo.ConjuntoVacio()) {
			
			int x=verticesGrafo.Elegir();
			verticesGrafo.Sacar(x);
		if(!visitados.Pertenece(x)) {
			dfs(grafo,x,visitados);
		}
		
		}
	}
	

	/*private int contarVertices(ConjuntoTDA conjunto) {
		ConjuntoTDA auxiliar=new ConjuntoEstatico();
		auxiliar.InicializarConjunto();
		auxiliar=conjunto;
		int contador=0;
		while(!auxiliar.ConjuntoVacio()) {
			int x=auxiliar.Elegir();
			auxiliar.Sacar(x);
			contador=contador+1;
		}
		return contador;
	}
*/
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
