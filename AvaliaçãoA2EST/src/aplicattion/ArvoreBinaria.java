package aplicattion;



public class ArvoreBinaria 
{
	public No raiz = null;
	
	public No getRaiz()
	{
		return raiz;
	}
	
	public void liberaMemoria(No raiz)
	{
		if (raiz == null || raiz.noFolha())
		{
			return;
		}
		
		if (raiz.getDireito() != null)
		{
			liberaMemoria(raiz.getDireito());
			raiz.setDireito(null);
		}
		
		if (raiz.getEsquerdo() != null)
		{
			liberaMemoria(raiz.getEsquerdo());
			raiz.setEsquerdo(null);
		}
		
		this.raiz = null;
	}
	
	void calculaNivelNos(No raiz, int nivel)
	{
		//Verifica se existe a arvore
		if (raiz == null)
			return;
		
		raiz.setNivel(nivel);
		calculaNivelNos(raiz.getEsquerdo(), nivel+1);
		calculaNivelNos(raiz.getDireito(), nivel+1);
	}
	
	public void insereValor (No raiz, float valor)
	{	
		//Verifica se a se arvore esta vazia
		if (this.raiz == null)
		{
			this.raiz = new No(valor);
			return;
		}
		
		//Verifica para que lado da raiz vai andar
		if (valor > raiz.getValor())
		{
			//Se nao tiver lado direito, insere
			if (raiz.getDireito() == null)
			{
				raiz.setDireito(new No(valor));
				return;
			}
			
			//Insere recursivamente
			insereValor(raiz.getDireito(), valor);
		}
		else
		{	
			if (raiz.getEsquerdo() == null)
			{
				raiz.setEsquerdo(new No(valor));
				return;
			}
			
			insereValor(raiz.getEsquerdo(), valor);
		}
	}
	
	public No removeNo(float valor, No raiz) {
		//verifica se é nulo
		if(raiz==null)
			return null;
		else {
			if(raiz.getValor()==valor) {
				//remove no FOLHA
				if(raiz.getEsquerdo()==null && raiz.getDireito()==null) {
					raiz=null;
					return null;
				}
				else {
					// remove no com apenas 1 filho
					if(raiz.getEsquerdo() ==null || raiz.getDireito() == null) {
						No temp;
						if(raiz.getEsquerdo()!=null)
							temp= raiz.getEsquerdo();
						else
							temp= raiz.getDireito();
						raiz=null;
						return temp;
					}
					//troca o no com o de valor mais proximo e exclui o ultimo 
					else {
						No temp = raiz.getEsquerdo();
						while(temp.getDireito() != null)
							temp= temp.getDireito();
						raiz.setValor(temp.getValor());
						temp.setValor(valor);
						raiz.setEsquerdo(removeNo(valor,raiz.getEsquerdo()));
						return raiz;
					}
				}
			}
			//chama o metodo de forma recursiva
			else{
				if(valor<raiz.getValor())
					raiz.setEsquerdo(removeNo(valor,raiz.getEsquerdo()));
				else
					raiz.setDireito(removeNo(valor,raiz.getDireito()));
				return raiz;
			}
		}
	}
	
	public boolean buscaValor(float valor, No raiz) {
		if(raiz == null) {
			return false;
		}
		if(valor == raiz.getValor()) {
			return true;
		}
		if(buscaValor(valor, raiz.getDireito())) {
			return true;
		}else if(buscaValor(valor, raiz.getEsquerdo())){
			return true;
		}
		return false;
	}
	
	public No buscaNo(float valor, No raiz) {
		if(raiz == null) {
			return null;
		}
		if(valor == raiz.getValor()) {
			return raiz;
		}
		if(raiz.getDireito() != null && raiz.noFolha() != true) {
			return buscaNo(valor, raiz.getDireito());
		}else if(raiz.getEsquerdo() != null) {
			return buscaNo(valor, raiz.getEsquerdo());
		}
		return null;
	}

	
	public void imprimeReprovados(No raiz) {
		if (raiz == null)
			return;
		
		imprimeReprovados(raiz.getEsquerdo());
		if(raiz.getValor()<3.0)
			System.out.println(raiz.getValor());
		imprimeReprovados(raiz.getDireito());
	}
	
	public void imprimeAprovados(No raiz) {
		if (raiz == null)
			return;
		
		imprimeAprovados(raiz.getEsquerdo());
		if(raiz.getValor()>6.0)
			System.out.println(raiz.getValor());
		imprimeAprovados(raiz.getDireito());
	}
	
	public void imprimeFinal(No raiz) {
		if (raiz == null)
			return;
		
		imprimeFinal(raiz.getEsquerdo());
		if(raiz.getValor()<6.0 && raiz.getValor()>3.0)
			System.out.println(raiz.getValor());
		imprimeFinal(raiz.getDireito());
	}
	
	public void imprimeAlunos(No raiz)
	{
		if (raiz == null)
			return;
		
		imprimeAlunos(raiz.getEsquerdo());
		System.out.println(raiz.getValor());
		imprimeAlunos(raiz.getDireito());
	}
}