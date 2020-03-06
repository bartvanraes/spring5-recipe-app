package guru.springframework.bootstrap;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapData(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setPrepTime(10);
        perfectGuacamole.setCookTime(0);
        perfectGuacamole.setServings(4);
        perfectGuacamole.setSource("simplyrecipes.com");
        perfectGuacamole.setDescription("who cares");

        UnitOfMeasure unit = unitOfMeasureRepository.findByDescription("Unit").get();
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash").get();

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guacNotes.setRecipe(perfectGuacamole);
        perfectGuacamole.setNotes(guacNotes);

        Ingredient advocados = new Ingredient("Advocado", new BigDecimal(2), unit, perfectGuacamole);

        perfectGuacamole.getIngredients().add(advocados);

        Ingredient salt = new Ingredient("salt, more to taste", new BigDecimal(0.25), teaspoon, perfectGuacamole);

        perfectGuacamole.getIngredients().add(salt);

        Ingredient limeJuice = new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoon, perfectGuacamole);

        perfectGuacamole.getIngredients().add(limeJuice);

        Ingredient redOnion = new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon, perfectGuacamole);

        perfectGuacamole.getIngredients().add(redOnion);

        Ingredient serranoChiles = new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), unit, perfectGuacamole);

        perfectGuacamole.getIngredients().add(serranoChiles);

        Ingredient cilantro = new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoon, perfectGuacamole);

        perfectGuacamole.getIngredients().add(cilantro);

        Ingredient blackPepper = new Ingredient("freshly grated black pepper", new BigDecimal(1), dash, perfectGuacamole);

        perfectGuacamole.getIngredients().add(blackPepper);

        Ingredient tomato = new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), unit, perfectGuacamole);

        perfectGuacamole.getIngredients().add(tomato);

        Ingredient radish = new Ingredient("Red radishes or jicama, to garnish", new BigDecimal(1), unit, perfectGuacamole);

        perfectGuacamole.getIngredients().add(radish);

        Ingredient torillaChips = new Ingredient("Tortilla chips, to serve", new BigDecimal(1), unit, perfectGuacamole);

        perfectGuacamole.getIngredients().add(torillaChips);

        recipeRepository.save(perfectGuacamole);

        /*
        private String description;
        private Integer prepTime;
        private Integer cookTime;
        private Integer servings;
        private String source;
        private String url;
        private String directions;
         */
    }
}
