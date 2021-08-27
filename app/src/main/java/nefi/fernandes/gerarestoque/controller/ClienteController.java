package nefi.fernandes.gerarestoque.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nefi.fernandes.gerarestoque.api.AppUtil;
import nefi.fernandes.gerarestoque.datamodel.ClienteDataModel;
import nefi.fernandes.gerarestoque.datasource.AppDataBase;
import nefi.fernandes.gerarestoque.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadosDoObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.i(AppUtil.TAG, "ClienteController: Conectado.");

    }

    @Override
    public boolean incluir(Cliente obj) {

        dadosDoObjeto = new ContentValues();

        dadosDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadosDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadosDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadosDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadosDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadosDoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadosDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadosDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadosDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadosDoObjeto.put(ClienteDataModel.DOCUMENTO, obj.getDocumento());

        return insert(ClienteDataModel.TABELA, dadosDoObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {

        dadosDoObjeto = new ContentValues();

        dadosDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadosDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadosDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());

        return update(ClienteDataModel.TABELA, dadosDoObjeto);
    }

    @Override
    public boolean deletar(int id) {

        return deleteByID(ClienteDataModel.TABELA, id);

    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);

    }

    public List<String> gerarListaDeClientes() {

        List<String> clientes = new ArrayList<>();

        for (Cliente obj : listar()) {

            clientes.add(obj.getId()+", "+obj.getNome()+", "+obj.getTelefone());

        }

        return clientes;
    }
}
