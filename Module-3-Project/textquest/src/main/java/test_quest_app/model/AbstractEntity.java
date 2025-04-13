package test_quest_app.model;

public abstract class AbstractEntity {
  private Integer id; // Needed to hold question or answer to quest branches
  private String content; // Needed to hold questions

  public AbstractEntity(Integer id, String content) {
    this.id = id;
    this.content = content;
  }

  public Integer getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
