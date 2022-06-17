package aplicattion;



public class No 
{
	private float valor;
	private No esquerdo;
	private No direito;
	private int nivel;
	
	public int getNivel() {
		return nivel;
	}
	
	public boolean noFolha()
	{
		return (direito == null && esquerdo == null);
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	No(float valor)
	{
		this.valor = valor;
	}
	

	public float getValor() {
		return valor;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}
	
	public void finalize()
	{
		System.out.println("LIBERADO");
	}
}