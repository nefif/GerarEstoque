package nefi.fernandes.gerarestoque.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nefi.fernandes.gerarestoque.api.AppUtil;
import nefi.fernandes.gerarestoque.datamodel.ClienteDataModel;
import nefi.fernandes.gerarestoque.datamodel.ProdutoDataModel;
import nefi.fernandes.gerarestoque.model.Cliente;
import nefi.fernandes.gerarestoque.model.Produto;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "GerirEstoque.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.i(AppUtil.TAG, "AppDataBase: Criando Banco de Dados... ");

        db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ProdutoDataModel.criarTabela());
        Log.i(AppUtil.TAG, "onCreate: Tabela Produto criada... " + ProdutoDataModel.criarTabela());

        db.execSQL(ClienteDataModel.criarTabela());
        Log.i(AppUtil.TAG, "onCreate: Tabela Cliente criada... " + ClienteDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        try {

            retorno = db.insert(tabela, null, dados) > 0;

        } catch (Exception e) {

            Log.i(AppUtil.TAG, "insert: " + e.getMessage());

        }

        return retorno;
    }

    public boolean deleteByID(String tabela, int id) {

        db = getWritableDatabase();

        boolean retorno = false;

        try {

            retorno = db.delete(tabela, "id=?", new String[]{String.valueOf(id)}) > 0;

        } catch (Exception e) {

            Log.i(AppUtil.TAG, "delete " + e.getMessage());

        }

        return retorno;
    }

    public boolean update(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        try {

            retorno = db.update(tabela, dados, "id=?", new String[]{String.valueOf(dados.get("id"))}) > 0;

        } catch (Exception e) {

            Log.i(AppUtil.TAG, "update: " + e.getMessage());

        }

        return retorno;
    }

    public List<Cliente> getAllClientes(String tabela) {

        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;

        String sql = "SELECT * FROM" + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.TELEFONE)));

                clientes.add(obj);

                Log.i(AppUtil.TAG, "getAllClientes: " + obj.getNome());

            } while (cursor.moveToNext());

        }

        return clientes;
    }

    public List<Produto> getAllProdutos (String tabela) {

        db = getWritableDatabase();

        List<Produto> produtos = new ArrayList<>();
        Produto obj;

        String sql = "SELECT * FROM" + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()) {

            do{

                obj = new Produto();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.NOME)));
                obj.setModelo(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.MODELO)));
                obj.setFabricante(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.FABRICANTE)));
                obj.setQuantidade(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.QUANTIDADE)));


            }while (cursor.moveToNext());

        }

        return produtos;
    }


}
