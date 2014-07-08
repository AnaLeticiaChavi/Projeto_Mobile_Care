package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class PesquisarEstoque extends Activity implements OnClickListener {

    private EditText txtNomeMedEstPesq, txtSaidaDadosEstoque;
    private Button btnPesqMedNomeEst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_estoque);

        txtNomeMedEstPesq = (EditText) findViewById(R.id.txtPesquisaNomeMedEstoque);
        btnPesqMedNomeEst = (Button) findViewById(R.id.btnPesqNomeMedEstBD);
        btnPesqMedNomeEst.setOnClickListener(this);
        txtSaidaDadosEstoque = (EditText) findViewById(R.id.txtSaidaPesqEst);
    }


    @Override
    public void onClick(View view) {
        String saidaPesq = null;
        OperacoesBD BD = new OperacoesBD();

        if (view.getId() == btnPesqMedNomeEst.getId()) {

            saidaPesq = BD.PesquisarEstoque(txtNomeMedEstPesq.getText().toString());

            if (saidaPesq == null) {
                new AlertDialog.Builder(this)
                        .setMessage("Medicamento não cadastrado no estoque")
                        .show();
            } else {
                txtSaidaDadosEstoque.setText(saidaPesq);
            }

        }
    }
}
