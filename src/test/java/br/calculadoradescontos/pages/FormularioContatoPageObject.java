package br.calculadoradescontos.pages;

import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.calculadoradescontos.core.CorePage;

public class FormularioContatoPageObject extends CorePage {

	@FindBy(xpath = "/html/body/section/div[2]/div[3]/div[3]/a")
	private WebElement botaoContato;

	@FindBy(id = "nome")
	private WebElement nome;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(xpath = "/html/body/section/div[2]/div/form/div[3]/div[1]")
	private WebElement radioDuvida;
	
	@FindBy(xpath = "/html/body/section/div[2]/div/form/div[3]/div[2]")
	private WebElement radioSugestao;
	
	@FindBy(xpath = "/html/body/section/div[2]/div/form/div[3]/div[3]")
	private WebElement radioReclamacao;
	
	@FindBy(id = "idade")
	private WebElement idade;

	@FindBy(id = "mensagem")
	private WebElement mensagem;

	@FindBy(xpath = "/html/body/section/div[2]/span")
	private WebElement mensagemConfirmacao;

	@FindBy(xpath = "/html/body/section/div[2]/div/form/button[1]")
	private WebElement botaoEnviarMensagem;

	private String mensagemRetornada;

	public void acessarButtonBodyContato() throws MalformedURLException {
		clicarLink(this.botaoContato);
	}

	public void setNome(String nome) throws MalformedURLException {
		escrever(this.nome, nome);
	}

	public void setEmail(String email) throws MalformedURLException {
		escrever(this.email, email);
	}

	public void marcarButtonRadioDuvida() throws MalformedURLException {
		clicarLink(this.radioDuvida);
	}
	
	public void marcarButtonRadioSugestao() throws MalformedURLException {
		clicarLink(this.radioSugestao);
	}
	
	public void marcarButtonRadioReclamacao() throws MalformedURLException {
		clicarLink(this.radioReclamacao);
	}

	public void selecionarIdade(String idade) throws MalformedURLException {
		selecionarCombo(this.idade, idade);
	}

	public void setMensagem(String mensagem) throws MalformedURLException {
		escrever(this.mensagem, mensagem);
	}

	public String getMensagemConfirmacao() throws MalformedURLException, ParseException {
		return this.mensagemConfirmacao.getText();
	}

	public void clicarbotaoEnviarMensagem() throws MalformedURLException {
		clicarBotao(this.botaoEnviarMensagem);
	}

	public String getPageContato(String nome, String email, String idade, String mensagem, int tipoMensagem)
			throws MalformedURLException, ParseException {

		this.acessarButtonBodyContato();
		this.setNome(nome);
		this.setEmail(email);

		switch (tipoMensagem) {

		case 1: // Duvida
			this.marcarButtonRadioDuvida();
			break;

		case 2: // Sugestão
			this.marcarButtonRadioSugestao();
			break;
			
		case 3: // Reclamação
			this.marcarButtonRadioReclamacao();
			break;
		}

		this.selecionarIdade(idade);
		this.setMensagem(mensagem);
		this.clicarbotaoEnviarMensagem();
		this.mensagemRetornada = this.getMensagemConfirmacao();

		return this.mensagemRetornada;

	}
}