package mvc.demo.model.service;

import java.util.List;
import lombok.Data;

@Data
public class Menu {
  private final List<String> items;
}
