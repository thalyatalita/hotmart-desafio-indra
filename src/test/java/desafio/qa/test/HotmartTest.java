package desafio.qa.test;

import org.junit.Test;
import desafio.qa.core.CoreBaseTest;
import desafio.qa.page.HotmartPage;
import desafio.qa.util.Property;
import desafio.qa.util.Utils;

/**
 * <h1>Classe de teste contendo os casos de teste do cadastro no Hotmart.</h1>
 * @author Thalya
 */
public class HotmartTest extends CoreBaseTest {
	
	/**
	 * Caso de teste respons�vel por realizar a valida��o no campo senha com uma senha apenas numerica.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Preenche campo Nome Completo
	 * 3  - Preenche campo Email 
	 * 4  - Preenche campo Senha com dado de 7 caracteres numeros
	 * 5  - Clica em Aceitar Termo de Uso
	 * 6  - Clica no bot�o Continuar
	 * 7  - Valida texto encontrado na tela com texto esperado
	 * 8  - Coleta Evidencia
	 * </pre>
	 */
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
	
	/**
	 * Caso de teste respons�vel por realizar a valida��o no campo senha com uma senha apenas alfa.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Preenche campo Nome Completo
	 * 3  - Preenche campo Email 
	 * 4  - Preenche campo Senha com dado de 7 caracteres letras
	 * 5  - Clica em Aceitar Termo de Uso
	 * 6  - Clica no bot�o Continuar
	 * 7  - Valida texto encontrado na tela com texto esperado
	 * 8  - Coleta Evidencia
	 * </pre>
	 */
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
	
	/**
	 * Caso de teste respons�vel por realizar a valida��o no campo senha com uma senha menor que 7 caracteres.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Preenche campo Nome Completo
	 * 3  - Preenche campo Email 
	 * 4  - Preenche campo Senha com dados de 6 caracteres
	 * 5  - Clica em Aceitar Termo de Uso
	 * 6  - Clica no bot�o Continuar
	 * 7  - Valida texto encontrado na tela com texto esperado
	 * 8  - Coleta Evidencia
	 * </pre>
	 */
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
	/**
	 * Caso de teste respons�vel por realizar a valida��o no campo e-mail.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Preenche campo Nome Completo
	 * 3  - Preenche o campo com um e-mail Incorreto
	 * 4  - Preenche campo Senha
	 * 5  - Clica em Aceitar Termo de Uso
	 * 6  - Clica no bot�o Continuar
	 * 7  - Valida texto encontrado na tela com texto esperado
	 * 8  - Coleta Evidencia
	 * </pre>
	 */
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
	
	/**
	 * Caso de teste respons�vel por realizar a valida��o dos campos obrigatorios.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Clica no bot�o Continuar
	 * 3  - Valida os textos encontrado na tela com os textos esperado
	 * 4  - Coleta Evidencia
	 * </pre>
	 */
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
	
	/**
	 * Caso de teste respons�vel por realizar cadastro de usu�rio.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Preenche campo Nome Completo
	 * 3  - Preenche campo Email 
	 * 4  - Preenche campo Senha
	 * 5  - Clica em Aceitar Termo de Uso
	 * 6  - Clica no bot�o Continuar
	 * 7  - Coleta Evidencia
	 * </pre>
	 */
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
	
	/**
	 * Caso de teste respons�vel por realizar valida��o de usuario j� cadastrado no sistema.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Preenche campo Nome Completo
	 * 3  - Preenche campo Email 
	 * 4  - Preenche campo Senha
	 * 5  - Clica em Aceitar Termo de Uso
	 * 6  - Clica no bot�o Continuar
	 * 7  - Valida a mensagem encontrado na tela com a mensagem esperada
	 * 8  - Coleta Evidencia
	 * </pre>
	 */
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
	
	/**
	 * Caso de teste respons�vel por realizar valida��o do campo Termo de Uso.
	 * 
	 * <pre>
	 * 1  - Acessa a pagina de cadastro do Hotmart
	 * 2  - Preenche campo Nome Completo
	 * 3  - Preenche campo Email 
	 * 4  - Preenche campo Senha
	 * 5  - Clica no bot�o Continuar
	 * 6  - Valida a mensagem encontrado na tela com a mensagem esperada
	 * 7  - Coleta Evidencia
	 * </pre>
	 */
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
