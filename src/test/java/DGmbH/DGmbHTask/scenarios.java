package DGmbH.DGmbHTask;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import screens.HomeScreen;

public class scenarios extends  BaseTest {
	
	HomeScreen homescreen;
	@Test(priority=1)
	public void homepageIsOpened()
	{
		   homescreen=new HomeScreen(driver);
           assertTrue(homescreen.elementVisiableInHomeScreen(),"EditText field appears in home screen");
	}
	
	@Test(priority=2)
	public void validationsExistsDoFunctionwithoutNumbers()
	{
		homescreen=new HomeScreen(driver);
		assertTrue(homescreen.checkValidationFoEmptyFields());
	}
	
	@Test(priority=3) 
	public void additionOfTwoNumbers_shouldLeadTo_ResultNumber()
	{
		homescreen=new HomeScreen(driver);
		homescreen.mathematics(2, 20, "+", homescreen.btnAddition);
		assertTrue(homescreen.viewResult.getText().contains(Integer.toString(2+20)));
	
	}
	
	@Test(priority=4)
	public void reset_shouldLeadTo_ResetAllFields()
	{
		
		homescreen.reset();
		assertTrue(homescreen.isAnEmptyFiled(homescreen.txtLeftField));
		assertTrue(homescreen.isAnEmptyFiled(homescreen.txtLeftField));
	}
	
	@Test(priority=5)
	public void divisionOfTwoNumbers_shouldLeadTo_ResultNumber()
	{
		homescreen=new HomeScreen(driver);
		homescreen.mathematics(100, 200, "/", homescreen.btnDivision);
		assertTrue(homescreen.viewResult.getText().contains(Integer.toString(100/200)));
	}

	@Test(priority=6)
	public void addtionAndMultipleOfTwoNumbers_shouldLeadTo_ResultNumber()
	{
		homescreen=new HomeScreen(driver);
		homescreen.reset();
		homescreen.mathematics(100, 200, "+", homescreen.btnAddition);
		homescreen.btnMultiplication.click();
		assertTrue(homescreen.viewResult.getText().contains(Integer.toString(100*200)));
	} 
}
