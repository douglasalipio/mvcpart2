package com.br.douglasalipio.view.controlador;

import com.br.douglasalipio.R;
import com.br.douglasalipio.exception.CampoObrigatorioCarroException;
import com.br.douglasalipio.exception.GenericoException;
import com.br.douglasalipio.negocio.entidade.Carro;
import com.br.douglasalipio.negocio.model.CarroModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * www.douglasalipio.wordpress.com
 * 
 * @author douglas
 * 
 */
public class AtualizarCarroController extends Activity implements
		OnClickListener {

	private EditText nome;
	private EditText placa;
	private EditText modelo;
	private Carro carro = new Carro();
	private CarroModel carroModel;

	private Button atualizar;
	private Button buscar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.atualizar_view);

		carro = (Carro) getIntent().getSerializableExtra("carro");
		preencherCarro();
	}

	/**
	 * Inicializa os componentes.
	 */
	private void preencherCarro() {

		nome = (EditText) findViewById(R.idAtualizar.editNome);
		placa = (EditText) findViewById(R.idAtualizar.editPlaca);
		modelo = (EditText) findViewById(R.idAtualizar.editModelo);

		nome.setText(carro.getNome());
		placa.setText(carro.getPlaca());
		modelo.setText(carro.getModelo());

		atualizar = (Button) findViewById(R.idAtualizar.buttonAtualizar);
		buscar = (Button) findViewById(R.idAtualizar.buttonBuscar);

		atualizar.setOnClickListener(this);
		buscar.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.idAtualizar.buttonBuscar:

			break;

		case R.idAtualizar.buttonAtualizar:

			atualizarCarro();
			limparCampos();
			abriTelaHome();

			break;
		}

	}

	private void abriTelaHome() {

		Intent it = new Intent(this, MainController.class);
		startActivity(it);

	}

	/**
	 * Envia o objeto carro para ser validado.
	 * 
	 */
	private void atualizarCarro() {

		try {

			carroModel = new CarroModel(getApplicationContext());
			carroModel.managerAtualizacaoCarro(recuperarInformacaoCarro());

		} catch (GenericoException e) {
			Log.d("Categoria", "Ocorreu um problema, contate o suporte.");
		}

	}

	/**
	 * Limpa os campos da tela de Carro.
	 */
	private void limparCampos() {

		Toast.makeText(getApplication(), R.string.atualizadoComSucesso,
				Toast.LENGTH_LONG).show();

		nome.setText("");
		modelo.setText("");
		placa.setText("");

	}

	/**
	 * Recupera informa��es do carro e preenche o objeto.
	 * 
	 * @return
	 */
	private Carro recuperarInformacaoCarro() {

		carro.setModelo(modelo.getText().toString());
		carro.setNome(nome.getText().toString());
		carro.setPlaca(placa.getText().toString());

		return carro;

	}
}
