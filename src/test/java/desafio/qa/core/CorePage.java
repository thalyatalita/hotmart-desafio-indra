package desafio.qa.core;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CorePage<T> {

	private static final int LOAD_TIMEOUT = 30;

	public WebDriver driver;

	public CorePage() {
		this.driver = CoreDriver.getDriver();
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}

	public T openPage(Class<T> clazz, String BASE_URL) {
		T page = PageFactory.initElements(this.driver, clazz);
		this.driver.get(BASE_URL + getUrl());
		return page;
	}

	public String getUrl() {
		return "";
	}


	/**
	 * Método responsavél por limpar campo e depois preencher.
	 * 
	 */
	public void preencherCampo(WebElement element, String keysToSend) {
		// element.clear();
		element.sendKeys(keysToSend);
	}

	/**
	 * Método responsavél por aguardar o element e depois clicar.
	 * 
	 */
	public void click(WebElement element) {
		aguardarElementoVisivel(element);
		element.click();
	}

	/**
	 * Método responsavél por forçar a espera pelo element na tela.
	 * 
	 */
	public void aguardarElementoVisivel(WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(this.driver, LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			fail("Tempo excedido para aguardar elemento: " + element);
		}
	}

	/**
	 * Método responsavél por mover o cursor do mouse para onde desejar.
	 * 
	 */
	public void moverCursorPara(WebElement elemento) {
		Actions action = new Actions(this.driver);
		action.moveToElement(elemento).build().perform();
	}

}
