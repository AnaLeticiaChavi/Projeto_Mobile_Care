package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CadastroMedicamento extends Activity implements OnClickListener {

    private Button btnCadastroMedicamento;

    private EditText txtNome, txtDosagem,txtDataIniBD,txtDataFimBD,txtTarjaBD,txtObsBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medicamento);
        txtNome = (EditText)findViewById(R.id.txtNomeMedicamento);
        txtDosagem = (EditText)findViewById(R.id.txtDosagemMedicamento);
        txtDataIniBD = (EditText)findViewById(R.id.txtDataIni);
        txtDataFimBD = (EditText)findViewById(R.id.txtDataFim);
        txtTarjaBD = (EditText)findViewById(R.id.txtTarja);
        txtObsBD = (EditText)findViewById(R.id.txtObs);


        btnCadastroMedicamento = (Button)findViewById(R.id.btnCadMedBD);
        btnCadastroMedicamento.setOnClickListener(this);


    }

    @Override
    public void onClick(View arg0) {
        int verifica;
        OperacoesBD BD = new OperacoesBD();

        if(arg0.getId() == btnCadastroMedicamento.getId()){

            verifica = BD.InserirMedicamento(txtNome.getText().toString(), Double.parseDouble(txtDosagem.getText().toString()), 1, txtDataIniBD.getText().toString(), txtDataFimBD.getText().toString(), txtTarjaBD.getText().toString(), txtObsBD.getText().toString());

            if(verifica == 1){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento Cadastrado com sucesso")
                        .show();
            }
            else{
                new AlertDialog.Builder(this)
                        .setMessage("Falha no cadastro do medicamento")
                        .show();
            }
        }

    }

}
