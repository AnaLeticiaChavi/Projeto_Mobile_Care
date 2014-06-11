package mobilecare.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;

public class OperacoesBD {


    public int CadastrarHorario(String tituloBD, String dataBD, String horaBD, int periodoBD, String nomeMedBD) {

        int i = 0, codMed = 0;

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", tituloBD);
        contentValues.put("data", dataBD);
        contentValues.put("hora", horaBD);
        contentValues.put("periodo", periodoBD);

        try {
            Cursor dadoMed = MainActivity.database.rawQuery("select codMed from Medicamento where nome = ? and status = ?", new String[]{nomeMedBD, "1"});
            if (dadoMed.moveToFirst()) {
                codMed = dadoMed.getInt(0);
                contentValues.put("codMed", codMed);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Medicamento não existe no sistema");
        }


        if (contentValues == null) {
            throw new IllegalArgumentException("Os parametros não podem ser vazios");
        }

        try {
            MainActivity.database.insert("Horario", null, contentValues);
            return 1;
        } catch (SQLException e) {
            return 0;
        }


    }

    public String PesquisarHorario(String nomeMed){

        String saida = null;

        try{
            Cursor dadosHorarios = MainActivity.database.rawQuery("select * from Horario h inner join Medicamento m on h.codMed = m.codMed where m.nome = ?", new String[]{nomeMed} );
            if(dadosHorarios.moveToFirst()){
                saida = "Titulo: "+ dadosHorarios.getString(1) + "\n" +
                        "Data: " + dadosHorarios.getString(2) + "\n"+
                        "Hora: " + dadosHorarios.getString(3) + "\n" +
                        "Periodo: " + dadosHorarios.getInt(4) + "\n";
            }
            return saida;
        }
        catch(SQLException e){
            return null;
        }
    }

}
