package mobilecare.app;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;


public class MainActivity extends Activity {

    //Variáveis do Banco

    private String CAMINHO = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String BANCO = "mobilecareBD.db";
    public static SQLiteDatabase database;

    private Intent menuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando o banco de dados se ele ainda não existir
        System.out.println(CAMINHO + "/" + BANCO);
        database = this.openOrCreateDatabase(CAMINHO + "/" + BANCO, 0, null);

        //Criando as tabelas se elas ainda não existirem

        database.execSQL("create table if not exists Medicamento(codMed integer primary key autoincrement, nome text not null, dosagem real not null, status integer not null, dataIni text not null, dataFim text, tarja text not null, obs text);");
        database.execSQL("create table if not exists Horario(codHor integer primary key autoincrement, titulo text not null, data text not null, hora text not null, periodo integer not null,codMed integer not null, foreign key(codMed) references Medicamento(codMed));");
        database.execSQL("create table if not exists Estoque(codEst integer primary key autoincrement, dataCompra text not null, qtdCartela integer not null, dataValidade text not null,codMed integer not null,codHor integer not null, foreign key(codMed) references Medicamento(codMed), foreign key(codHor) references Horario(codHor));");

        menuPrincipal = new Intent(this, MenuPrincipal.class);



        startActivity(menuPrincipal);

    }


}




