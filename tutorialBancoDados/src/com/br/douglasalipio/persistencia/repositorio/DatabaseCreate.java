package com.br.douglasalipio.persistencia.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 
 * Cria o modelo do banco de dados.
 * 
 * @author Douglas
 * 
 */
public class DatabaseCreate {

	private SQLiteDatabase database;

	private SQLiteHelper sqlHelperDroidFoot;

	private SQLiteHelper sqlHelperTutorialDb;

	/**
	 * versão banco de produção.
	 */
	public static final int TUTORIAL_DB_VERSION = 1;

	/**
	 * nome banco de cache.
	 */
	public static final String TUTORIAL_DB = "tutorialdb.db";

	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {

	"CREATE TABLE carro (" + "id_carro INTEGER PRIMARY KEY,"
			+ "nome_carro VARCHAR NOT NULL,"
			+ "modelo_carro VARCHAR UNSIGNED NULL,"
			+ "placa_carro VARCHAR UNSIGNED NULL); " };

	public DatabaseCreate(Context context) {

		// cria o esquema e popula a base de dados de cache.
		sqlHelperTutorialDb = new SQLiteHelper(context, TUTORIAL_DB,
				TUTORIAL_DB_VERSION, SCRIPT_DATABASE_CREATE,
				ScriptInsert.insertTutorialDb);

		// cria a base de dados de produção
		database = context.openOrCreateDatabase(TUTORIAL_DB,
				Context.MODE_PRIVATE, null);

		// deixa a base de dados de produção em modo de leitura.
		database = sqlHelperTutorialDb.getWritableDatabase();

	}

	/**
	 * fecha conexÃ£o.
	 */
	public void closed() {
		if (sqlHelperDroidFoot != null) {
			sqlHelperDroidFoot.close();
			database.close();
		}
	}
}
