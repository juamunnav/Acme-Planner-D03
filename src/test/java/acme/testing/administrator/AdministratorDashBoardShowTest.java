
package acme.testing.administrator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class AdministratorDashBoardShowTest extends SignUpTest {

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Starter-Project", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(true);

		this.navigateHome();
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (initial)");
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/dashboard/DashBoardBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveShowDashBoard(final Integer numberOfPublicTasks, final Integer numberOfPrivateTasks, final Integer numberOfFinishedTasks, final Integer numberOfNonFinishedTasks, final Integer avgWorkload, final Integer minWorkload,
		final Integer maxWorkload, final Integer devWorkload, final Integer avgPeriod, final Integer minPeriod, final Integer maxPeriod, final Integer devPeriod) {
		super.clickOnMenu("Administrator", "Dashboard");
		super.checkInputBoxHasValue("numberOfPublicTasks", "numberOfPublicTasks");
		super.checkInputBoxHasValue("numberOfPrivateTasks", "numberOfPrivateTasks");
		super.checkInputBoxHasValue("numberOfFinishedTasks", "numberOfFinishedTasks");
		super.checkInputBoxHasValue("numberOfNonFinishedTasks", "numberOfNonFinishedTasks");
		super.checkInputBoxHasValue("avgWorkload", "avgWorkload");
		super.checkInputBoxHasValue("minWorkload", "minWorkload");
		super.checkInputBoxHasValue("maxWorkload", "maxWorkload");
		super.checkInputBoxHasValue("devWorkload", "devWorkload");
		super.checkInputBoxHasValue("avgPeriod", "avgPeriod");
		super.checkInputBoxHasValue("minPeriod", "minPeriod");
		super.checkInputBoxHasValue("maxPeriod", "maxPeriod");
		super.checkInputBoxHasValue("devPeriod", "devPeriod");
		this.signOut();


	}

	//	@ParameterizedTest
	//	@CsvFileSource(resources = "/sign-up/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	//	@Order(10)
	//	public void positiveSignUp(final String username, final String password, final String name, final String surname, final String email) {
	//		this.signUp(username, password, name, surname, email);
	//		this.signIn(username, password);
	//		assert super.exists(By.linkText("Account"));
	//		this.signOut();
	//	}

}
