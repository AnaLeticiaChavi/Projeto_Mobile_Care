package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;


public class CadastrarEstoque extends Activity implements OnClickListener {

    Button btnCadastrarEstoqueBD;
    EditText txtDataCompra,txtQtdCart,txtDataVal,txtNomeMedEst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_estoque);

        txtDataCompra = (EditText)findViewById(R.id.txtDataCompraCadEstoque);
        txtQtdCart = (EditText)findViewById(R.id.txtQtdCadestoque);
        txtDataVal = (EditText)findViewById(R.id.txtDataValidadeCadEstoque);
        txtNomeMedEst = (EditText)findViewById(R.id.txtNomeMedCadEstoque);

        btnCadastrarEstoqueBD = (Button)findViewById(R.id.btnCadEstoque);
        btnCadastrarEstoqueBD.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int verifica,qtdCart = Integer.parseInt(txtQtdCart.getText().toString());
        OperacoesBD BD = new OperacoesBD();
        double dosagem;
        Date dataAlarme;
        ArrayList dadosMedicamentos;
        if (view.getId() == btnCadastrarEstoqueBD.getId()) {

            try {
                verifica = BD.CadastrarEstoque(txtDataCompra.getText().toString(), Integer.parseInt(txtQtdCart.getText().toString()), txtDataVal.getText().toString(), txtNomeMedEst.getText().toString());
                dadosMedicamentos = BD.PesquisarMedicamento_Atualizar(txtNomeMedEst.getText().toString());
                dosagem = Double.parseDouble(dadosMedicamentos.get(1).toString());

                for(int i = 0; qtdCart<Integer.parseInt(txtQtdCart.getText().toString())/2;i++){
                    qtdCart -= dosagem;
                }


                if (verifica == 1) {
                    new AlertDialog.Builder(this)
                            .setMessage("Medicamento Cadastrado no estoque com sucesso")
                            .show();
                } else {
                    new AlertDialog.Builder(this)
                            .setMessage("Falha no cadastro do medicamento no estoque")
                            .show();
                }
            } catch (Exception e) {
                new AlertDialog.Builder(this)
                        .setMessage(e.getMessage())
                        .show();
            }

        }
    }
}
