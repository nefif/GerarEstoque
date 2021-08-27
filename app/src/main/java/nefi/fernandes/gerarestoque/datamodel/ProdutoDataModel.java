package nefi.fernandes.gerarestoque.datamodel;

public class ProdutoDataModel {

    public static final String TABELA = "produto";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String MODELO = "modelo";
    public static final String FABRICANTE = "frabricante";
    public static final String QUANTIDADE = "quantidade";

    public static String queryCriarTabela = "";

    public static String criarTabela() {

        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, ";
        queryCriarTabela += MODELO+" text, ";
        queryCriarTabela += FABRICANTE+" text, ";
        queryCriarTabela += QUANTIDADE+" text ";
        queryCriarTabela +=")";

        return queryCriarTabela;
    }

}
