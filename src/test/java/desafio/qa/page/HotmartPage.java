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
	private WebElement alert;
	
	@FindBy(xpath = "//div[text()='Nome Completo é obrigatório']")
	private WebElement mgsNome;
	
	@FindBy(xpath = "//div[text()='Email é obrigatório']")
	private WebElement mgsEmail;
	
	@FindBy(xpath = "//div[text()='Senha é obrigatório']")
	private WebElement mgsSenha;
	
	//METODOS DE VALIDAÇÂO DE TEXTO
	
	public void validarAlerta(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(alert));
		Assert.assertEquals(texto, alert.getText());
	}
	
	public void validarMensagemErroCampoNome(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(mgsNome));
		Assert.assertEquals(texto, mgsNome.getText());
	}
	
	public void validarMensagemErroCampoEmail(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(mgsEmail));
		Assert.assertEquals(texto, mgsEmail.getText());
	}
	
	public void validarMensagemErroCampoSenha(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(mgsSenha));
		Assert.assertEquals(texto, mgsSenha.getText());
	}

	// METODOS DE CLICK
	
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
	
	// MÈTODOS DE PREENCHIMENTOS DE CAMPOS

	public void preencherNomeCompleto() {
		aguardarElementoVisivel(nome);
		preencherCampo(nome, "Thalya Amorim");
	}
	
	public void preencherEmail() {
		aguardarElementoVisivel(email);
		preencherCampo(email, "desafio@desafio.com");
	}
	
	public void preencherSenha() {
		aguardarElementoVisivel(senha);
		preencherCampo(senha, "123456a");
	}

}
