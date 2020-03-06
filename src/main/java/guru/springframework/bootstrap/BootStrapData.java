package guru.springframework.bootstrap;

import guru.springframework.domain.Ingredient;
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

        Ingredient advocados = new Ingredient();
        advocados.setAmount(new BigDecimal(2));
        advocados.setDescription("Advocado");
        advocados.setUom(unit);

        perfectGuacamole.getIngredients().add(advocados);

        Ingredient salt = new Ingredient();
        salt.setAmount(new BigDecimal(0.25));
        salt.setDescription("salt, more to taste");
        salt.setUom(teaspoon);

        perfectGuacamole.getIngredients().add(salt);

        Ingredient limeJuice = new Ingredient();
        limeJuice.setAmount(new BigDecimal(1));
        limeJuice.setDescription("fresh lime juice or lemon juice");
        limeJuice.setUom(tablespoon);

        perfectGuacamole.getIngredients().add(limeJuice);

        Ingredient redOnion = new Ingredient();
        redOnion.setAmount(new BigDecimal(2));
        redOnion.setDescription("minced red onion or thinly sliced green onion");
        redOnion.setUom(tablespoon);

        perfectGuacamole.getIngredients().add(redOnion);

        Ingredient serranoChiles = new Ingredient();
        serranoChiles.setAmount(new BigDecimal(2));
        serranoChiles.setDescription("serrano chiles, stems and seeds removed, minced");
        serranoChiles.setUom(unit);

        perfectGuacamole.getIngredients().add(serranoChiles);

        Ingredient cilantro = new Ingredient();
        cilantro.setAmount(new BigDecimal(2));
        cilantro.setDescription("cilantro (leaves and tender stems), finely chopped");
        cilantro.setUom(tablespoon);

        perfectGuacamole.getIngredients().add(cilantro);

        Ingredient blackPepper = new Ingredient();
        blackPepper.setAmount(new BigDecimal(1));
        blackPepper.setDescription("freshly grated black pepper");
        blackPepper.setUom(dash);

        perfectGuacamole.getIngredients().add(blackPepper);

        Ingredient tomato = new Ingredient();
        tomato.setAmount(new BigDecimal(0.5));
        tomato.setDescription("ripe tomato, seeds and pulp removed, chopped");
        tomato.setUom(unit);

        perfectGuacamole.getIngredients().add(tomato);

        Ingredient radish = new Ingredient();
        radish.setAmount(new BigDecimal(1));
        radish.setDescription("Red radishes or jicama, to garnish");
        radish.setUom(unit);

        perfectGuacamole.getIngredients().add(radish);

        Ingredient torillaChips = new Ingredient();
        torillaChips.setAmount(new BigDecimal(1));
        torillaChips.setDescription("Tortilla chips, to serve");
        torillaChips.setUom(unit);

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
