package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class RemoverMedicamento extends Activity implements OnClickListener {

    private EditText txtNomeRemoverMedicamento;
    private EditText txtNomeREMOVER, txtDosagemREMOVER,txtDataIniREMOVER,txtDataFimREMOVER,txtTarjaREMOVER,txtObsREMOVER,txtPesqNomeREMOVER;
    private Button btnREMOVERMed;
    private Button btnRemoveMedPesq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_medicamento);


        txtNomeRemoverMedicamento = (EditText)findViewById(R.id.txtNomeRemoveMed);
        btnRemoveMedPesq = (Button)findViewById(R.id.btnRemoveMedBD);
        btnRemoveMedPesq.setOnClickListener(this);


        txtNomeREMOVER = (EditText)findViewById(R.id.txtNomeMedREM);
        txtDosagemREMOVER = (EditText)findViewById(R.id.txtDosagemMedREM);
        txtDataIniREMOVER = (EditText)findViewById(R.id.txtDataIniMedREM);
        txtDataFimREMOVER = (EditText)findViewById(R.id.txtDataFimMedREM);
        txtTarjaREMOVER = (EditText)findViewById(R.id.txtTarjaMedREM);
        txtObsREMOVER = (EditText)findViewById(R.id.txtObsMedREM);



        btnREMOVERMed = (Button)findViewById(R.id.btnREMMed);
        btnREMOVERMed.setOnClickListener(this);



    }
    @Override
    public void onClick(View arg0) {
        int verifica ;
        OperacoesBD BD = new OperacoesBD();
        ArrayList<String> saidaPesq;

        if(arg0.getId() == btnRemoveMedPesq.getId()){

            saidaPesq = BD.PesquisarMedicamento_Atualizar(txtNomeRemoverMedicamento.getText().toString());

            txtNomeREMOVER.setText(saidaPesq.get(1));
            txtDosagemREMOVER.setText(saidaPesq.get(2));
            txtDataIniREMOVER.setText(saidaPesq.get(4));
            txtDataFimREMOVER.setText(saidaPesq.get(5));
            txtTarjaREMOVER.setText(saidaPesq.get(6));
            txtObsREMOVER.setText(saidaPesq.get(7));


        }else if(arg0.getId() == btnREMOVERMed.getId()){

            verifica = BD.RemoverMedicamento(txtNomeRemoverMedicamento.getText().toString());

            if(verifica == 1){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento Excluido com sucesso")
                        .show();
            }
            else{
                new AlertDialog.Builder(this)
                        .setMessage("Falha na exclusão do medicamento")
                        .show();
            }

        }


    }




}
