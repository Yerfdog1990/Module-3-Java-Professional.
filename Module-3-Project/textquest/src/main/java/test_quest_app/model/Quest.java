package test_quest_app.model;

import lombok.Data;

@Data
public class Quest {
  private final String description;
  private final String question;

  public Quest(String description, String question) {
    this.description = description;
    this.question = question;
  }
}
