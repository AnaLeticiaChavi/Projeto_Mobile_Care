package mobilecare.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MenuMedicamento extends Activity implements OnClickListener   {

    private Button btnCadMedicamentoBD;
    private Button btnPesqMedicamentoBD;
    private Button btnRemMedicamentoBD;
    private Button btnAtMedicamentoBD;

    private Intent mudarTelaCadastroMed;
    private Intent mudarTelaPesquisaMed;
    private Intent mudarTelaRemoverMed;
    private Intent mudarTelaAlterarMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medicamento);

        btnCadMedicamentoBD = (Button)findViewById(R.id.btnCadastrarMedicamento);
        btnCadMedicamentoBD.setOnClickListener(this);
        btnPesqMedicamentoBD = (Button)findViewById(R.id.btnPesquisarMedicamento);
        btnPesqMedicamentoBD.setOnClickListener(this);
        btnRemMedicamentoBD = (Button)findViewById(R.id.btnRemoverMedicamento);
        btnRemMedicamentoBD.setOnClickListener(this);
        btnAtMedicamentoBD = (Button)findViewById(R.id.btnAtualizarMedicamento);
        btnAtMedicamentoBD.setOnClickListener(this);

        mudarTelaCadastroMed = new Intent(this, CadastroMedicamento.class);
        mudarTelaPesquisaMed = new Intent(this, PesquisarMedicamento.class);
        mudarTelaRemoverMed = new Intent(this,RemoverMedicamento.class);
        mudarTelaAlterarMed = new Intent(this,AtualizarMedicamento.class);
    }


    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == btnCadMedicamentoBD.getId()){
            startActivity(mudarTelaCadastroMed);
        }
        else if(arg0.getId() == btnPesqMedicamentoBD.getId()){
            startActivity(mudarTelaPesquisaMed);
        }
        else if(arg0.getId() == btnRemMedicamentoBD.getId()){
            startActivity(mudarTelaRemoverMed);
        }
        else if(arg0.getId() == btnAtMedicamentoBD.getId()){
            startActivity(mudarTelaAlterarMed);
        }
    }
}
