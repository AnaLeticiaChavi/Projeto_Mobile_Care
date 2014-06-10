package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class PesquisarMedicamento extends Activity implements OnClickListener {

    private EditText txtNomeMedPesq, txtSaidaDadosMedicamentos;
    private Button btnPesqNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_medicamento);

        txtNomeMedPesq = (EditText)findViewById(R.id.txtPesquisaNomeMedicamento);
        btnPesqNome = (Button)findViewById(R.id.btnPesqMedBD);
        btnPesqNome.setOnClickListener(this);
        txtSaidaDadosMedicamentos = (EditText)findViewById(R.id.txtSaidaPesqMed);
    }

    @Override
    public void onClick(View v) {
        String saidaPesq = null;
        OperacoesBD BD = new OperacoesBD();

        if(v.getId() == btnPesqNome.getId()){

            saidaPesq = BD.PesquisarMedicamento(txtNomeMedPesq.getText().toString());

            if(saidaPesq == null){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento Não existente no Banco de dados")
                        .show();
            }else{
                txtSaidaDadosMedicamentos.setText(saidaPesq);
            }

        }

    }




}
