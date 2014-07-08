package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class AtualizarEstoque extends Activity implements OnClickListener {

    private EditText txtDataCompraAt, txtQtdAt,txtDataValidadeAt,txtNomeMedAtEst,txtNomeMedPesqAtEst;
    private Button btnPesquisaNomeMedAtEst, btnAtEst;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_estoque);

        txtNomeMedPesqAtEst = (EditText)findViewById(R.id.txtNomeMedAtualizarEstoque);
        txtDataCompraAt = (EditText)findViewById(R.id.txtDataCompraAtualiza);
        txtQtdAt = (EditText)findViewById(R.id.txtQtdAtualiza);
        txtDataValidadeAt = (EditText)findViewById(R.id.txtDataValAtualiza);
        txtNomeMedAtEst = (EditText)findViewById(R.id.txtMedAtualizaEst);

        btnPesquisaNomeMedAtEst = (Button)findViewById(R.id.btnAtualizacaoEstoque);
        btnPesquisaNomeMedAtEst.setOnClickListener(this);
        btnAtEst = (Button)findViewById(R.id.btnAtualizaEstBD);
        btnAtEst.setOnClickListener(this);
    }


    @Override
    public void onClick(View arg0) {
        int verifica ;
        OperacoesBD BD = new OperacoesBD();

        ArrayList<String> saidaPesq;

        if(arg0.getId() == btnPesquisaNomeMedAtEst.getId()){

            try {
                saidaPesq = BD.PesquisarEstoque_Atualizar(txtNomeMedPesqAtEst.getText().toString());

                codigo = saidaPesq.get(0);
                txtDataCompraAt.setText(saidaPesq.get(1));
                txtQtdAt.setText(saidaPesq.get(2));
                txtDataValidadeAt.setText(saidaPesq.get(3));
                txtNomeMedAtEst.setText(saidaPesq.get(4));

            }
            catch(Exception e){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento não existente no estoque")
                        .show();
            }
        }else if(arg0.getId() == btnAtEst.getId()){

            verifica = BD.AtualizarEstoque(codigo,txtDataCompraAt.getText().toString(), Integer.parseInt(txtQtdAt.getText().toString()), txtDataValidadeAt.getText().toString(), txtNomeMedAtEst.getText().toString());

            if(verifica == 1){
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento atualizado no estoque com sucesso")
                        .show();
            }
            else{
                new AlertDialog.Builder(this)
                        .setMessage("Falha na atualização do medicamento no estoque")
                        .show();
            }

        }

    }
}
