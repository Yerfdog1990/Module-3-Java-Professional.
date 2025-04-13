package test_quest_app.model;

public class Question extends AbstractEntity {
  private Type type;

  public Question(Integer id, String content, Type type) {
    super(id, content);
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public enum Type {
    USUAL,
    WON,
    LOST;
  }
}
