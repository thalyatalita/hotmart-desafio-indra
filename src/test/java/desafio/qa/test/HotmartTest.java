package desafio.qa.test;

import org.junit.Test;
import desafio.qa.core.CoreBaseTest;
import desafio.qa.page.HotmartPage;
import desafio.qa.util.Property;
import desafio.qa.util.Utils;

public class HotmartTest extends CoreBaseTest {
	
	@Test
	public void validarSenhaInvalidaApenasNumeroTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.preencherNomeCompleto();
		hotmartPage.preencherEmail();
		hotmartPage.preencherSenhaInvalidaApenasNumero();
		hotmartPage.clicarTermoUso();
		hotmartPage.clicarBtnContinuar();
		hotmartPage.validarMensagemSenhaInvalido("No m�nimo 7 caracteres, com ao menos uma letra e um n�mero.");
		Utils.takeScreenshot(driver, "CadastroInvalidoUsuario", "SenhaInvalidaApenasNumero");
	}
	
	@Test
	public void validarSenhaInvalidaApenasLetrasTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.preencherNomeCompleto();
		hotmartPage.preencherEmail();
		hotmartPage.preencherSenhaInvalidaApenasLetra();
		hotmartPage.clicarTermoUso();
		hotmartPage.clicarBtnContinuar();
		hotmartPage.validarMensagemSenhaInvalido("No m�nimo 7 caracteres, com ao menos uma letra e um n�mero.");
		Utils.takeScreenshot(driver, "CadastroInvalidoUsuario", "SenhaInvalidaApenasLetras");
	}
	
	@Test
	public void validarSenhaInvalidaTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.preencherNomeCompleto();
		hotmartPage.preencherEmail();
		hotmartPage.preencherSenhaInvalida();
		hotmartPage.clicarTermoUso();
		hotmartPage.clicarBtnContinuar();
		hotmartPage.validarMensagemSenhaInvalido("No m�nimo 7 caracteres, com ao menos uma letra e um n�mero.");
		Utils.takeScreenshot(driver, "CadastroInvalidoUsuario", "SenhaInvalida");
	}
	
	@Test
	public void validarEmailInvalidoTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.preencherNomeCompleto();
		hotmartPage.preencherEmailInvalido();
		hotmartPage.preencherSenha();
		hotmartPage.clicarTermoUso();
		hotmartPage.clicarBtnContinuar();
		hotmartPage.validarMensagemEmailInvalido("Digite um endere�o de Email v�lido");
		Utils.takeScreenshot(driver, "CadastroInvalidoUsuario", "cadastroComEmailInvalido");
	}
	
	@Test
	public void validarCamposObrigatorioTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.clicarBtnContinuar();
		
		hotmartPage.validarMensagemCampoObrigatorioNome("Nome Completo � obrigat�rio");
		hotmartPage.validarMensagemCampoObrigatorioEmail("Email � obrigat�rio");
		hotmartPage.validarMensagemCampoObrigatorioSenha("Senha � obrigat�rio");
		
		Utils.takeScreenshot(driver, "CadastroUsuario", "validarCamposObrigatorios");
	}
	
	@Test
	public void cadastrarUsuarioTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.preencherNomeCompleto();
		hotmartPage.preencherEmail();
		hotmartPage.preencherSenha();
		hotmartPage.clicarTermoUso();
		hotmartPage.clicarBtnContinuar();
		Utils.takeScreenshot(driver, "CadastroUsuario", "cadastroComSucesso");
	}
	
	@Test
	public void CadastrarUsuarioExistenteTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.preencherNomeCompleto();
		hotmartPage.preencherEmail();
		hotmartPage.preencherSenha();
		hotmartPage.clicarTermoUso();
		hotmartPage.clicarBtnContinuar();
		hotmartPage.validarAlerta("J� existe um usu�rio cadastrado com este e-mail");
		Utils.takeScreenshot(driver, "CadastroUsuario", "cadastroExistente");
	}
	
	@Test
	public void validarTermoUsoTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.preencherNomeCompleto();
		hotmartPage.preencherEmail();
		hotmartPage.preencherSenha();
		hotmartPage.clicarBtnContinuar();
		hotmartPage.validarAlertaTermoUso("Aceite os Termos de Uso da Hotmart para continuar.");
		Utils.takeScreenshot(driver, "CadastroUsuario", "termoUso");
	}
	

}
