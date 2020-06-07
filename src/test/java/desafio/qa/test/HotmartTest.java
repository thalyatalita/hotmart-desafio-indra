package desafio.qa.test;

import org.junit.Test;

import desafio.qa.core.CoreBaseTest;
import desafio.qa.page.HotmartPage;
import desafio.qa.util.Property;
import desafio.qa.util.Utils;

public class HotmartTest extends CoreBaseTest {
	
	@Test
	public void validarCamposObrigatorioTest() {
		
		HotmartPage hotmartPage = new HotmartPage();
		
		driver.navigate().to(Property.URL);
		
		hotmartPage.clicarBtnContinuar();
		
		hotmartPage.validarMensagemErroCampoNome("Nome Completo � obrigat�rio");
		hotmartPage.validarMensagemErroCampoEmail("Email � obrigat�rio");
		hotmartPage.validarMensagemErroCampoSenha("Senha � obrigat�rio");
		
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

}
