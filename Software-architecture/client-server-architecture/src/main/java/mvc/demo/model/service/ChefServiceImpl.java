package mvc.demo.model.service;

import java.util.List;
import mvc.demo.model.repository.FridgeRepository;

public class ChefServiceImpl implements ChefService {
  private final FridgeRepository fridgeRepository;

  public ChefServiceImpl(FridgeRepository fridgeRepository) {
    this.fridgeRepository = fridgeRepository;
  }

  public Menu prepareMenu(List<String> commandItems) {
    List<String> existentIngredients =
        commandItems.stream().filter(fridgeRepository::hasIngredient).toList();

    return new Menu(existentIngredients);
  }
}
