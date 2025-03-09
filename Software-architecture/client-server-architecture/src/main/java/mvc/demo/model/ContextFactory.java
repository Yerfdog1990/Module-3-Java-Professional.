package mvc.demo.model;

import mvc.demo.model.repository.InMemoryFridgeRepository;
import mvc.demo.model.service.ChefService;
import mvc.demo.model.service.ChefServiceImpl;

public class ContextFactory {
  public static ChefService getChefService() {
    return new ChefServiceImpl(new InMemoryFridgeRepository());
  }
}
