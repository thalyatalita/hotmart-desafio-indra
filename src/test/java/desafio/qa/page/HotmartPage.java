package desafio.qa.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import desafio.qa.core.CoreDriver;
import desafio.qa.core.CorePage;

public class HotmartPage extends CorePage<HotmartPage> {

	protected WebDriver driver;

	public HotmartPage() {
		this.driver = CoreDriver.getDriver();
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}

	// MAPEAMENTO

	@FindBy(xpath = "//div[@class='header__navigation-plattaform']//span[contains(text(),'Cadastre-se')]")
	private WebElement cadastrar;

	@FindBy(xpath = "//*[contains(@id,'signup')]/div[1]/input[1]")
	private WebElement nome;

	@FindBy(xpath = "//*[contains(@id,'signup')]/div[2]/input[1]")
	private WebElement email;

	@FindBy(xpath = "//*[contains(@id,'signup')]/div[3]/input[1]")
	private WebElement senha;

	@FindBy(xpath = "//label[@class='hot-custom-control__label']")
	private WebElement termoUso;

	@FindBy(xpath = "//span[contains(text(),'Continuar')]")
	private WebElement btnContinuar;

	@FindBy(xpath = "//p[contains(text(),'Já existe um usuário cadastrado com este e-mail')]")
	private WebElement alertUsuarioCadastrado;

	@FindBy(xpath = "//p[contains(text(),'Aceite os Termos de Uso da Hotmart para continuar.')]")
	private WebElement alertTermoUso;

	@FindBy(xpath = "//div[text()='Nome Completo é obrigatório']")
	private WebElement msgCampoObrigatorioNome;

	@FindBy(xpath = "//div[text()='Email é obrigatório']")
	private WebElement msgCampoObrigatorioEmail;

	@FindBy(xpath = "//div[text()='Senha é obrigatório']")
	private WebElement msgCampoObrigatorioSenha;

	@FindBy(xpath = "//div[text()='Digite um endereço de Email válido']")
	private WebElement msgEmailInvalido;

	@FindBy(xpath = "//div[text()='No mínimo 7 caracteres, com ao menos uma letra e um número.']")
	private WebElement msgSenhaIncorreta;

	//METODOS DE VALIDAÇÂO DE TEXTO

	public void validarMensagemCampoObrigatorioNome(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(msgCampoObrigatorioNome));
		Assert.assertEquals(texto, msgCampoObrigatorioNome.getText());
	}

	public void validarMensagemCampoObrigatorioEmail(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(msgCampoObrigatorioEmail));
		Assert.assertEquals(texto, msgCampoObrigatorioEmail.getText());
	}

	public void validarMensagemCampoObrigatorioSenha(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(msgCampoObrigatorioSenha));
		Assert.assertEquals(texto, msgCampoObrigatorioSenha.getText());
	}

	public void validarMensagemEmailInvalido(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(msgEmailInvalido));
		Assert.assertEquals(texto, msgEmailInvalido.getText());
	}

	public void validarMensagemSenhaInvalido(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(msgSenhaIncorreta));
		Assert.assertEquals(texto, msgSenhaIncorreta.getText());
	}

	//METODOS DE CLICK

	public void clicarCadastrar() {
		aguardarElementoVisivel(cadastrar);
		click(cadastrar);
	}

	public void clicarTermoUso() {
		aguardarElementoVisivel(termoUso);
		click(termoUso);
	}

	public void clicarBtnContinuar() {
		aguardarElementoVisivel(btnContinuar);
		moverCursorPara(btnContinuar);
		click(btnContinuar);
	}

	//METODOS DE PREENCHIMENTOS DE CAMPOS

	public void preencherNomeCompleto() {
		aguardarElementoVisivel(nome);
		preencherCampo(nome, "Usuário Teste");
	}

	public void preencherEmail() {
		aguardarElementoVisivel(email);
		preencherCampo(email, "desafio@teste.com");
	}

	public void preencherSenha() {
		aguardarElementoVisivel(senha);
		preencherCampo(senha, "2f36jw9");
	}

	//METODOS DE PREENCHIMENTOS INVALIDOS DE CAMPOS

	public void preencherEmailInvalido() {
		aguardarElementoVisivel(email);
		preencherCampo(email, "desafio@");
	}

	public void preencherSenhaInvalida() {
		aguardarElementoVisivel(senha);
		preencherCampo(senha, "2d6j3g");
	}

	public void preencherSenhaInvalidaApenasNumero() {
		aguardarElementoVisivel(senha);
		preencherCampo(senha, "1368249");
	}

	public void preencherSenhaInvalidaApenasLetra() {
		aguardarElementoVisivel(senha);
		preencherCampo(senha, "abyelks");
	}

	//METODOS DE VALIDAÇÂO DE ALERT

	public void validarAlerta(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(alertUsuarioCadastrado));
		Assert.assertEquals(texto, alertUsuarioCadastrado.getText());
	}

	public void validarAlertaTermoUso(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(alertTermoUso));
		Assert.assertEquals(texto, alertTermoUso.getText());
	}

}
