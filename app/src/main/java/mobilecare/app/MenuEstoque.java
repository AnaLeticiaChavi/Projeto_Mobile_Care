package mobilecare.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuEstoque extends Activity implements OnClickListener {

    private Button btnCadEstoqueBD;
    private Button btnPesqEstoqueBD;
    private Button btnRemEstoqueBD;
    private Button btnAtEstoqueBD;

    private Intent mudarTelaCadastroEst;
    private Intent mudarTelaPesquisaEst;
    private Intent mudarTelaRemoverEst;
    private Intent mudarTelaAlterarEst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_estoque);


        btnCadEstoqueBD = (Button)findViewById(R.id.btnCadastrarEstoque);
        btnCadEstoqueBD.setOnClickListener(this);
        btnPesqEstoqueBD = (Button)findViewById(R.id.btnPesquisarEstoque);
        btnPesqEstoqueBD.setOnClickListener(this);
        btnRemEstoqueBD = (Button)findViewById(R.id.btnRemoverEstoque);
        btnRemEstoqueBD.setOnClickListener(this);
        btnAtEstoqueBD = (Button)findViewById(R.id.btnAtualizarEstoque);
        btnAtEstoqueBD.setOnClickListener(this);

        mudarTelaCadastroEst = new Intent(this, CadastrarEstoque.class);
        mudarTelaPesquisaEst = new Intent(this, PesquisarEstoque.class);
        mudarTelaRemoverEst = new Intent(this,RemoverEstoque.class);
        mudarTelaAlterarEst = new Intent(this,AtualizarEstoque.class);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == btnCadEstoqueBD.getId()) {
            startActivity(mudarTelaCadastroEst);
        }
        else  if (view.getId() == btnPesqEstoqueBD.getId()) {
            startActivity(mudarTelaPesquisaEst);
        }
        else  if (view.getId() == btnAtEstoqueBD.getId()) {
            startActivity(mudarTelaAlterarEst);
        }
        else  if (view.getId() == btnRemEstoqueBD.getId()) {
            startActivity(mudarTelaRemoverEst);
        }

    }
}
