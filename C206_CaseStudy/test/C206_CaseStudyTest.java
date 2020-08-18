import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Appointment a1;
	private Appointment a2;
	private Appointment a3;
	private ArrayList<Appointment> appointmentList;
	private static final DateTimeFormatter date_format = DateTimeFormatter.ofPattern("d/MM/yyyy");
	private static final DateTimeFormatter time_format = DateTimeFormatter.ofPattern("H:mm");

	@Before
	public void setUp() throws Exception {
		// jiawei
		LocalDate localDate1 = LocalDate.parse("20/08/2020", date_format);
		LocalTime localtime1 = LocalTime.parse("20:00", time_format);

		LocalDate localDate2 = LocalDate.parse("24/08/2020", date_format);
		LocalTime localtime2 = LocalTime.parse("15:00", time_format);

		a1 = new Appointment(localDate1, localtime1, "Tim", "Address1", "Customer1");
		a2 = new Appointment(localDate2, localtime2, "Tom", "Address2", "Customer2");
		
		appointmentList = new ArrayList<Appointment>();
	}
	
	@Test
	public void addAppointmentTest() {
		// appointment list is not null, so that can add a new appointment
		assertNotNull("Test if there is valid Appointment arraylist to add to", appointmentList);

		// Given an empty list, after adding 1 appointment, the size of the list is 1
		C206_CaseStudy.addAppointment(appointmentList, a1);
		assertEquals("Test if that Appointment arraylist size is 1?", 1, appointmentList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that the and Appointment is added same as 1st item of the list?", a1, appointmentList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addAppointment(appointmentList, a2);
		assertEquals("Test Appointment arraylist size is 2?", 2, appointmentList.size());
	}
	
	

	@After
	public void tearDown() throws Exception {
		a1 = null;
		a2 = null;
		a3 = null;
		appointmentList = null;
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

}