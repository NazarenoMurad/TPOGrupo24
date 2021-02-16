package implementaciones;

public interface ConjuntoTDA {
	public void Agregar( int x);
	public boolean ConjuntoVacio();
	public int Elegir();
	public void InicializarConjunto();
	public boolean Pertenece( int x);
	public void Sacar( int x);
}
