package nefi.fernandes.gerarestoque.datamodel;

public class ClienteDataModel {

    //01 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    //02 - Atributos com os campos da tabela
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String TELEFONE = "telefone";
    public static final String EMAIL = "email";
    public static final String CEP = "cep";
    public static final String LOGRADOURO = "logradouro";
    public static final String NUMERO = "numero";
    public static final String BAIRRO = "bairro";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String DOCUMENTO = "documento";

    //03 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    //04 - Script para gerar e criar a tabela

    public static String criarTabela(){

        queryCriarTabela+= "CREATE TABLE "+TABELA+" (";
        queryCriarTabela+= ID+" integer primary key autoincrement, ";
        queryCriarTabela+= NOME+" text, ";
        queryCriarTabela+= TELEFONE+" text, ";
        queryCriarTabela+= EMAIL+" text, ";
        queryCriarTabela+= CEP+" integer, ";
        queryCriarTabela+= LOGRADOURO+" text, ";
        queryCriarTabela+= NUMERO+" text, ";
        queryCriarTabela+= BAIRRO+" text, ";
        queryCriarTabela+= CIDADE+" text, ";
        queryCriarTabela+= ESTADO+" text, ";
        queryCriarTabela+= DOCUMENTO+" text ";
        queryCriarTabela+= ")";

        return queryCriarTabela;
    }
}
