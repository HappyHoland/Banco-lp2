package br.ufrn.imd.domain;

import java.util.Objects;

public class Agencia {
	
	private int id;
	private String descricao;
	private String endereco;
	private Banco banco;
	
	public Agencia() {}
	
	public Agencia(String descricao, Banco banco) {
		super();
		this.descricao = descricao;
		this.banco = banco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	@Override
	public String toString() {
		return descricao + " - Banco: " + banco.getDescricao(); 
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
		Agencia other = (Agencia) obj;
		return id == other.id;
	}
	
}
