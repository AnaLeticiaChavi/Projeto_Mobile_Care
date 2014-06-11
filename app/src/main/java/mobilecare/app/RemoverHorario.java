package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class RemoverHorario extends Activity implements OnClickListener {

    private EditText txtTituloExc, txtDataExc,txtHoraExc,txtPeriodoExc,txtNomeMedicamentoExc, txtNomeMedPesqExcHor;
    private Button btnPesquisaNomeMedExcHor, btnExcHor;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_horario);

        txtNomeMedPesqExcHor = (EditText)findViewById(R.id.txtPesNomeMedExcluir);
        txtTituloExc = (EditText)findViewById(R.id.txtTituloExcluir);
        txtDataExc = (EditText)findViewById(R.id.txtDataExcluir);
        txtHoraExc = (EditText)findViewById(R.id.txtHoraExcluir);
        txtPeriodoExc = (EditText)findViewById(R.id.txtPeriodoExcluir);
        txtNomeMedicamentoExc = (EditText)findViewById(R.id.txtNomeMedExc);


        btnPesquisaNomeMedExcHor = (Button)findViewById(R.id.btnPesqNomeMedExcluir);
        btnPesquisaNomeMedExcHor.setOnClickListener(this);
        btnExcHor = (Button)findViewById(R.id.btnRemoverHor);
        btnExcHor.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {

        int verifica ;
        OperacoesBD BD = new OperacoesBD();
        ArrayList<String> saidaPesq = new ArrayList();

        if(arg0.getId() == btnPesquisaNomeMedExcHor.getId()){

            saidaPesq = BD.PesquisarHorario_Atualizar(txtNomeMedPesqExcHor.getText().toString());

            txtTituloExc.setText(saidaPesq.get(1));
            txtDataExc.setText(saidaPesq.get(2));
            txtHoraExc.setText(saidaPesq.get(3));
            txtPeriodoExc.setText(saidaPesq.get(4));
            txtNomeMedicamentoExc.setText(saidaPesq.get(6));
            codigo = saidaPesq.get(0);


        }else if(arg0.getId() == btnExcHor.getId()){

            verifica = BD.RemoverHorario(codigo);

            if(verifica == 1){
                new AlertDialog.Builder(this)
                        .setMessage("Horario Removido com sucesso")
                        .show();
            }
            else{
                new AlertDialog.Builder(this)
                        .setMessage("Falha na remoção do horário")
                        .show();
            }

        }

    }

}
