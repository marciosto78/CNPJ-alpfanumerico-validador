import br.com.cnpj.validador.ValidacaoCnpj;

public class Main {
    public static void main(String[] args){
        String cnpj = "00.000.000/0001-91";
        System.out.println(ValidacaoCnpj.isValidCNPJ(cnpj));
        cnpj = "1-91";
        System.out.println(ValidacaoCnpj.isValidCNPJ(cnpj));
        cnpj = "11.222.333/0001-81";
        System.out.println(ValidacaoCnpj.isValidCNPJ(cnpj));
        cnpj = "A1.222.333/0001";
        var digito = ValidacaoCnpj.digitoCNPJ(cnpj);
        System.out.println(digito);
        cnpj = "1";
        digito = ValidacaoCnpj.digitoCNPJ(cnpj);
        System.out.println(digito);
        System.out.println(digito);
    }
}
