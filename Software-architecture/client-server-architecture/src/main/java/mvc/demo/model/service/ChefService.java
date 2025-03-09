package mvc.demo.model.service;

import java.util.List;
import mvc.demo.model.Service;

public interface ChefService extends Service {
  Menu prepareMenu(List<String> commandItems);
}
