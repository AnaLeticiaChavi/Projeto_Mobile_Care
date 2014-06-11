package mobilecare.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MenuHorario extends Activity implements OnClickListener {

    private Button btnCadHorarioBD;
    private Button btnPesqHorarioBD;
    private Button btnRemHorarioBD;
    private Button btnAtHorarioBD;

    private Intent mudarTelaCadastroHor;
    private Intent mudarTelaPesquisaHor;
    private Intent mudarTelaRemoverHor;
    private Intent mudarTelaAlterarHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_horario);

        btnCadHorarioBD = (Button)findViewById(R.id.btnCadastrarHorario);
        btnCadHorarioBD.setOnClickListener(this);
        btnPesqHorarioBD = (Button)findViewById(R.id.btnPesquisarHorario);
        btnPesqHorarioBD.setOnClickListener(this);
        btnRemHorarioBD = (Button)findViewById(R.id.btnRemoverHorario);
        btnRemHorarioBD.setOnClickListener(this);
        btnAtHorarioBD = (Button)findViewById(R.id.btnAtualizarHorario);
        btnAtHorarioBD.setOnClickListener(this);

        mudarTelaCadastroHor = new Intent(this, CadastrarHorario.class);
        mudarTelaPesquisaHor = new Intent(this, PesquisarHorario.class);

    }


    @Override
    public void onClick(View view) {
        if(view.getId() == btnCadHorarioBD.getId()){
            startActivity(mudarTelaCadastroHor);
        }
        else if(view.getId() == btnPesqHorarioBD.getId()){
            startActivity(mudarTelaPesquisaHor);
        }
        else if(view.getId() == btnAtHorarioBD.getId()){
            startActivity(mudarTelaAlterarHor);
        }
        else if(view.getId() == btnRemHorarioBD.getId()){
            startActivity(mudarTelaRemoverHor);
        }
    }
}
