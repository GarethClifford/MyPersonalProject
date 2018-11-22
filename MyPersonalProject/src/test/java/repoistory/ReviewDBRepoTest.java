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

import com.qa.persistence.domain.Recipes;
import com.qa.persistence.domain.Reviews;
import com.qa.persistence.repository.RecipeDBRepo;
import com.qa.persistence.repository.ReviewDBRepo;
import com.qa.util.JSONUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(MockitoJUnitRunner.class)
public class ReviewDBRepoTest {
	
	@InjectMocks
	private ReviewDBRepo repo;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	private String actual;
	private static ExtentTest test;
	private static ExtentReports report;

	
	private final String MOCK_DATA_ARRAY = "[{\"reviewRating\":2,\"reviewComments\":\"Horrible\"}]";
	private final String MOCK_DATA = "{\"reviewRating\":2,\"reviewComments\":\"Horrible\"}";
	private final String MOCK_DATA2 = "{\"reviewRating\":2,\"reviewComments\":\"Bad\"}";
	
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
	public void getAllReviewsTest() {
		test = report.startTest("Testing get all reviews");
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Reviews> review = new ArrayList<Reviews>();
		review.add(new Reviews(2l,"Horrible"));
		Mockito.when(query.getResultList()).thenReturn(review);
		if(query.getResultList().equals(review)) {
			test.log(LogStatus.PASS, "Get all recipes test has passed");
		} else {
			test.log(LogStatus.FAIL, "Get all recipes test has failed");
		}	
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllReviews());
	}
	
	@Test
	public void createReviewTest() {
		test = report.startTest("Testing create review");
		actual = repo.createReview(MOCK_DATA);
		if(actual.equals("{\"message\": \"Review successfully created\"}")) {
			test.log(LogStatus.PASS, "Creating a review test has passed");
		} else {
			test.log(LogStatus.FAIL, "Creating a review test has failed");
		}	
		Assert.assertEquals("{\"message\": \"Review successfully created\"}", actual);
	}
	
	@Test
	public void updateReviewtest() {
		test = report.startTest("Testing update function");
		Reviews review = new Reviews(2l, "Horrible");
		Mockito.when(em.find(Reviews.class, 1L)).thenReturn(review);	
		if(repo.updateReview(MOCK_DATA2, 1L).equals("{\"message\": \"Review sucecssfully updated\"}")) {
			test.log(LogStatus.PASS, "Updating a review test has passed");
		} else {
			test.log(LogStatus.FAIL, "Updating a review test has failed");
		}
		assertEquals("{\"message\": \"Review successfully updated\"}", repo.updateReview(MOCK_DATA2,1L));
	}
	
	@Test
	public void deleteReviewtest() {
		test = report.startTest("Testing delete function");
		Mockito.when(repo.deleteReview(1l)).thenReturn("{\"message\": \"Review successfully deleted\"}");
		if(repo.deleteReview(1L).equals("{\"message\": \"Recipe sucessfully deleted\"}")) {
			test.log(LogStatus.PASS, "Deleting a review test has passed");
		} else {
			test.log(LogStatus.FAIL, "Deleting a review test has failed");
		}
		Assert.assertEquals("{\"message\": \"Review successfully deleted\"}",repo.deleteReview(1l));
	}
	
}
