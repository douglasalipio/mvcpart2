package com.br.douglasalipio.negocio.model;

import com.br.douglasalipio.R;
import com.br.douglasalipio.exception.CampoObrigatorioCarroException;
import com.br.douglasalipio.exception.GenericoException;
import com.br.douglasalipio.exception.IdInvalidoException;
import com.br.douglasalipio.negocio.entidade.Carro;
import com.br.douglasalipio.persistencia.CarroPersistencia;

import android.content.Context;

/**
 * 
 * @author douglas
 * 
 */
public class CarroModel {

	private Context context;
	private CarroPersistencia carroPersistencia;

	public CarroModel(Context context) {

		this.context = context;
	}

	public void tratarInsercaoCarro(Carro carro) throws CampoObrigatorioCarroException {

		if (carro.getNome() == null) {

			throw new CampoObrigatorioCarroException(R.string.nomeObrigatorio);

		} else {

			carroPersistencia = CarroPersistencia.getInstance(context);
			carroPersistencia.inserirCarro(carro);

		}

	}

	public Carro managerBuscaCarro(String nomeCarro) throws IdInvalidoException {

		if (nomeCarro != null) {

			carroPersistencia = CarroPersistencia.getInstance(context);
			return carroPersistencia.buscarCarro(nomeCarro);

		} else {

			throw new IdInvalidoException("Id inv�lido");
		}

	}

	public void managerAtualizacaoCarro(Carro carro) throws GenericoException {

		if (carro != null) {

			carroPersistencia = CarroPersistencia.getInstance(context);
			carroPersistencia.atualizarCarro(carro);

		} else {

			throw new GenericoException();
		}
	}

	public void managerExclusaoCarro(String nomeCarro) throws GenericoException {

		if (nomeCarro != null) {
			carroPersistencia = CarroPersistencia.getInstance(context);
			carroPersistencia.deletarCarro(nomeCarro);

		} else {

			throw new GenericoException();
		}
	}

}
