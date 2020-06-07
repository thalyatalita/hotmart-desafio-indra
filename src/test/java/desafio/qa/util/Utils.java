package desafio.qa.util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import desafio.qa.core.CoreDriver;

public abstract class Utils {

	/**
	 * Método para capturar screenshot
	 * @param driver 
	 * @param fileName
	 */
	public static void takeScreenshot(WebDriver driver, String casoDeteste, String nomeEvidencia) {
		
		File scrFile = ((TakesScreenshot) CoreDriver.getDriver())
				.getScreenshotAs(OutputType.FILE);
		try {
			String pastaImages = "Evidencias/"+casoDeteste+"/"+nomeEvidencia+".jpg";
					
			String pastaResultado = "resultadoTest/" + pastaImages;
					
			File fileDestino = new File(pastaResultado);
			FileUtils.copyFile(scrFile,fileDestino,true);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
