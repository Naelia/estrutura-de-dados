package br.edu.ifce.estruturas.conjuntos;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento {
	
	private ArrayList<LinkedList<Object>>tabelaEspalhamento = 
	new ArrayList<LinkedList<Object>>();
	
	private int totalDeElementos = 0;
	public ConjuntoEspalhamento()	{
		
		for(int i=0; i<26;i++) {
			LinkedList<Object> lista =new LinkedList<Object>();
			tabelaEspalhamento.add(lista);
		}
		
	}
	
	
	
	public int calculaIndiceDeTabela(Object palavra) {
		int codigoEspalhamento = palavra.hashCode();
				codigoEspalhamento = Math.abs(codigoEspalhamento);
		return codigoEspalhamento % this.tabelaEspalhamento.size();
	}
	private void vereficaCarga() {
		int capacidade = this.tabelaEspalhamento.size();
		double carga = this.tamanho()/capacidade;
		
		if (carga>0.75) {
			this.redimensionaTabela(capacidade*2);
			
		}else if(carga<0.25) {
			this.redimensionaTabela(Math.max(capacidade/2, 10));
		}
	}
	
	
	private void redimensionaTabela(int novaCapacidade) {
		List<Object> backub = this.pegaTodasPalavras();
		this.tabelaEspalhamento.clear();
		
		for(int i=0; i< novaCapacidade;i++) {
			LinkedList<Object> lista =new LinkedList<Object>();
			tabelaEspalhamento.add(lista);
		}
		for(Object palavra :backub) {
			this.adiciona(palavra);
			
		}
		
		
	}
	
	
	
	public void adiciona(Object palavra) { 
		if(!this.contem(palavra)) {
			int indice = this.calculaIndiceDeTabela(palavra);
			LinkedList<Object> lista = this.tabelaEspalhamento.get(indice);
			lista.add(palavra);
			totalDeElementos++;
		}
	}
		
		
	public void remove(Object palavra) {
		
		if(this.contem(palavra)) {
			int indice = this.calculaIndiceDeTabela(palavra);
			LinkedList<Object> lista = this.tabelaEspalhamento.get(indice);
			lista.remove(palavra);
			totalDeElementos--;
		}
	}
	
	public boolean contem(Object palavra) {
		int indice = this.calculaIndiceDeTabela(palavra);
		LinkedList<Object> lista = this.tabelaEspalhamento.get(indice);
		
		return lista.contains(palavra);
	}
	
	public List<Object> pegaTodasPalavras(){
		List <Object> L = new LinkedList<Object>() ;
		for(int i = 0;i<=25;i++) {
			LinkedList<Object> lista = this.tabelaEspalhamento.get(i);
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
			LinkedList<Object> lista = this.tabelaEspalhamento.get(i);
			
			if(!lista.isEmpty()) {
				String palavra = lista.toString();
			
				b.append("["+palavra.charAt(1)+"]-->"+palavra);
				b.append(" \n");
			}
				
		}
		
		return b.toString();
	}
	
}
