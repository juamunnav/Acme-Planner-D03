package acme.testing.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class ManagerDeleteTaskTest extends SignUpTest{
	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		//super.setAutoPausing(true);

		this.navigateHome();
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (samples)");

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/task/ManagerDeleteTaskBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void deleteTaskPositive(final int recordIndex) {
		super.signIn("manager01", "manager01");
		super.clickOnMenu("Manager", "List Tasks");
		
		super.clickOnListingRecord(recordIndex);
		super.clickOnSubmitButton("Delete");
		super.signOut();
		
	}


}
