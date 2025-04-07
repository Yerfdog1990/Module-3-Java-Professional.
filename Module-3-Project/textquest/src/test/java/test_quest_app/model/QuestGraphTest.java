package test_quest_app.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/*
Same fixture for every test, which is the entire QuestGraph
 */
@SuppressWarnings("DataFlowissue")
public class QuestGraphTest {
  private QuestGraph questGraph = QuestGraph.instance();

  @Nested
  public class FirstQuestion {
    @Test
    @DisplayName("First quest is the one that was created")
    void firstQuestDescriptionAsExpected() {
      String actualDescription = questGraph.getCurrentQuest().getDescription();
      String expectedDescription = "You lost your memory";
      assertEquals(expectedDescription, actualDescription);
    }

    @Test
    @DisplayName("First quest has a question")
    void firstQuestQuestionAsExpected() {
      String actualQuestion = questGraph.getCurrentQuest().getQuestion();
      String expectedQuestion = "Accept the UFO challenge.";
      assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    @DisplayName("First left quest is null")
    void firstLeftQuestAsExpected() {
      Quest right = questGraph.getRightQuest();
      String actualDescription = right.getDescription();
      String expectedDescription = "You rejected the challenge.";
      assertEquals(expectedDescription, actualDescription);
    }
  }

  @Nested
  class SecondQuestion {}
}
