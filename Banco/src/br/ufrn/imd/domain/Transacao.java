package br.ufrn.imd.domain;

public class Transacao {
	
	enum Type {
		IN,
		OUT
	}
	
	private int id;
	private Cliente user;
	private Cliente other;
	private Type type;
	private double valor;
	
	public Transacao() {}
	
	public Transacao(Cliente user, Cliente other, double valor, Type type) {
		this.user = user;
		this.user = user;
		this.type = type;
	}

	public Cliente getUser() {
		return user;
	}

	public void setUser(Cliente user) {
		this.user = user;
	}

	public Cliente getOther() {
		return other;
	}

	public void setOther(Cliente other) {
		this.other = other;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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
	
	
}
