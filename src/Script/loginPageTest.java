package Script;


import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;


import Generic.baseTest;
import Generic.genericMethods;

public class loginPageTest extends baseTest{

	/**
	 * login for PHP travel
	 * @param Author 
	 * @param SearchKey 
	 */
	
	@Test(enabled = true, groups = {LoginScenario} ,dataProvider ="dataSearch" ,dataProviderClass=genericMethods.class )
	public void testLoginForPHPTravel(String fruit,String number){
		Reporter.log("Test Case:Validate user able to login");
		Reporter.log("================================");
		Reporter.log("Test Steps | Expected Results:");
		Reporter.log("1. Launch PHP travels application (https://phptravels.com/demo/) |  PHP travels application should be Launched");
		Reporter.log("2. Enter valid Username and password  | User should be able to login");
		Reporter.log("================================");	
		Reporter.log("Actual Output:");
		
		Reporter.log(fruit + number); 
	    
		
		
	}
	

}