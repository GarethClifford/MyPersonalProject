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
import com.qa.persistence.repository.RecipeDBRepo;
import com.qa.util.JSONUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(MockitoJUnitRunner.class)
public class RecipeDBRepoTest {
	
	@InjectMocks
	private RecipeDBRepo repo;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	private String actual;
	private static ExtentTest test;
	private static ExtentReports report;
	
	private final String MOCK_DATA_ARRAY = "[{\"recipeName\":\"Spag Bol\",\"recipeIngredients\":\"Spagetti and mince\",\"recipeMethod\":\"Cook the mince to bolognese and mix with spagetti\",\"userID\":\"1\"}]";
	private final String MOCK_OBJECT = "{\"recipeName\":\"Spag Bol\",\"recipeIngredients\":\"Spagetti and mince\",\"recipeMethod\":\"Cook the mince to bolognese and mix with spagetti\",\"userID\":\"1\"}";
	private final String MOCK_OBJECT_2 = "{\"recipeName\":\"Spag Bol\",\"recipeIngredients\":\"Spagetti and mince\",\"recipeMethod\":\"Cook the mince to bolognese and mix with spagetti\",\"userID\":\"1\"}";
	
	@BeforeClass
	public static void settingUp() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\ProjectReport\\RecipeReport.html", true);
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
	public void getAllRecipesTest() {
		test = report.startTest("Testing get all recipes");
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Recipes> recipe = new ArrayList<Recipes>();
		recipe.add(new Recipes("Spag Bol","Spagetti and mince","Cook the mince to bolognese and mix with spagetti","1"));
		Mockito.when(query.getResultList()).thenReturn(recipe);
		if(query.getResultList().equals(recipe)) {
			test.log(LogStatus.PASS, "Get all recipes test has passed");
		} else {
			test.log(LogStatus.FAIL, "Get all recipes test has failed");
		}	
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllRecipes());
	}
	
	@Test
	public void createRecipeTest() {
		test = report.startTest("Testing create recipes");
		actual = repo.createRecipe(MOCK_OBJECT);
		if(actual.equals("{\"message\": \"Recipe successfully created\"}")) {
			test.log(LogStatus.PASS, "Creating a recipe test has passed");
		} else {
			test.log(LogStatus.FAIL, "Creating a recipe test has failed");
		}	
		Assert.assertEquals("{\"message\": \"Recipe successfully created\"}", actual);
	}
	
	@Test
	public void updateRecipetest() {
		test = report.startTest("Testing update function");
		Recipes recipe = new Recipes("Spag Bol","Spagetti and mince","Cook the mince to bolognese and mix with spagetti","1");
		Mockito.when(em.find(Recipes.class, 1L)).thenReturn(recipe);	
		if(repo.updateRecipe(MOCK_OBJECT_2, 1L).equals("{\"message\": \"Recipe sucessfully updated\"}")) {
			test.log(LogStatus.PASS, "Updating a recipe test has passed");
		} else {
			test.log(LogStatus.FAIL, "Updating a recipe test has failed");
		}
		assertEquals("{\"message\": \"Recipe sucessfully updated\"}", repo.updateRecipe(MOCK_OBJECT_2,1L));
	}
	
	@Test
	public void deleteRecipetest() {
		test = report.startTest("Testing delete function");
		Mockito.when(repo.deleteRecipe(1l)).thenReturn("{\"message\": \"Recipe sucessfully deleted\"}");
		if(repo.deleteRecipe(1L).equals("{\"message\": \"Recipe sucessfully deleted\"}")) {
			test.log(LogStatus.PASS, "Deleting a recipe test has passed");
		} else {
			test.log(LogStatus.FAIL, "Deleting a recipe test has failed");
		}
		Assert.assertEquals("{\"message\": \"Recipe sucessfully deleted\"}",repo.deleteRecipe(1l));
	}
	
}
