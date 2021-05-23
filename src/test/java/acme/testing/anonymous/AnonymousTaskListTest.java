package acme.testing.anonymous;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.SignUpTest;

public class AnonymousTaskListTest extends SignUpTest {

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
	/*
	 * Tested Feature: Anonymous lists the public tasks that are non-finished (sorted by execution period or workload) 
	 * and Show the details of any public tasks that are non-finished.
	 * Violated constraints: Not applicable.
	 * Expected results: It shows the expected list of Tasks and show the details of each one.
	 */
	@ParameterizedTest
    @CsvFileSource(resources = "/task/AnonymousListTaskBien.csv", encoding = "utf-8", numLinesToSkip = 1)
    public void listAllVisibleandViewDetails(final int recordIndex, final String end, final String link, final String start, final String text, 
        final String title, final String visibility, final String workload, final String managerId) {

		super.clickOnMenu("Anonymous", "List tasks");
    
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
        

	}
       	
}
