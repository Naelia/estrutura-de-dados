package br.edu.ifce.estruturas.vetor;

public class TesteAdicionaQualquerPosicao {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
		a1.setNome("João");
		a2.setNome("José");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(1,a1);
		lista.adiciona(0,a2);
		
		System.out.println(lista);

	}

}
