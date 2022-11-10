package br.calculadoradescontos.pages;

import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.calculadoradescontos.core.CorePage;

public class ProdutoPageObject extends CorePage {

	@FindBy(xpath = "/html/body/section/div[2]/div[1]/div[3]/a")
	private WebElement botaoCalcularDesconto;

	@FindBy(xpath = "//a[contains(@href,'produto/1')]")
	private WebElement botaoItem1;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement valor;

	@FindBy(id = "tipoCliente")
	private WebElement tipoCliente;

	@FindBy(id = "quantidade")
	private WebElement quantidade;

	@FindBy(xpath = "/html/body/section/div[3]/div/form/button")
	private WebElement botaoCalcularDescontoTipoCliente;
	
	@FindBy(id = "fator")
	private WebElement fator;
	
	@FindBy(id = "valor_com_desconto")
	private WebElement ValorComDesconto;
	
	private String valorProduto;
	
	public void acessarButtonBodyCalcularDesconto() throws MalformedURLException {
		clicarLink(this.botaoCalcularDesconto);
	}

	public void acessarButtonItem1() throws MalformedURLException {
		clicarLink(this.botaoItem1);
	}

	public String getValor() throws MalformedURLException, ParseException {
		return this.valor.getText().replace(".", "").replace(",", ".");
	}

	public void selecionarTipoCliente(String tipoCliente) throws MalformedURLException {
		selecionarCombo(this.tipoCliente, tipoCliente);
	}

	public void setQuantidade(Integer quantidade) throws MalformedURLException {
		escrever(this.quantidade, Integer.toString(quantidade));
	}

	public void acessarButtonCalcularDescontoTipoCliente() throws MalformedURLException {
		clicarLink(this.botaoCalcularDescontoTipoCliente);
	}
	
	public String getFator() throws MalformedURLException {
		return this.fator.getAttribute("value");
	}
	
	public String getValorComDesconto() throws MalformedURLException, ParseException {
		Locale defaultLocale = new Locale("en", "US", "USD");
        NumberFormat nf = NumberFormat.getCurrencyInstance(defaultLocale);
		double valorProd = new Double(nf.parse("$" + this.ValorComDesconto.getAttribute("value").replace(".", "").replace(",", ".")).doubleValue());
        return nf.format(new Double(valorProd)).replace("$", "");
	}
	
	public String getPageComFatorDesconto(String tipoCliente, Integer quantidade) throws MalformedURLException, ParseException {

		this.acessarButtonBodyCalcularDesconto(); //Clicando no botão calcular desconto
		this.valorProduto = this.getValor(); //Capturando valor do primeiro produto da lista
		this.acessarButtonItem1(); //Clicando no botão $
		this.selecionarTipoCliente(tipoCliente); //Definindo tipo de cliente
		this.setQuantidade(quantidade);//Definindo a quantidade
		this.acessarButtonCalcularDescontoTipoCliente();//Clicando em Calcular Desconto

		return this.valorProduto; //Retornando o Valor do Produto
	}
	
	public String calcularValorComDesconto(double fator,String valorProduto) throws ParseException {
        Locale defaultLocale = new Locale("en", "US", "USD");
        NumberFormat nf = NumberFormat.getCurrencyInstance(defaultLocale);
        double valorProd = new Double(nf.parse("$" + valorProduto).doubleValue());
        return nf.format(new Double(valorProd*fator)).replace("$", "");
    }

}
