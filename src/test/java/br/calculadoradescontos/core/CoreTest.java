package br.calculadoradescontos.core;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CoreTest extends CorePage {

	@BeforeEach
    public void setupCoreTest() throws Exception {
        getDriver().get("https://calculadora.diegoquirino.net/");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDownCoreTest() {
        killDriver();
    }
	
}