package br.calculadoradescontos.core;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorePage extends CoreDriver {

	public void escrever(WebElement e, String texto) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		e.clear();
		e.sendKeys(texto);
	}

	public void selecionarCombo(WebElement e, String valor) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		Select combo = new Select(e);
		combo.selectByVisibleText(valor);
	}

	public void limparCampo(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		e.clear();
	}

	public void clicarBotao(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		e.click();
	}

	public void clicarBotaoForcado(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", e);
	}

	public void submitBotao(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		e.submit();
	}

	public String obterTexto(By element) throws MalformedURLException {
		return getDriver().findElement(element).getText();
	}

	public String obterTexto(String xPath) throws MalformedURLException {
		return obterTexto(By.xpath(xPath));
	}

	public void clicarLink(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		e.click();
	}

	public void waitDriver(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void waitDriverInvisibility(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}

	public void waitDriverVisibility(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitDriverClicavel(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitDriverAll(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
