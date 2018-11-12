package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Recipes;
import com.qa.util.JSONUtil;



@Transactional(SUPPORTS)
@Default
public class RecipeDBRepo implements IRecipeDBRepo{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IRecipeDBRepo#createRecipe(java.lang.String)
	 */
	@Override
	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		Recipes r = util.getObjectforJSON(recipe, Recipes.class);
		em.persist(r);

		return "{\"message\": \"Recipe successfully created\"}";
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IRecipeDBRepo#searchRecipe(java.lang.Long)
	 */
	@Override
	public Recipes searchRecipe(Long id) {
		return em.find(Recipes.class, id);
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IRecipeDBRepo#getAllRecipes()
	 */
	@Override
	public String getAllRecipes() {
		Query query = em.createQuery(("SELECT r FROM Recipes r"));
		Collection<Recipes> recipes = (Collection<Recipes>) query.getResultList();
		return util.getJSONForObject(recipes);
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IRecipeDBRepo#updateRecipe(java.lang.String, java.lang.Long)
	 */
	@Override
	@Transactional(REQUIRED)
	public String updateRecipe(String recipe, Long id) {
		Recipes newInfo = util.getObjectforJSON(recipe, Recipes.class);
		Recipes oldInfo = em.find(Recipes.class, id);

		oldInfo.setRecipeName(newInfo.getRecipeName());
		oldInfo.setRecipeIngredients(newInfo.getRecipeIngredients());
		oldInfo.setRecipeMethod(newInfo.getRecipeMethod());

		return "{\"message\": \"Recipe sucessfully updated\"}";
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IRecipeDBRepo#deleteRecipe(java.lang.Long)
	 */
	@Override
	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		if (em.find(Recipes.class, id) != null) {
			em.remove(id);
			return "{\"message\": \"Recipe sucessfully deleted\"}";
		} else
			return "{\"message\": \"Recipe not found\"}";
	}

}
