
package acme.testing.anonymous;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class AnonymousShoutListTest extends SignUpTest {

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
	@CsvFileSource(resources = "/shout/ShoutListBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveListShouts(final int recordIndex, final String author, final String text, final String info, final String moment) {
		super.clickOnMenu("Anonymous", "List shouts");
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);

	}

//	@Override
//	@AfterAll
//	public void afterAll() {
//		super.afterAll();
//
//		this.navigateHome();
//		super.signIn("administrator", "administrator");
//		super.clickOnMenu("Administrator", "Shut down");
//
//	}
	
}
