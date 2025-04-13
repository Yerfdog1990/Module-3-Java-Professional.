package test_quest_app.model;

import java.io.Serializable;

public class Answer extends AbstractEntity implements Serializable {
  private static final long serialVersionUID = 1L;
  private Question from;
  private Question to;

  public Answer(Integer id, String content, Question from, Question to) {
    super(id, content);
    this.from = from;
    this.to = to;
  }

  public Question getFrom() {
    return from;
  }

  public Question getTo() {
    return to;
  }
}
