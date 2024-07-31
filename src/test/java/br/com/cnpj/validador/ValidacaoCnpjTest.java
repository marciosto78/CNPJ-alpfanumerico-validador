package br.com.cnpj.validador;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidacaoCnpjTest {

    @Test
    public void sucesso_cnpj_valido(){
        String cnpj = "00.000.000/0001-91";
        assertTrue(ValidacaoCnpj.isValidCNPJ(cnpj));
        cnpj = "1-91";
        assertTrue(ValidacaoCnpj.isValidCNPJ(cnpj));
        cnpj = "11.222.333/0001-81";
        assertTrue(ValidacaoCnpj.isValidCNPJ(cnpj));
        cnpj = "A1.222.333/0001";
        var digito = ValidacaoCnpj.digitoCNPJ(cnpj);
        assertEquals("50", digito);
        cnpj = "1";
        digito = ValidacaoCnpj.digitoCNPJ(cnpj);
        assertEquals("91", digito);
        System.out.println(digito);
    }

}
