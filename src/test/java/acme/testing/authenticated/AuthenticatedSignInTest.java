package acme.testing.authenticated;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.springframework.core.annotation.Order;

import acme.testing.SignUpTest;

public class AuthenticatedSignInTest extends SignUpTest{

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		//super.setAutoPausing(true);

		this.navigateHome();
		this.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (samples)");

	}

	/*
	 * Tested Feature: An user registers in the system.
	 * Violated constraints: Not applicable.
	 * Expected results: He registers in the system.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSignUp(final String username, final String password, final String confirmation, final String name, final String surname, final String email) {
		this.signUp(username, password, confirmation, name, surname, email);
		this.signIn(username, password);
		assert super.exists(By.linkText("Account"));
		this.signOut();
	}

	/*
	 * Tested Feature: An user registers in the system.
	 * Violated constraints: try to register with a blank field.
	 * Expected results: It shows the expected error in the field.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeSignUp(final String username, final String password, final String confirmation, final String name, final String surname, final String email) {
		this.signUp(username, password, confirmation, name, surname, email);
		super.checkErrorsExist();
	}
}
