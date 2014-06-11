package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class PesquisarHorario extends Activity implements OnClickListener {

    private EditText txtNomeMedHorPesq, txtSaidaDadosHorarios;
    private Button btnPesqMedNomeHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_horario);

        txtNomeMedHorPesq = (EditText)findViewById(R.id.txtPesquisaNomeMedHorario);
        btnPesqMedNomeHor = (Button)findViewById(R.id.btnPesqHorBD);
        btnPesqMedNomeHor.setOnClickListener(this);
        txtSaidaDadosHorarios = (EditText)findViewById(R.id.txtSaidaPesqHor);
    }


    @Override
    public void onClick(View view) {
        String saidaPesq = null;
        OperacoesBD BD = new OperacoesBD();

        if(view.getId() == btnPesqMedNomeHor.getId()){

            saidaPesq = BD.PesquisarHorario(txtNomeMedHorPesq.getText().toString());

            if(saidaPesq == null){
                new AlertDialog.Builder(this)
                        .setMessage("Horário Não existente no Banco de dados")
                        .show();
            }else{
                txtSaidaDadosHorarios.setText(saidaPesq);
            }

        }
    }
}
