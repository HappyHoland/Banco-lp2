package br.ufrn.imd.domain;

import java.util.List;
import java.util.Objects;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Cliente extends Pessoa {
	
	private int id;
	private String conta;
	private String senha;
	private Agencia agencia;
	private double saldo;
	
	public Cliente() {}
	
	public Cliente(int id, String nome, String cpf, String endereco, String conta, String senha) {
		super(nome, cpf, endereco);
		this.id = id;
		this.conta = conta;
		this.senha = senha;
		this.saldo = 0.0;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return getNome() + " - Agencia: " + agencia;
	}
	
	public Transacao transferencia(double quantia, Cliente destino) {
		
		if (quantia > 0.0 && quantia <= saldo && destino != null) {
			
			Transacao t = new Transacao(this, destino, quantia, LocalDate.now());	
			
			saldo -= quantia;
			destino.saldo += quantia;
			
			return t;
		} else {
			
			return null;
		}
	}
	
	public boolean sacar(double quantia) {
		if (saldo >= quantia && quantia > 0) {
			saldo -= quantia;
			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean depositar(double quantia) {
		if (quantia > 0) {
			saldo += quantia;
			
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return conta == other.conta;
	}
	
}
