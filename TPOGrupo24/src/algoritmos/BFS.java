package algoritmos;

import implementaciones.ColaTDA;
import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoTDA;

public class BFS {

public void  bfs (GrafoTDA grafo, int nodoAct, ConjuntoTDA visitados, ColaTDA cola ) {
		cola.Acolar(nodoAct);
		visitados.Agregar(nodoAct);
		while(!cola.ColaVacia()) {
			int v=cola.Primero();
			System.out.println(v);
			cola.Desacolar();
			ConjuntoTDA adyacentes=Adyacentes(grafo,v);
			while(!adyacentes.ConjuntoVacio()) {
				int n=adyacentes.Elegir();
				adyacentes.Sacar(n);
				if(!visitados.Pertenece(n)) {
				visitados.Agregar(n);
				cola.Acolar(n);
				}
				
			}
		}
		
		forest(grafo,visitados,cola);
		
	}

public void forest(GrafoTDA grafo,ConjuntoTDA visitados,ColaTDA cola) {
	ConjuntoTDA verticesGrafo=new ConjuntoEstatico();
	verticesGrafo.InicializarConjunto();
	verticesGrafo=grafo.Vertices();
	
	
	while(!verticesGrafo.ConjuntoVacio()) {
		
		int x=verticesGrafo.Elegir();
		verticesGrafo.Sacar(x);
	if(!visitados.Pertenece(x)) {
		bfs(grafo,x,visitados,cola);
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
