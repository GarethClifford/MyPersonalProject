package repoistory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Users;
import com.qa.persistence.repository.UserDBRepo;
import com.qa.util.JSONUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(MockitoJUnitRunner.class)
public class UserDBRepoTest {
	
	@InjectMocks
	private UserDBRepo repo;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	private String actual;
	private static ExtentTest test;
	private static ExtentReports report;

	
	private final String MOCK_DATA_ARRAY = "[{\"userName\":\"Gareth\"}]";
	private final String MOCK_DATA = "{\"userName\":\"Gareth\"}";
	private final String MOCK_DATA2 = "{\"userName\":\"Andrew\"}";
	
	@BeforeClass
	public static void settingUp() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\ProjectReport\\ReviewReport.html", true);
		test = report.startTest("Project testing");
	}
	
	@AfterClass
	public static void tearingDown() {
		report.flush();
	}
	
	@Before
	public void setUp() {
		repo.setManager(em);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@After
	public void tearDown() {
		report.endTest(test);
	}
	
	@Test
	public void getAllUsersTest() {
		test = report.startTest("Testing get all users");
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Users> user = new ArrayList<Users>();
		user.add(new Users("Gareth"));
		Mockito.when(query.getResultList()).thenReturn(user);
		if(query.getResultList().equals(user)) {
			test.log(LogStatus.PASS, "Get all users test has passed");
		} else {
			test.log(LogStatus.FAIL, "Get all users test has failed");
		}	
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllUsers());
	}
	
	@Test
	public void createUsersTest() {
		test = report.startTest("Testing create user");
		actual = repo.createUser(MOCK_DATA);
		if(actual.equals("{\"message\": \"User sucessfully created\"}")) {
			test.log(LogStatus.PASS, "Creating a user test has passed");
		} else {
			test.log(LogStatus.FAIL, "Creating a user test has failed");
		}	
		Assert.assertEquals("{\"message\": \"User sucessfully created\"}", actual);
	}
	
	@Test
	public void updateUserTest() {
		test = report.startTest("Testing update function");
		Users user = new Users("Gareth");
		Mockito.when(em.find(Users.class, 1L)).thenReturn(user);	
		if(repo.updateUser(MOCK_DATA2, 1L).equals("{\"message\": \"Review sucessfully updated\"}")) {
			test.log(LogStatus.PASS, "Updating a review test has passed");
		} else {
			test.log(LogStatus.FAIL, "Updating a review test has failed");
		}
		assertEquals("{\"message\": \"User sucessfully updated\"}", repo.updateUser(MOCK_DATA2,1L));
	}
	
	@Test
	public void deleteUsertest() {
		test = report.startTest("Testing delete function");
		Mockito.when(repo.deleteUser(1l)).thenReturn("{\"message\": \"User successfully deleted\"}");
		if(repo.deleteUser(1L).equals("{\"message\": \"User sucessfully deleted\"}")) {
			test.log(LogStatus.PASS, "Deleting a user test has passed");
		} else {
			test.log(LogStatus.FAIL, "Deleting a user test has failed");
		}
		Assert.assertEquals("{\"message\": \"User sucessfully deleted\"}",repo.deleteUser(1l));
	}
	
}
