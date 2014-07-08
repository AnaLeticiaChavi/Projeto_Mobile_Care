package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class AtualizarMedicamento extends Activity implements OnClickListener {

    private EditText txtNomeAt, txtDosagemAt,txtDataIniAt,txtDataFimAt,txtTarjaAt,txtObsAt,txtPesqNomeAt;
    private Button btnPesquisaNomeAt, btnAtMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_medicamento);
        txtPesqNomeAt = (EditText)findViewById(R.id.txtNomeAtualizaMedicamento);
        txtNomeAt = (EditText)findViewById(R.id.txtNomeAtualiza);
        txtDosagemAt = (EditText)findViewById(R.id.txtDosagemAtualiza);
        txtDataIniAt = (EditText)findViewById(R.id.txtDataIniAtualiza);
        txtDataFimAt = (EditText)findViewById(R.id.txtDataFimAtualiza);
        txtTarjaAt = (EditText)findViewById(R.id.txtTarjaAtualiza);
        txtObsAt = (EditText)findViewById(R.id.txtObsAtualiza);


        btnPesquisaNomeAt = (Button)findViewById(R.id.btnAtualizacaoMedicamento);
        btnPesquisaNomeAt.setOnClickListener(this);
        btnAtMed = (Button)findViewById(R.id.btnAtualizaMedBD);
        btnAtMed.setOnClickListener(this);

    }
    @Override
    public void onClick(View arg0) {
        int verifica ;
        OperacoesBD BD = new OperacoesBD();
        ArrayList<String> saidaPesq = new ArrayList();

        if(arg0.getId() == btnPesquisaNomeAt.getId()){

            saidaPesq = BD.PesquisarMedicamento_Atualizar(txtPesqNomeAt.getText().toString());

            txtNomeAt.setText(saidaPesq.get(1));
            txtDosagemAt.setText(saidaPesq.get(2));
            txtDataIniAt.setText(saidaPesq.get(4));
            txtDataFimAt.setText(saidaPesq.get(5));
            txtTarjaAt.setText(saidaPesq.get(6));
            txtObsAt.setText(saidaPesq.get(7));


        }else if(arg0.getId() == btnAtMed.getId()){

            verifica = BD.AtualizarMedicamento(txtNomeAt.getText().toString(), Double.parseDouble(txtDosagemAt.getText().toString()), txtDataIniAt.getText().toString(), txtDataFimAt.getText().toString(), txtTarjaAt.getText().toString(), txtObsAt.getText().toString());

            if(verifica == 1){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento Atualizado com sucesso")
                        .show();
            }
            else{
                new AlertDialog.Builder(this)
                        .setMessage("Falha na atualização do medicamento")
                        .show();
            }

        }

    }



}
