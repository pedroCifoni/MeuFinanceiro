package entities;

import java.time.LocalDate;
import java.util.Date;

public class Transacao {
	
	private Double valor;
	private Integer tipo;
	private LocalDate data;
	private String descricao;
	
	public Transacao() {
		
	}
	
	public Transacao(Double valor, Integer tipo, LocalDate data, String descricao) {
		this.valor = valor;
		this.tipo = tipo;
		this.data = data;
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Transacao valor=" + valor + 
				", tipo=" + tipo + 
				", data=" + data + 
				", descricao=" 
				+ descricao + "";
	}
	
	
	
	
}
