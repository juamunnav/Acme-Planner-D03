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
	
	@ParameterizedTest
    @CsvFileSource(resources = "/task/ListTaskBien.csv", encoding = "utf-8", numLinesToSkip = 1)
    public void listAllVisibleandViewDetails(final int recordIndex,final String title, final String start, final String end, final String text, 
        final String link, final String visibility, final String workload, final String manager) {

		super.clickOnMenu("Anonymous", "List tasks");

		super.clickOnListingRecord(recordIndex);
		
//      super.checkColumnHasValue(recordIndex, 0, title);
//      super.checkColumnHasValue(recordIndex, 1, start);
//		super.checkColumnHasValue(recordIndex, 2, end);
//		super.checkColumnHasValue(recordIndex, 3, text);
//		super.checkColumnHasValue(recordIndex, 4, link);
//		super.checkColumnHasValue(recordIndex, 5, workload);
	}
       	
}
