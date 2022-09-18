package br.ufrn.imd.domain;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Cliente extends Pessoa {
	
	private int id;
	private String conta;
	private String tipo;
	private Agencia agencia;
	private double saldo;
	private double fatura;
	private List <Transacao> transacoes;
	
	public Cliente() {
		transacoes = new ArrayList <Transacao>();
	}
	
	public Cliente(int id, String nome, String cpf, String conta, String tipo) {
		this.id = id;
		setNome(nome);
		setCpf(cpf);
		this.conta = conta;
		this.tipo = tipo;
		this.saldo = 0.0;
		this.fatura = 0.0;
		transacoes = new ArrayList <Transacao>();
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

	public double getFatura() {
		return fatura;
	}

	public void setFatura(double fatura) {
		this.fatura = fatura;
	}
	
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getNome() + " - Agencia: " + agencia;
	}
	
	public boolean transferencia(double quantia, Cliente destino) {
		if (quantia > 0.0 && destino != null) {
			
			Transacao t = new Transacao(this, destino, quantia, Transacao.Type.OUT);
			Transacao t2 = new Transacao(destino, this, quantia, Transacao.Type.IN);
			
			transacoes.add(t);
			destino.transacoes.add(t2);
			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean pagarFatura(double quantia) {
	
		if (saldo >= quantia && quantia > 0 && quantia <= fatura) {
			fatura -= quantia;
			
			return true;
		} else {
			return false;
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
		Cliente other = (Cliente) obj;
		return id == other.id;
	}
	
	
}
