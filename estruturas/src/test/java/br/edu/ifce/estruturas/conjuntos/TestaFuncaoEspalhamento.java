package br.edu.ifce.estruturas.conjuntos;

public class TestaFuncaoEspalhamento {

	public static void main(String[] args) {
		ConjuntoEspalhamento ce1 = new ConjuntoEspalhamento();
		System.out.print(ce1.funcaoEspalhamento("GUSTAVO"));
		ce1.adiciona("gustavo");
		System.out.println();
	}

}
