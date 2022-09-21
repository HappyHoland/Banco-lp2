package br.ufrn.imd.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Transacao {
	
	private int id;
	private Cliente from;
	private Cliente to;
	private double valor;
	private LocalDate data;
	
	public Transacao() {}
	
	public Transacao(Cliente from, Cliente to, double valor, LocalDate data) {
		this.from = from;
		this.from = from;
		this.data = data;
	}

	public Cliente getFrom() {
		return from;
	}

	public void setFrom(Cliente from) {
		this.from = from;
	}

	public Cliente getTo() {
		return to;
	}

	public void setTo(Cliente to) {
		this.to = to;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return id == other.id;
	}
	
}
