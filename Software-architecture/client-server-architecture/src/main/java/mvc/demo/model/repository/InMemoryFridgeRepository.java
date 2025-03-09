package mvc.demo.model.repository;

import java.util.Collection;
import java.util.List;

public class InMemoryFridgeRepository implements FridgeRepository {
  private final Collection<String> ingredients;

  public InMemoryFridgeRepository() {
    this.ingredients = List.of("sugar", "pepper", "salt", "olive oil");
  }

  @Override
  public boolean hasIngredient(String ingredient) {
    return ingredients.contains(ingredient);
  }
}
