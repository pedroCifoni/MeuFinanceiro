package entities;

import java.util.ArrayList;

public class Carteira {
	private double valorTotal;
	private ArrayList<Transacao> transacoes = new ArrayList<>();

	
	public Carteira() {
		
	}
	
	public Carteira(ArrayList<Transacao> transacoes, double valorTotal) {
		this.transacoes = transacoes;
		this.valorTotal = valorTotal;
	}

	public ArrayList<Transacao> getTransacoes() {
		return transacoes;
	}

	
	public void setTransacoes(ArrayList<Transacao> transacoes) {
		this.transacoes = new ArrayList<>(transacoes);
	}

	public double getValorTotal() {
		return valorTotal;
	}


	public void adicionarTransacao(Transacao t) {
		transacoes.add(t);
	}
	
	public void listarTransacoes() {
		for(Transacao t : transacoes) {
			System.out.println(t);
		}
	}
	
	public double calcularSaldo() {
		double saldo =  0.0;
		for(Transacao tr : transacoes) {
			if(tr.getTipo() == 1) {
				saldo += tr.getValor();
			}
			else {
				saldo -= tr.getValor();
			}
		}
		return saldo;
	}
	
	public void relatorioMensal(int mes) {
		boolean encontrou = false;
		for(Transacao t : transacoes) {
			if(t.getData().getMonthValue() == mes) {
				System.out.println(t);
				encontrou = true;
			}
		}
		if(encontrou != true) {
			System.out.println("Não foi encontrada data nesse mes");
		}
	}
}
