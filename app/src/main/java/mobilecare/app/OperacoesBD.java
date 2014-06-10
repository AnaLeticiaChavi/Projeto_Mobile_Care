package mobilecare.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;

public class OperacoesBD {

    public int InserirMedicamento(String nome, double dosagem, int status, String dataIni, String dataFim, String tarja, String obs){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("dosagem", dosagem);
        contentValues.put("status", status);
        contentValues.put("dataIni", dataIni);
        contentValues.put("dataFim", dataFim);
        contentValues.put("tarja", tarja);
        contentValues.put("obs", obs);


        if (contentValues == null) {
            throw new IllegalArgumentException("Os dados não podem estar vazio");
        }
        try {
            MainActivity.database.insert("Medicamento", null, contentValues);
            return 1;
        } catch (SQLException e) {
            return 0;

        }

    }

    public String PesquisarMedicamento(String nome) {

        String saida = null;
        try {
            Cursor dadosMedicamentos = MainActivity.database.rawQuery("select * from Medicamento where nome = ? and status = ?", new String[]{nome, "1"});
            if (dadosMedicamentos.moveToFirst()) {
                saida = "Nome: " + dadosMedicamentos.getString(1) + "\n" +
                        "Dosagem: " + dadosMedicamentos.getDouble(2) + "\n" +
                        "Data de inicio: " + dadosMedicamentos.getString(4) + "\n" +
                        "Data de fim: " + dadosMedicamentos.getString(5) + "\n" +
                        "Tarja: " + dadosMedicamentos.getString(6) + "\n" +
                        "Obs: " + dadosMedicamentos.getString(7);
            }
            return saida;
        } catch (SQLException e) {
            return null;
        }
    }

}
