package com.br.douglasalipio.persistencia;

import com.br.douglasalipio.negocio.entidade.Carro;
import com.br.douglasalipio.persistencia.repositorio.CarroModelDB;
import com.br.douglasalipio.persistencia.repositorio.DatabaseCreate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 
 * @author douglas
 * 
 */
public class CarroPersistencia {

	private Context context;
	private static CarroPersistencia instance;
	private static SQLiteDatabase db;

	public static CarroPersistencia getInstance(Context context) {
		if (instance == null) {
			synchronized (CarroPersistencia.class) {

				if (instance == null) {

					instance = new CarroPersistencia(context);

					db = context.openOrCreateDatabase(
							DatabaseCreate.TUTORIAL_DB, Context.MODE_PRIVATE,
							null);
				}
			}
		}
		return instance;
	}

	private CarroPersistencia(Context context) {

		this.context = context;

	}

	/**
	 * Persiste informações de carro.
	 * 
	 * @param carro
	 */
	public void inserirCarro(Carro carro) {

		ContentValues value = new ContentValues();
		value.put(CarroModelDB.NOME_CARRO, carro.getNome());
		value.put(CarroModelDB.PLACA_CARRO, carro.getPlaca());
		value.put(CarroModelDB.MODELO_CARRO, carro.getModelo());
		db.insertOrThrow(CarroModelDB.CARRO, "", value);

	}

	/**
	 * Atualiza um carro.
	 * 
	 * @param carro
	 */
	public void atualizarCarro(Carro carro) {

		Long idCarro = carro.getId();
		ContentValues values = new ContentValues();
		String[] whereArgs = new String[] { idCarro.toString() };
		String where = CarroModelDB.ID_CARRO + "=?";

		values.put(CarroModelDB.MODELO_CARRO, carro.getModelo());
		values.put(CarroModelDB.NOME_CARRO, carro.getNome());
		values.put(CarroModelDB.PLACA_CARRO, carro.getPlaca());
		db.update(CarroModelDB.CARRO, values, where, whereArgs);

	}

	/**
	 * Deleta um carro
	 * 
	 * @param idCarro
	 */
	public void deletarCarro(String nomeCarro) {

		db.delete(CarroModelDB.CARRO,
				CarroModelDB.NOME_CARRO + "=" + "'"+nomeCarro+"'", null);

	}

	/**
	 * Busca e recupera o carro pesquisado.
	 * 
	 * @param nomeCarro
	 * @return
	 */

	public Carro buscarCarro(String nomeCarro) {

		Cursor cursor = db.query(CarroModelDB.CARRO, CarroModelDB.COLUNAS,
				CarroModelDB.NOME_CARRO + "='" + nomeCarro + "'", null, null,
				null, null);

		Carro carro = new Carro();

		if (cursor.moveToFirst()) {

			carro.setId(cursor.getInt(cursor
					.getColumnIndexOrThrow(CarroModelDB.ID_CARRO)));

			carro.setNome(cursor.getString(cursor
					.getColumnIndexOrThrow(CarroModelDB.NOME_CARRO)));

			carro.setModelo(cursor.getString(cursor
					.getColumnIndexOrThrow(CarroModelDB.MODELO_CARRO)));

			carro.setPlaca(cursor.getString(cursor
					.getColumnIndexOrThrow(CarroModelDB.PLACA_CARRO)));

		}

		return carro;
	}

}
