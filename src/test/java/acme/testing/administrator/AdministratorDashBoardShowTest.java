
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

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		//super.setAutoPausing(true);

		this.navigateHome();
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (initial)");
		super.clickOnMenu("Administrator", "Populate DB (samples)");

	}

	
	@ParameterizedTest
	@CsvFileSource(resources = "/dashboard/DashBoardBien.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positiveShowDashBoard(final String numberOfPrivateTasks, final String numberOfPublicTasks, final String numberOfFinishedTasks, final String numberOfNonFinishedTasks, final String avgWorkload, final String minWorkload,
		final String maxWorkload, final String devWorkload, final String avgPeriod, final String minPeriod, final String maxPeriod, final String devPeriod) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");
		super.checkInputBoxHasValue("numberOfPrivateTasks", numberOfPrivateTasks);
		super.checkInputBoxHasValue("numberOfPublicTasks", numberOfPublicTasks);
		super.checkInputBoxHasValue("numberOfFinishedTasks", numberOfFinishedTasks);
		super.checkInputBoxHasValue("numberOfNonFinishedTasks", numberOfNonFinishedTasks);
		super.checkInputBoxHasValue("avgWorkload", avgWorkload);
		super.checkInputBoxHasValue("devWorkload", devWorkload);
		super.checkInputBoxHasValue("minWorkload", minWorkload);
		super.checkInputBoxHasValue("maxWorkload", maxWorkload);
		super.checkInputBoxHasValue("avgPeriod", avgPeriod);
		super.checkInputBoxHasValue("devPeriod", devPeriod);
		super.checkInputBoxHasValue("minPeriod", minPeriod);
		super.checkInputBoxHasValue("maxPeriod", maxPeriod);

	}
	
//	@ParameterizedTest
//	@CsvFileSource(resources = "/dashboard/DashBoardMal.csv", encoding = "utf-8", numLinesToSkip = 1)
//	public void negativeShowDashBoard(final String numberOfPrivateTasks, final String numberOfPublicTasks, final String numberOfFinishedTasks, final String numberOfNonFinishedTasks, final String avgWorkload, final String minWorkload,
//		final String maxWorkload, final String devWorkload, final String avgPeriod, final String minPeriod, final String maxPeriod, final String devPeriod) {
//		super.signIn("administrator", "administrator");
//		super.clickOnMenu("Administrator", "Dashboard");
//		super.checkInputBoxHasValue("numberOfPrivateTasks", numberOfPrivateTasks);
//		super.checkInputBoxHasValue("numberOfPublicTasks", numberOfPublicTasks);
//		super.checkInputBoxHasValue("numberOfFinishedTasks", numberOfFinishedTasks);
//		super.checkInputBoxHasValue("numberOfNonFinishedTasks", numberOfNonFinishedTasks);
//		super.checkInputBoxHasValue("avgWorkload", avgWorkload);
//		super.checkInputBoxHasValue("devWorkload", devWorkload);
//		super.checkInputBoxHasValue("minWorkload", minWorkload);
//		super.checkInputBoxHasValue("maxWorkload", maxWorkload);
//		super.checkInputBoxHasValue("avgPeriod", avgPeriod);
//		super.checkInputBoxHasValue("devPeriod", devPeriod);
//		super.checkInputBoxHasValue("minPeriod", minPeriod);
//		super.checkInputBoxHasValue("maxPeriod", maxPeriod);
//		super.checkErrorsExist("numberOfPrivateTasks");
//
//	}


}
