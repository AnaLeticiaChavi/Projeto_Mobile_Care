package mobilecare.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MedicamentoxMes extends Activity implements OnClickListener {

    EditText txtMesDesejado,txtRel,txtAnoDesejado;
    Button btnOKRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentox_mes);

        txtRel = (EditText)findViewById(R.id.txtRelatorioTotal);
        txtMesDesejado = (EditText)findViewById(R.id.txtMesLimitePesqRelatorio);
        txtAnoDesejado = (EditText)findViewById(R.id.txtAnoLimitePesqRelatorio);
        btnOKRel = (Button)findViewById(R.id.btnOkMesLimite);
        btnOKRel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        OperacoesBD BD = new OperacoesBD();
        String saidaRel;

        if(view.getId() == btnOKRel.getId()){
            saidaRel = BD.relatorioMedicamentoxMes(txtMesDesejado.getText().toString(),txtAnoDesejado.getText().toString());
            txtRel.setText(saidaRel);
        }
    }
}
