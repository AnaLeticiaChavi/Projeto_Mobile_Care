package mobilecare.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;

import java.util.ArrayList;

public class OperacoesBD {

    String DataInicialDeUso;

    public int InserirMedicamento(String nome, double dosagem, int status, String dataIni, String dataFim, String tarja, String obs) {


        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("dosagem", dosagem);
        contentValues.put("status", status);
        contentValues.put("dataIni", dataIni);
        contentValues.put("dataFim", dataFim);
        contentValues.put("tarja", tarja);
        contentValues.put("obs", obs);

        Cursor dadoData = MainActivity.database.rawQuery("select * from Medicamento",null);
        dadoData.moveToFirst();
        if(dadoData == null){
            DataInicialDeUso = dataIni;
        }

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

    public int RemoverMedicamento(String nome) {
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("status", "0");
            MainActivity.database.update("Medicamento", contentValues, " nome = ? and status = ?",
                    new String[]{nome, "1"});

            return 1;
        } catch (SQLException e) {

            return 0;
        }
    }

    public ArrayList<String> PesquisarMedicamento_Atualizar(String nome) {

        ArrayList<String> saida = new ArrayList();
        try {
            Cursor dadosMedicamentos = MainActivity.database.rawQuery("select * from Medicamento where nome = ? and status = ?", new String[]{nome, "1"});
            if (dadosMedicamentos.moveToFirst()) {
                saida.add(dadosMedicamentos.getString(0));
                saida.add(dadosMedicamentos.getString(1));
                saida.add(dadosMedicamentos.getString(2));
                saida.add(dadosMedicamentos.getString(3));
                saida.add(dadosMedicamentos.getString(4));
                saida.add(dadosMedicamentos.getString(5));
                saida.add(dadosMedicamentos.getString(6));
                saida.add(dadosMedicamentos.getString(7));
            }
            return saida;
        } catch (SQLException e) {
            return null;
        }
    }

    public int AtualizarMedicamento(String nome, Double dosagem, String dataIni, String dataFim, String tarja, String obs) {

        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("nome", nome);
            contentValues.put("dosagem", dosagem);
            contentValues.put("dataIni", dataIni);
            contentValues.put("dataFim", dataFim);
            contentValues.put("tarja", tarja);
            contentValues.put("obs", obs);
            MainActivity.database.update("Medicamento", contentValues, " nome = ? and status = ?",
                    new String[]{nome, "1"});

            return 1;
        } catch (SQLException e) {

            return 0;
        }
    }

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

    public String PesquisarHorario(String nomeMed) {

        String saida = null;

        try {
            Cursor dadosHorarios = MainActivity.database.rawQuery("select * from Horario h inner join Medicamento m on h.codMed = m.codMed where m.nome = ?", new String[]{nomeMed});
            if (dadosHorarios.moveToFirst()) {
                saida = "Titulo: " + dadosHorarios.getString(1) + "\n" +
                        "Data: " + dadosHorarios.getString(2) + "\n" +
                        "Hora: " + dadosHorarios.getString(3) + "\n" +
                        "Periodo: " + dadosHorarios.getInt(4) + "\n";
            }
            return saida;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<String> PesquisarHorario_Atualizar(String nomeMed) {

        ArrayList<String> saida = new ArrayList();
        try {
            Cursor dadosHorarios = MainActivity.database.rawQuery("select h.*,m.nome from Horario h inner join Medicamento m on h.codMed = m.codMed where m.nome = ?", new String[]{nomeMed});
            if (dadosHorarios.moveToFirst()) {
                saida.add(dadosHorarios.getString(0));
                saida.add(dadosHorarios.getString(1));
                saida.add(dadosHorarios.getString(2));
                saida.add(dadosHorarios.getString(3));
                saida.add(dadosHorarios.getString(4));
                saida.add(dadosHorarios.getString(5));
                saida.add(dadosHorarios.getString(6));

            }
            return saida;
        } catch (SQLException e) {
            return null;
        }
    }

    public int AtualizarHorario(String codHorario, String titulo, String data, String hora, int periodo, String nomeMed) {
        ContentValues contentValues = new ContentValues();
        int codMed = 0;
        try {

            Cursor dadoMed = MainActivity.database.rawQuery("select codMed from Medicamento where nome = ? and status = ?", new String[]{nomeMed, "1"});

            if (dadoMed.moveToFirst()) {
                codMed = dadoMed.getInt(0);
            }

            contentValues.put("titulo", titulo);
            contentValues.put("data", data);
            contentValues.put("hora", hora);
            contentValues.put("periodo", periodo);
            contentValues.put("codMed", codMed);

            MainActivity.database.update("Horario", contentValues, " codHor = ?",
                    new String[]{codHorario});

            return 1;
        } catch (SQLException e) {

            return 0;
        }
    }

    public int RemoverHorario(String codigo) {

        try {
            MainActivity.database.delete("Horario", "codHor = ?", new String[]{codigo});
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int CadastrarEstoque(String dataCompra, int qtdCartela, String dataValidade, String nomeMed) {
        int i = 0, codMed = 0, codHorario = 0;

        ContentValues contentValues = new ContentValues();
        contentValues.put("dataCompra", dataCompra);
        contentValues.put("qtdCartela", qtdCartela);
        contentValues.put("dataValidade", dataValidade);
        try {
            Cursor dados = MainActivity.database.rawQuery("select h.codHor,m.codMed from Horario h inner join Medicamento m on h.codMed = m.codMed where m.nome = ?", new String[]{nomeMed});
            if (dados.moveToFirst()) {
                codHorario = dados.getInt(0);
                codMed = dados.getInt(1);
                contentValues.put("codMed", codMed);
                contentValues.put("codHor", codHorario);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Medicamento não cadastrado no sistema");
        }
        if (contentValues == null) {
            throw new IllegalArgumentException("Medicamento não cadastrado no sistema");
        }

        try {
            MainActivity.database.insert("Estoque", null, contentValues);
            return 1;
        } catch (SQLException e) {
            return 0;
        }

    }

    public String PesquisarEstoque(String nomeMed) {

        String saida = null;

        try {

            Cursor dadosEstoque = MainActivity.database.rawQuery("select e.*, m.nome, h.titulo from Estoque e inner join Horario h on e.codHor = h.codHor join Medicamento m on h.codMed = m.codMed where m.nome = ?", new String[]{nomeMed});

            if (dadosEstoque.moveToFirst()) {

                saida = "Data da Compra: " + dadosEstoque.getString(1) + "\n" +
                        "Quantidade na cartela: " + dadosEstoque.getInt(2) + "\n" +
                        "Data de Validade: " + dadosEstoque.getString(3) + "\n" +
                        "Nome do medicamento: " + dadosEstoque.getString(6) + "\n";


            }
            return saida;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<String> PesquisarEstoque_Atualizar(String nomeMed) {

        ArrayList<String> saida = new ArrayList();
        try {
            Cursor dadosEstoque = MainActivity.database.rawQuery("select e.*, m.nome from Estoque e inner join Medicamento m on e.codMed = m.codMed where m.nome = ?", new String[]{nomeMed});

            if (dadosEstoque.moveToFirst()) {
                saida.add(dadosEstoque.getString(0));
                saida.add(dadosEstoque.getString(1));
                saida.add(dadosEstoque.getString(2));
                saida.add(dadosEstoque.getString(3));
                saida.add(dadosEstoque.getString(6));

            }
            return saida;
        } catch (SQLException e) {
            return null;
        }
    }

    public int AtualizarEstoque(String codEstoque, String DataC, int qtd, String dataV, String nomeMed) {
        ContentValues contentValues = new ContentValues();
        int codMed = 0, codHorario = 0;
        try {

            Cursor dadoMed = MainActivity.database.rawQuery("select h.codHor,m.codMed from Horario h inner join Medicamento m on h.codMed = m.codMed where m.nome = ?", new String[]{nomeMed});
            if (dadoMed.moveToFirst()) {
                codMed = dadoMed.getInt(1);
                codHorario = dadoMed.getInt(0);
            }

            contentValues.put("dataCompra", DataC);
            contentValues.put("qtdCartela", qtd);
            contentValues.put("dataValidade", dataV);
            contentValues.put("codMed", codMed);
            contentValues.put("codHor", codHorario);


            MainActivity.database.update("Estoque", contentValues, " codEst = ?", new String[]{codEstoque});

            return 1;
        } catch (SQLException e) {

            return 0;
        }
    }

    public int RemoverEstoque(String codigo) {
        try {
            MainActivity.database.delete("Estoque", "codEst = ?", new String[]{codigo});
            return 1;
        } catch (SQLException e) {
            return 0;
        }

    }

    public String relatorioMedicamentoxMes(String mes,String ano) {

        Cursor dadosRelatorio;
        String saida = mes + " / "+ano +": ";

        try {
            dadosRelatorio = MainActivity.database.rawQuery("select nome from Medicamento where dataIni like '%/"+mes+"/"+ano+"' or dataFim like '%/"+mes+"/"+ano+"'", null);

            if(dadosRelatorio.moveToFirst()) {
                while(dadosRelatorio.moveToNext()){
                  saida += dadosRelatorio.getString(0) +"\n";

                }

            }
            return saida;

        } catch (SQLException e) {
            return null;
        }
    }

    public double relatorioDosagemxMes(String mes,String ano) {

        Cursor dadosRelatorio;

        try {
            dadosRelatorio = MainActivity.database.rawQuery("select sum(dosagem) from Medicamento where dataIni like '%/"+mes+"/"+ano+"' or dataFim like '%/"+mes+"/"+ano+"'", null);

            dadosRelatorio.moveToFirst();
            return dadosRelatorio.getDouble(0);

        } catch (SQLException e) {
            return -1;
        }
    }
}



