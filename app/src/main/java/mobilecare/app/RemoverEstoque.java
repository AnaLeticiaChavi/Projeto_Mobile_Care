package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class RemoverEstoque extends Activity implements OnClickListener {

    private EditText txtDataCompraExc, txtQtdExc,txtDataValidadeExc,txtNomeMedExcEst,txtNomeMedPesqExcEst;
    private Button btnPesquisaNomeMedExcEst, btnExcEst;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_estoque);

        txtNomeMedPesqExcEst = (EditText)findViewById(R.id.txtNomeMedExcluirEstoque);
        txtDataCompraExc = (EditText)findViewById(R.id.txtDataCompraExcluir);
        txtQtdExc = (EditText)findViewById(R.id.txtQtdExcluir);
        txtDataValidadeExc = (EditText)findViewById(R.id.txtDataValExcluir);
        txtNomeMedExcEst = (EditText)findViewById(R.id.txtMedExcluirEst);

        btnPesquisaNomeMedExcEst = (Button)findViewById(R.id.btnExclusaoEstoque);
        btnPesquisaNomeMedExcEst.setOnClickListener(this);
        btnExcEst = (Button)findViewById(R.id.btnExcluiEstBD);
        btnExcEst.setOnClickListener(this);
    }


    @Override
    public void onClick(View arg0) {
        int verifica ;
        OperacoesBD BD = new OperacoesBD();

        ArrayList<String> saidaPesq;

        if(arg0.getId() == btnPesquisaNomeMedExcEst.getId()){

            try {
                saidaPesq = BD.PesquisarEstoque_Atualizar(txtNomeMedPesqExcEst.getText().toString());

                codigo = saidaPesq.get(0);
                txtDataCompraExc.setText(saidaPesq.get(1));
                txtQtdExc.setText(saidaPesq.get(2));
                txtDataValidadeExc.setText(saidaPesq.get(3));
                txtNomeMedExcEst.setText(saidaPesq.get(4));
            }
            catch(Exception e){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento não existente no estoque")
                        .show();
            }

        }else if(arg0.getId() == btnExcEst.getId()){

            verifica = BD.RemoverEstoque(codigo);
            if(verifica == 1){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento removido no estoque com sucesso")
                        .show();
            }
            else{
                new AlertDialog.Builder(this)
                        .setMessage("Falha na remoção do medicamento no estoque")
                        .show();
            }

        }

    }

}
