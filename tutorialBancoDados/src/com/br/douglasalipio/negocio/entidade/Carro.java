package com.br.douglasalipio.negocio.entidade;

import java.io.Serializable;

public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private String placa;
	private String modelo;

	public Carro(long id, String nome, String placa, String modelo) {

		this.id = id;
		this.nome = nome;
		this.placa = placa;
		this.modelo = modelo;
	}

	public Carro(String nome, String placa, String modelo) {

		this.nome = nome;
		this.placa = placa;
		this.modelo = modelo;
	}

	public Carro() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


}
