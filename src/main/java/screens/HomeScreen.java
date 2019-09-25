package screens;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeScreen extends BaseScreen{

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="inputFieldLeft")
	public MobileElement txtLeftField;
	
	@FindBy(id="inputFieldRight")
	public MobileElement txtRightField;
	
	@FindBy(id="additionButton")
	public MobileElement btnAddition;
	
	@FindBy(id="subtractButton")
	public MobileElement btnSubtract;
	
	@FindBy(id="multiplicationButton")
	public MobileElement btnMultiplication;
	
	@FindBy(id="divisionButton")
	public MobileElement btnDivision;
	
	@FindBy(id="resetButton")
	MobileElement btnReset;
	
	@FindBy(id="resultTextView")
	public MobileElement viewResult;
	
	public boolean elementVisiableInHomeScreen()
	{
		return(txtLeftField.isDisplayed());
	}
    
	public boolean checkValidationFoEmptyFields()
	{
		btnMultiplication.click();
		return (viewResult.getText().contains("fill the input fields correctly"));
	}
	
	public void mathematics(int x,int y ,String function,MobileElement element)
	{
		
		txtLeftField.setValue(Integer.toString(x));
		txtRightField.setValue(Integer.toString(y));
		element.click();
		
	}
	
	public void reset()
	{
		
		btnReset.click();
	}
	
	public boolean isAnEmptyFiled(MobileElement element) { return element.getText().isEmpty();}
}
