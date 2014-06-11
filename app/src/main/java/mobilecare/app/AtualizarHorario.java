package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class AtualizarHorario extends Activity implements OnClickListener{

    private EditText txtTituloAt, txtDataAt,txtHoraAt,txtPeriodoAt,txtNomeMedicamentoAt, txtNomeMedPesqAtHor;
    private Button btnPesquisaNomeMedAtHor, btnAtHor;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_horario);

        txtNomeMedPesqAtHor = (EditText)findViewById(R.id.txtNomeMedAtualizarHorario);
        txtTituloAt = (EditText)findViewById(R.id.txtTituloAtualiza);
        txtDataAt = (EditText)findViewById(R.id.txtDataAtualizaHorario);
        txtHoraAt = (EditText)findViewById(R.id.txtHoraAtualiza);
        txtPeriodoAt = (EditText)findViewById(R.id.txtPeriodoAtualiza);
        txtNomeMedicamentoAt = (EditText)findViewById(R.id.txtMedAtualizaHor);


        btnPesquisaNomeMedAtHor = (Button)findViewById(R.id.btnAtualizacaoHorario);
        btnPesquisaNomeMedAtHor.setOnClickListener(this);
        btnAtHor = (Button)findViewById(R.id.btnAtualizaHorBD);
        btnAtHor.setOnClickListener(this);

    }


    @Override
    public void onClick(View arg0) {
        int verifica ;
        OperacoesBD BD = new OperacoesBD();
        ArrayList<String> saidaPesq = new ArrayList();

        if(arg0.getId() == btnPesquisaNomeMedAtHor.getId()){

            saidaPesq = BD.PesquisarHorario_Atualizar(txtNomeMedPesqAtHor.getText().toString());

            txtTituloAt.setText(saidaPesq.get(1));
            txtDataAt.setText(saidaPesq.get(2));
            txtHoraAt.setText(saidaPesq.get(3));
            txtPeriodoAt.setText(saidaPesq.get(4));
            txtNomeMedicamentoAt.setText(saidaPesq.get(6));
            codigo = saidaPesq.get(0);


        }else if(arg0.getId() == btnAtHor.getId()){

            verifica = BD.AtualizarHorario(codigo,txtTituloAt.getText().toString(), txtDataAt.getText().toString(), txtHoraAt.getText().toString(), Integer.parseInt(txtPeriodoAt.getText().toString()), txtNomeMedicamentoAt.getText().toString());

            if(verifica == 1){
                new AlertDialog.Builder(this)
                        .setMessage("Horario Atualizado com sucesso")
                        .show();
            }
            else{
                new AlertDialog.Builder(this)
                        .setMessage("Falha na atualização do horário")
                        .show();
            }

        }

    }


}
