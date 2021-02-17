package algoritmos;

import implementaciones.ConjuntoEstatico;
import implementaciones.ConjuntoTDA;
import implementaciones.GrafoTDA;

public class BFS {

public void  bfs (GrafoTDA grafo, int nodoAct, ConjuntoTDA visitados ) {
		
		if(!visitados.Pertenece(nodoAct)) {
		visitados.Agregar(nodoAct);
		System.out.println(nodoAct);
		}
		
		ConjuntoTDA adyacentes=Adyacentes(grafo,nodoAct); //voy a buscar los adyacentes del nodoAct
		guardarHijos(adyacentes,visitados);
		int x=adyacentes.Elegir();
		adyacentes.Sacar(x);
		bfs(grafo,x,visitados);
	
		
	}

public void guardarHijos(ConjuntoTDA adyacentes, ConjuntoTDA visitados) {
	ConjuntoTDA auxiliar=adyacentes;
	while(!auxiliar.ConjuntoVacio()) {
		int n=auxiliar.Elegir();
		visitados.Agregar(n);
		System.out.println(n);
		auxiliar.Sacar(n);
		
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
