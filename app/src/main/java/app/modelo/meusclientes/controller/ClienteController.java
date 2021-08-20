package app.modelo.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.marcelo.appminhaideia.core.AppUtil;
import com.marcelo.appminhaideia.datamodel.ClienteDataModel;
import com.marcelo.appminhaideia.datasource.AppDataBase;
import com.marcelo.appminhaideia.model.Cliente;

import java.util.List;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);
        Log.d(AppUtil.TAG, "ClienteController: conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();
        //Key, Valor

        // ID é chave primaria e é gerada automaticamente.
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        // Eviar os dados (dadoDoObjeto) para a classe AppDatabase


        //Retorno sempre sera FALSO ou VERDADEIRO
        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();
        //Key, Valor

        // ID é chave primaria da tabela cliente.
        // Alterar
        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        // Eviar os dados (dadoDoObjeto) para a classe AppDatabase
        return update(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ClienteDataModel.TABELA, id);
    }

    @Override
    public List<Cliente> listar() {
        return getAllClientes(ClienteDataModel.TABELA);
    }
}
