package com.br.douglasalipio.persistencia.repositorio;

/**
 * 
 * @author douglas
 * 
 */
public class CarroModelDB {
	/**
	 * Nome da tabela.
	 */
	public static final String CARRO = "carro";

	/**
	 * coluna 1
	 */
	public static final String ID_CARRO = "id_carro";

	/**
	 * coluna 2
	 */
	public static final String NOME_CARRO = "nome_carro";

	/**
	 * coluna 3
	 */
	public static final String PLACA_CARRO = "placa_carro";

	/**
	 * coluna 3
	 */
	public static final String MODELO_CARRO = "modelo_carro";

	/**
	 * Colunas da tabela.
	 */
	public static final String[] COLUNAS = { ID_CARRO, NOME_CARRO, PLACA_CARRO,
			MODELO_CARRO };
}
