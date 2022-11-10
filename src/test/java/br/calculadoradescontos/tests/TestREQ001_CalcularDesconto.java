package br.calculadoradescontos.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import br.calculadoradescontos.core.CoreTest;
import br.calculadoradescontos.pages.ProdutoPageObject;

public class TestREQ001_CalcularDesconto extends CoreTest{

	private ProdutoPageObject produto;

	@BeforeEach
    public void setup() throws Exception {
        this.produto = PageFactory.initElements(getDriver(), ProdutoPageObject.class);
    }

    @AfterEach
    public void tearDown() throws Exception {
        this.produto = null;
    }

//--------------------------menor que 100-----------------------------------------
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente A, menor que 100 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteAMenor100() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("A", 99);
    	String valorComDesconto = produto.calcularValorComDesconto(0.90,valorProduto);
    	assertEquals("0,90 (ou seja, 10% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente B, menor que 100 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteBMenor100() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("B", 99);
    	String valorComDesconto = this.produto.calcularValorComDesconto(0.85,valorProduto);
    	assertEquals("0,85 (ou seja, 15% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente C, menor que 100 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteCMenor100() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("C", 99);
    	String valorComDesconto = this.produto.calcularValorComDesconto(0.80,valorProduto);
    	assertEquals("0,80 (ou seja, 20% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }

//--------------------------Entre 100 e 1000-------------------------------------
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente A, Entre 100 e 1000 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteAEntre100e1000() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("A", 101);
    	String valorComDesconto = this.produto.calcularValorComDesconto(0.95,valorProduto);
    	assertEquals("0,95 (ou seja, 5% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente B, Entre 100 e 1000 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteBEntre100e1000() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("B", 101);
    	String valorComDesconto = this.produto.calcularValorComDesconto(0.90,valorProduto);
    	assertEquals("0,90 (ou seja, 10% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente C, Entre 100 e 1000 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteCEntre100e1000() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("C", 101);
    	String valorComDesconto = this.produto.calcularValorComDesconto(0.85,valorProduto);
    	assertEquals("0,85 (ou seja, 15% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
   
//---------------------------Maior que 1000 unidades--------------------------------
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente A, Maior que 1000 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteAMaiorQue1000() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("A", 1001);
    	String valorComDesconto = this.produto.calcularValorComDesconto(1.00,valorProduto);
    	assertEquals("1,00 (ou seja, 0% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente B, Maior que 1000 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteBMaiorQue1000() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("B", 1001);
    	String valorComDesconto = this.produto.calcularValorComDesconto(0.95,valorProduto);
    	assertEquals("0,95 (ou seja, 5% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
    
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente C, Maior que 1000 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteCMaiorQue1000() throws Exception {
    	String valorProduto = this.produto.getPageComFatorDesconto("C", 1001);
    	String valorComDesconto = this.produto.calcularValorComDesconto(0.90,valorProduto);
    	assertEquals("0,90 (ou seja, 10% de desconto)", this.produto.getFator());
        assertEquals(valorComDesconto, this.produto.getValorComDesconto());
    }
}