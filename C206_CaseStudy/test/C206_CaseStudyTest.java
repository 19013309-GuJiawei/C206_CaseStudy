import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
	private ArrayList<Package> packageList;
	private Package p1;
	private Package p2;

	@Before
	public void setUp() throws Exception {
		
		packageList= new ArrayList<Package>();
		
		p1 = new Package(1, "Package Number 1",  null, null, 100.50);
		p2 = new Package(2, "Package Number 2",  null, null, 10.50);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
		
		
	}
	
	
	
	
	public void addPackageTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid package arraylist to add to", packageList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addPackage(packageList, p1);		
		assertEquals("Test that Package arraylist size is 1", 1, packageList.size());
		assertSame("Test that Package is added", p1, packageList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Test that Package arraylist size is 2", 2, packageList.size());
		assertSame("Test that Package is added", p2, packageList.get(1));
	}
	
	
	public void retrieveAllPackageTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
		
		//test if the list of packages retrieved from the SourceCentre is empty - boundary
		String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = "";
		assertEquals("Check that ViewAllPackagelist", testOutput, allPackage);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Test that Package arraylist size is 2", 2, packageList.size());
		
		//test if the expected output string same as the list of package retrieved from the SourceCentre	
		allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","1", "Package Number 1", "null", "null", "100.50");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","2", "Package Number 2", "null", "null", "10.50" );
	
		assertEquals("Test that ViewAllPackage", testOutput, allPackage);
		
	}
	
	
	public void updatePackageTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addPackage(packageList, p1);

		
		// Update one of the package's information
		packageList.get(0).setDescription("This is updated Package Number 1");
		packageList.get(0).setAmount(400);
		
		//Test if the expected output string is the updated list of package in the SourceCentre
		String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","1", "This is updated Package Number 1", "null", "null", "400");
		
		assertEquals("Test that updatePackage", testOutput, allPackage);
	}
	
	

}
