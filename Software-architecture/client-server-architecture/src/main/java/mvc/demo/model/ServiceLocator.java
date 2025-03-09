package mvc.demo.model;

import java.util.Map;

public class ServiceLocator {
  private static final Map<String, Service> services = new java.util.HashMap<>();

  public static void register(String name, Service service) {
    services.put(name, service);
  }

  public static Service getService(String name) {
    return services.get(name);
  }
}
