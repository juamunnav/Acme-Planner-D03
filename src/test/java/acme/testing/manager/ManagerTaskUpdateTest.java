
package acme.testing.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class ManagerTaskUpdateTest extends SignUpTest {

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
	@CsvFileSource(resources = "/task/TaskUpdateBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveUpdateTask(final int recordIndex, final String title, final String start, final String end, final String text, final String link, 
		final String visibility, final String workLoad, final String manager) {
		super.signIn("manager01", "manager01");
		super.clickOnMenu("Manager", "List Tasks");
		
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("start", start);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("workLoad", workLoad);
		
		super.clickOnSubmitButton("Update");

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/task/TaskUpdateMal.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void negativeUpdateTask(final int recordIndex,final String title, final String start, final String end, final String text, final String link, 
		final String visibility, final String workLoad, final String manager) {
		super.signIn("manager01", "manager01");
		super.clickOnMenu("Manager", "List Tasks");
		
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("start", start);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("workLoad", workLoad);
		
		super.clickOnSubmitButton("Update");

		super.checkErrorsExist();

	}

}
