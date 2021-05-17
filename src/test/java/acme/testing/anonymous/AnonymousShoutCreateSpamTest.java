
package acme.testing.anonymous;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class AnonymousShoutCreateSpamTest extends SignUpTest {

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
	@CsvFileSource(resources = "/shout/ShoutSpamBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveCreateSpamShout(final String author, final String text, final String info) {
		super.clickOnMenu("Anonymous", "Create shout");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Create");
		super.longSleep();
		super.checkErrorsExist();

	}

}
