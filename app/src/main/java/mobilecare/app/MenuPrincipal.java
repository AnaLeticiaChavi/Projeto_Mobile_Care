package mobilecare.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuPrincipal extends Activity implements OnClickListener {

    private Button btnManterMedicamento, btnManterHorario, btnManterEstoque, btnRelMxM,btnRelDxM;
    private Intent mudarTelaMedicamento, mudarTelaHorario, mudarTelaEstoque, mudarTelaMxM,mudarTelaDxM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        btnManterMedicamento = (Button) findViewById(R.id.btnMedicamento);
        btnManterMedicamento.setOnClickListener(this);

        btnManterHorario = (Button) findViewById(R.id.btnHorario);
        btnManterHorario.setOnClickListener(this);

        btnManterEstoque = (Button) findViewById(R.id.btnEstoque);
        btnManterEstoque.setOnClickListener(this);

        btnRelMxM = (Button)findViewById(R.id.btnRelatorioMxM);
        btnRelMxM.setOnClickListener(this);

        btnRelDxM = (Button)findViewById(R.id.btnRelatorioDxM);
        btnRelDxM.setOnClickListener(this);

                mudarTelaMedicamento = new Intent(this, MenuMedicamento.class);
        mudarTelaHorario = new Intent(this, MenuHorario.class);
        mudarTelaEstoque = new Intent(this, MenuEstoque.class);
        mudarTelaMxM = new Intent(this,MedicamentoxMes.class);
        mudarTelaDxM = new Intent(this,DosagemxMes.class);

    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == btnManterMedicamento.getId()) {
            startActivity(mudarTelaMedicamento);
        }
        else  if (arg0.getId() == btnManterHorario.getId()) {
            startActivity(mudarTelaHorario);
        }
        else  if (arg0.getId() == btnManterEstoque.getId()) {
            startActivity(mudarTelaEstoque);
        }
        else if(arg0.getId() == btnRelMxM.getId()){
            startActivity(mudarTelaMxM);
        }
        else if(arg0.getId() == btnRelDxM.getId()){
            startActivity(mudarTelaDxM);
        }


    }
}
