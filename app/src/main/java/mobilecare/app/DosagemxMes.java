package mobilecare.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;


public class DosagemxMes extends Activity implements OnClickListener {

    EditText txtMesDesejadoDosagem,txtRelDosagem,txtAnoDesejadoDosagem;
    Button btnOKRelDosagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosagemx_mes);

        txtRelDosagem = (EditText)findViewById(R.id.txtRelatorioTotalDosagem);
        txtMesDesejadoDosagem = (EditText)findViewById(R.id.txtMesLimitePesqRelatorioDosagem);
        txtAnoDesejadoDosagem = (EditText)findViewById(R.id.txtAnoLimitePesqRelatorioDosagem);
        btnOKRelDosagem = (Button)findViewById(R.id.btnOkMesLimiteDosagem);
        btnOKRelDosagem.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        OperacoesBD BD = new OperacoesBD();
        double qtdDosagem;
        String saidaRel = "";

        if(view.getId() == btnOKRelDosagem.getId()){

                qtdDosagem = BD.relatorioDosagemxMes(txtMesDesejadoDosagem.getText().toString(),txtAnoDesejadoDosagem.getText().toString());
                saidaRel = txtMesDesejadoDosagem.getText().toString() + " / "+txtAnoDesejadoDosagem.getText().toString()+": " + qtdDosagem+ "\n";
                txtRelDosagem.setText(saidaRel);
            }

        }
    }


