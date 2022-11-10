package br.calculadoradescontos.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.PageFactory;

import br.calculadoradescontos.core.CoreTest;
import br.calculadoradescontos.pages.FormularioContatoPageObject;
//import net.serenitybdd.junit5.SerenityJUnit5Extension;

//@RunWith(SerenityRunner.class)
//@ExtendWith(SerenityJUnit5Extension.class)
public class TestREQ003_FormularioContato extends CoreTest{

	private FormularioContatoPageObject formulariocontato;

	@BeforeEach
    public void setup() throws Exception {
        this.formulariocontato = PageFactory.initElements(getDriver(), FormularioContatoPageObject.class);
    }

    @AfterEach
    public void tearDown() throws Exception {
        this.formulariocontato = null;
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Duvida, Menor que 18 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemDuvidaMenorQue18Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Menor que 18 anos","Teste Mensagem Duvida, Menor que 18 anos",1);
    	 assertEquals("Mensagem de DÚVIDA por usuário de idade MENOR QUE 18 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Sugestão, Menor que 18 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemSugestaoMenorQue18Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Menor que 18 anos","Teste Mensagem Sugestão, Menor que 18 anos",2);
    	 assertEquals("Mensagem de SUGESTÃO por usuário de idade MENOR QUE 18 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Reclamação, Menor que 18 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemReclamacaoMenorQue18Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Menor que 18 anos","Teste Mensagem Sugestão, Menor que 18 anos",3);
    	 assertEquals("Mensagem de RECLAMAÇÃO por usuário de idade MENOR QUE 18 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Duvida, Entre 18 e 29 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemDuvidaEntre18e29Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Entre 18 e 29 anos","Teste Mensagem Duvida, Entre 18 e 29 anos",1);
    	 assertEquals("Mensagem de DÚVIDA por usuário de idade ENTRE 18 E 29 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Sugestao, Entre 18 e 29 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemSugestaoEntre18e29Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Entre 18 e 29 anos","Teste Mensagem Sugestao, Entre 18 e 29 anos",2);
    	 assertEquals("Mensagem de SUGESTÃO por usuário de idade ENTRE 18 E 29 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Reclamacao, Entre 18 e 29 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemReclamacaoEntre18e29Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Entre 18 e 29 anos","Teste Mensagem Reclamação, Entre 18 e 29 anos",3);
    	 assertEquals("Mensagem de RECLAMAÇÃO por usuário de idade ENTRE 18 E 29 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Duvida, Entre 30 e 64 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemDuvidaEntre30e64Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Entre 30 e 64 anos","Teste Mensagem Dúvida, Entre 30 e 64 anos",1);
    	 assertEquals("Mensagem de DÚVIDA por usuário de idade ENTRE 30 E 64 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Sugestao, Entre 30 e 64 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemSugestaoEntre30e64Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Entre 30 e 64 anos","Teste Mensagem Sugestão, Entre 30 e 64 anos",2);
    	 assertEquals("Mensagem de SUGESTÃO por usuário de idade ENTRE 30 E 64 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
    @Test
    @DisplayName("Enviar uma mensagem de Reclamacao, Entre 30 e 64 anos")
    @Tags({@Tag("Automaticos"),@Tag("RF003")})
    public void testEnviarMensagemReclamacaoEntre30e64Anos() throws Exception {
    	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","Entre 30 e 64 anos","Teste Mensagem Reclamação, Entre 30 e 64 anos",3);
    	 assertEquals("Mensagem de RECLAMAÇÃO por usuário de idade ENTRE 30 E 64 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
    }
    
  @Test
  @DisplayName("Enviar uma mensagem de Duvida, A partir de 65 anos")
  @Tags({@Tag("Automaticos"),@Tag("RF003")})
  public void testEnviarMensagemDuvidaAPartir65Anos() throws Exception {
  	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","A partir de 65 anos","Teste Mensagem Dúvida, A partir de 65 anos",1);
  	 assertEquals("Mensagem de DÚVIDA por usuário de idade A PARTIR DE 65 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
  }
  
  @Test
  @DisplayName("Enviar uma mensagem de Sugestao, A partir de 65 anos")
  @Tags({@Tag("Automaticos"),@Tag("RF003")})
  public void testEnviarMensagemSugestaoAPartir65Anos() throws Exception {
  	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","A partir de 65 anos","Teste Mensagem Sugestão, A partir de 65 anos",2);
  	 assertEquals("Mensagem de SUGESTÃO por usuário de idade A PARTIR DE 65 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
  }
  
  @Test
  @DisplayName("Enviar uma mensagem de Reclamacao, A partir de 65 anos")
  @Tags({@Tag("Automaticos"),@Tag("RF003")})
  public void testEnviarMensagemReclamacaoAPartir65Anos() throws Exception {
  	 this.formulariocontato.getPageContato("Antonio","toinho@gmail.com","A partir de 65 anos","Teste Mensagem Reclamação, A partir de 65 anos",3);
  	 assertEquals("Mensagem de RECLAMAÇÃO por usuário de idade A PARTIR DE 65 ANOS foi enviada com sucesso!", this.formulariocontato.getMensagemConfirmacao());
  }
}