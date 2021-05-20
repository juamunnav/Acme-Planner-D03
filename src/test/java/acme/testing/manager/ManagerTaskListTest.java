package acme.testing.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class ManagerTaskListTest extends SignUpTest {

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
    @CsvFileSource(resources = "/task/ManagerListTask.csv", encoding = "utf-8", numLinesToSkip = 1)
    public void listAllVisibleandViewDetails(final int recordIndex, final String end, final String link, final String start, final String text, 
        final String title, final String visibility, final String workload, final String managerId) {
		
		super.signIn("manager01", "manager01");

		super.clickOnMenu("Manager", "List Tasks");
        
        super.checkColumnHasValue(recordIndex, 0, title);
        super.checkColumnHasValue(recordIndex, 1, start);
        super.checkColumnHasValue(recordIndex, 2, end);
        super.checkColumnHasValue(recordIndex, 3, text);
        super.checkColumnHasValue(recordIndex, 4, link);
        super.checkColumnHasValue(recordIndex, 5, workload);

        
        super.clickOnListingRecord(recordIndex);
        
        super.checkInputBoxHasValue("start", start);
        super.checkInputBoxHasValue("end", end);
        super.checkInputBoxHasValue("title", title);
        super.checkInputBoxHasValue("text", text);
        super.checkInputBoxHasValue("link", link);
        super.fillInputBoxIn("visibility", "true");
        super.checkInputBoxHasValue("workLoad", workload);
        
        super.signOut();

	}
}
