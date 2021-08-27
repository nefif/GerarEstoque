package nefi.fernandes.gerarestoque.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nefi.fernandes.gerarestoque.api.AppUtil;
import nefi.fernandes.gerarestoque.datamodel.ProdutoDataModel;
import nefi.fernandes.gerarestoque.datasource.AppDataBase;
import nefi.fernandes.gerarestoque.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadosDoObjeto;

    public ProdutoController(Context context) {
        super(context);

        Log.i(AppUtil.TAG, "ProdutoController: Conectado.");
    }

    @Override
    public boolean incluir(Produto obj) {

        dadosDoObjeto = new ContentValues();

        dadosDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadosDoObjeto.put(ProdutoDataModel.MODELO, obj.getModelo());
        dadosDoObjeto.put(ProdutoDataModel.FABRICANTE, obj.getFabricante());
        dadosDoObjeto.put(ProdutoDataModel.QUANTIDADE, obj.getQuantidade());

        return insert(ProdutoDataModel.TABELA, dadosDoObjeto);

    }

    @Override
    public boolean alterar(Produto obj) {

        dadosDoObjeto = new ContentValues();

        dadosDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadosDoObjeto.put(ProdutoDataModel.MODELO, obj.getModelo());
        dadosDoObjeto.put(ProdutoDataModel.FABRICANTE, obj.getFabricante());
        dadosDoObjeto.put(ProdutoDataModel.QUANTIDADE, obj.getQuantidade());

        return update(ProdutoDataModel.TABELA, dadosDoObjeto);

    }

    @Override
    public boolean deletar(int id) {

        return deleteByID(ProdutoDataModel.TABELA, id);
    }

    @Override
    public List<Produto> listar() {

        return getAllProdutos(ProdutoDataModel.TABELA);

    }

    public List<String> gerarListaDeProdutos() {

        List<String> produtos = new ArrayList<>();

        for (Produto obj : listar()) {

            produtos.add(obj.getId() + ", " + obj.getNome() + ", " + obj.getModelo() + ", "
                    + obj.getFabricante() + ", " + obj.getQuantidade());

        }

        return produtos;

    }

}
