/*
 * SignUpTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.springframework.core.annotation.Order;

public class SignUpTest extends AcmeTest {

	// This is a placeholder where you can introduce your own sign-up test
	// Note that it depends on your project-specific test class.

	//	@Override
	//	@BeforeAll
	//	public void beforeAll() {
	//		super.beforeAll();
	//
	//		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
	//		super.setAutoPausing(true);
	//
	//		this.navigateHome();
	//		this.signIn("administrator", "administrator");
	//		super.clickOnMenu("Administrator", "Populate DB (initial)");
	//		this.signOut();
	//	}

	public void signIn(final String username, final String password) {
		super.navigateHome();
		super.clickAndGo(By.linkText("Sign in"));
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.clickOnSubmitButton("Sign in");
		super.checkSimplePath("/master/welcome");
		super.checkLinkExists("Account");

	}

	protected void signOut() {
		super.navigateHome();
		super.clickOnMenu("Sign out", null);
		super.checkSimplePath("/master/welcome");
	}

	protected void signUp(final String username, final String password, final String confirmation, final String name, final String surname, final String email) {
		super.navigateHome();
		super.clickAndGo(By.linkText("Sign up"));
		super.fill(By.id("username"), username);
		super.fill(By.id("password"), password);
		super.fill(By.id("confirmation"), confirmation);
		super.fill(By.id("identity.name"), name);
		super.fill(By.id("identity.surname"), surname);
		super.fill(By.id("identity.email"), email);
		super.clickAndGo(By.id("accept$proxy"));
		super.clickOnSubmitButton("Sign up");
	}

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
	 * Violated constraints: try to register wwith a blank field.
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
