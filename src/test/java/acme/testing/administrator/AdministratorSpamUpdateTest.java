
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
	/*
	 * Tested Feature: Manager manages the customisation of threshold parameter, which involves displaying and updating it.
	 * Violated constraints: Not applicable.
	 * Expected results: It update the expected element in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveUpdateThreshold(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam threshold");
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Save");

	}
	/*
	 * Tested Feature: Manager manages the customisation of threshold parameter, which involves displaying and updating it.
	 * Violated constraints: Negative threshold.
	 * Expected results: It shows the expected error in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamMal.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void negativeUpdateThreshold(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam threshold");
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Save");
		super.checkErrorsExist("threshold");

	}
	/*
	 * Tested Feature: Manager adds a word to spam words parameter, which involves displaying and updating it.
	 * Violated constraints: Not applicable.
	 * Expected results: It adds the expected word to spam words parameter in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamBienAnyadirPalabraSpam.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveUpdateAddWord(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam words");
		super.fillInputBoxIn("newword", words);
		super.clickOnSubmitButton("Add word");

	}
	/*
	 * Tested Feature: Manager deletes a word of spam words parameter, which involves displaying and updating it.
	 * Violated constraints: Not applicable.
	 * Expected results: It deletes the expected word in spam words parameter in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamBienEliminarPalabraSpam.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveUpdateRemoveWord(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam words");
		super.fillInputBoxIn("newword", words);
		super.clickOnSubmitButton("Remove word");

	}
	/*
	 * Tested Feature: Manager deletes a word of spam words parameter, which involves displaying and updating it.
	 * Violated constraints: Try to delete a word that did not exists in spam words parameter.
	 * Expected results: It shows the expected error in spam words parameter in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamMalEliminarPalabraSpam.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void negativeUpdateRemoveWord(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam words");
		super.fillInputBoxIn("newword", words);
		super.clickOnSubmitButton("Remove word");
		super.checkErrorsExist("newword");
	}
	/*
	 * Tested Feature: Manager deletes a word of spam words parameter, which involves displaying and updating it.
	 * Violated constraints: Try to delete a word whitout filling the newword imput box in spam words parameter.
	 * Expected results: It shows the expected error in spam words parameter in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamMalEliminarPalabraSpam.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void negativeUpdateRemoveWord2(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam words");
		super.fillInputBoxIn("newword", "");
		super.clickOnSubmitButton("Remove word");
		super.checkErrorsExist("newword");
	}
	/*
	 * Tested Feature: Manager adds a word of spam words parameter, which involves displaying and updating it.
	 * Violated constraints: Try to add a word that already exists in spam words parameter.
	 * Expected results: It shows the expected error in spam words parameter in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamMalAnyadirPalabraSpam.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void negativeUpdateAddWord(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam words");
		super.fillInputBoxIn("newword", words);
		super.clickOnSubmitButton("Add word");
		super.checkErrorsExist("newword");
	}
	/*
	 * Tested Feature: Manager adds a word of spam words parameter, which involves displaying and updating it.
	 * Violated constraints: Try to add a word whitout filling the newword imput box in spam words parameter.
	 * Expected results: It shows the expected error in spam words parameter in Spam.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/spam/SpamMalAnyadirPalabraSpam.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void negativeUpdateAddWord2(final String words, final String threshold ) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Update spam words");
		super.fillInputBoxIn("newword", "");
		super.clickOnSubmitButton("Add word");
		super.checkErrorsExist("newword");
	}

}
