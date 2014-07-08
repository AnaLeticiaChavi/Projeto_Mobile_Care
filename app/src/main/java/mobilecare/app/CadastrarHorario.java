package mobilecare.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class CadastrarHorario extends Activity implements OnClickListener {

    private Button btnCadHor;
    private EditText txtCadTituloHor,txtCadDataHor,txtCadHoraHor,txtCadPeriodoHor,txtCadMedHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_horario);

        txtCadTituloHor = (EditText)findViewById(R.id.txtTituloCadHorario);
        txtCadDataHor = (EditText)findViewById(R.id.txtDataCadHorario);
        txtCadHoraHor = (EditText)findViewById(R.id.txtHoraCadHorario);
        txtCadPeriodoHor = (EditText)findViewById(R.id.txtPeriodoCadHorario);
        txtCadMedHor = (EditText)findViewById(R.id.txtNomeMedCadHorario);

        btnCadHor = (Button)findViewById(R.id.btnCadastrarHorario);
        btnCadHor.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int verifica;
        OperacoesBD BD = new OperacoesBD();

        if(view.getId() == btnCadHor.getId()){

            try {
            verifica =  BD.CadastrarHorario(txtCadTituloHor.getText().toString(),txtCadDataHor.getText().toString(),txtCadHoraHor.getText().toString(),Integer.parseInt(txtCadPeriodoHor.getText().toString()),txtCadMedHor.getText().toString());
               if(verifica == 1){
                    new AlertDialog.Builder(this)
                            .setMessage("Horário Cadastrado com sucesso")
                            .show();

                    for(int j = 0; j<3; j++) {
                        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                        if(j==0){
                            i.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(txtCadHoraHor.getText().toString().substring(0,2)));
                        }
                        else{
                            i.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(txtCadHoraHor.getText().toString().substring(0,2)) + Integer.parseInt("0"+txtCadPeriodoHor.getText().toString()));
                        }
                        i.putExtra(AlarmClock.EXTRA_MINUTES, (Integer.parseInt(txtCadHoraHor.getText().toString().substring(3,5))));
                        i.putExtra(AlarmClock.EXTRA_MESSAGE, txtCadTituloHor.getText().toString());
                        startActivity(i);
                    }

                }
                else{
                    new AlertDialog.Builder(this)
                            .setMessage("Falha no cadastro do horario")
                            .show();
                }
            }
            catch(Exception e){
                new AlertDialog.Builder(this)
                        .setMessage(e.getMessage())
                        .show();
            }

        }

    }


}

