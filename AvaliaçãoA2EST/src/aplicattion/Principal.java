package aplicattion;

import java.util.Random;

public class Principal {
	public static float converte(float numero, int precisao) {
		int numInt = (int) (numero * Math.pow(10.0, precisao));
		return (float) (((float) numInt) / Math.pow(10.0, precisao));
	}
	
	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		
		Random rand = new Random();
		
		
		for (int i = 0; i < 11; i++) {
			float x = rand.nextFloat()*10;
		    x= converte(x,1);
			arvore.insereValor(arvore.raiz, x);
		}
	    
//		arvore.insereValor(arvore.raiz, 5);
//		arvore.insereValor(arvore.raiz, 8);
//		arvore.insereValor(arvore.raiz, 9);


	
//		arvore.imprimeAlunos(arvore.raiz);
		
		System.out.println("--Alunos reprovados--");
		arvore.imprimeReprovados(arvore.raiz);
		System.out.println();
		System.out.println("--Alunos de exame final--");
		arvore.imprimeFinal(arvore.raiz);
		System.out.println();
		System.out.println("--Alunos provados--");
		arvore.imprimeAprovados(arvore.raiz);

	}
}
