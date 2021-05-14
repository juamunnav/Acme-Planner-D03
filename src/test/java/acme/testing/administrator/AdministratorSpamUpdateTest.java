
package acme.testing.administrator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class AdministratorSpamUpdateTest extends SignUpTest {

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		//super.setAutoPausing(true);

		this.navigateHome();
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (initial)");
		super.clickOnMenu("Administrator", "Populate DB (samples)");

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveUpdateThreshold(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam threshold");
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Save");

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamMal.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void negativeUpdateThreshold(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam threshold");
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Save");
		super.checkErrorsExist("threshold");

	}

}
