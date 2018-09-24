package br.edu.ifce.estruturas.conjuntos;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento {
	
	private ArrayList<LinkedList<String>>tabelaEspalhamento = 
	new ArrayList<LinkedList<String>>();
	
	private int totalDeElementos = 0;
	public ConjuntoEspalhamento()	{
		
		for(int i=0; i<26;i++) {
			LinkedList<String> lista =new LinkedList<String>();
			tabelaEspalhamento.add(lista);
		}
		
	}
	public int funcaoEspalhamento(String palavra) {
		return palavra.toLowerCase().charAt(0) % 26;
	}
			
	public void adiciona(String palavra) {
		if(!this.contem(palavra)) {
			int indice = this.funcaoEspalhamento(palavra);
			LinkedList<String> lista = this.tabelaEspalhamento.get(indice);
			lista.add(palavra);
			totalDeElementos++;
		}
	}
		
		
	public void remove(String palavra) {
		
		if(this.contem(palavra)) {
			int indice = this.funcaoEspalhamento(palavra);
			LinkedList<String> lista = this.tabelaEspalhamento.get(indice);
			lista.remove(palavra);
			totalDeElementos--;
		}
	}
	
	public boolean contem(String palavra) {
		int indice = this.funcaoEspalhamento(palavra);
		LinkedList<String> lista = this.tabelaEspalhamento.get(indice);
		
		return lista.contains(palavra);
	}
	
	public List<String> pegaTodasPalavras(){
		List <String> L = new LinkedList<String>() ;
		for(int i = 0;i<=25;i++) {
			LinkedList<String> lista = this.tabelaEspalhamento.get(i);
			L.addAll(lista);
			
		}
		return L;
		
	}
	public int tamanho() {
		return totalDeElementos;
	}
	
	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		for(int i = 0; i< tabelaEspalhamento.size(); i++){
			LinkedList<String> lista = this.tabelaEspalhamento.get(i);
			
			if(!lista.isEmpty()) {
				String palavra = lista.toString();
			
				b.append("["+palavra.charAt(1)+"]-->"+palavra);
				b.append(" \n");
			}
				
		}
		
		return b.toString();
	}
	
}
