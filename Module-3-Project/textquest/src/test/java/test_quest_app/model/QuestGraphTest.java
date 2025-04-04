package test_quest_app.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
Same fixture for every test, which is the entire QuestGraph
 */
@SuppressWarnings("DataFlowissue")
public class QuestGraphTest {
  private QuestGraph questGraph = QuestGraph.instance();

  @Test
  void firstQuestDescriptionAsExpected() {
    String actualDescription = questGraph.getCurrentQuest().getDescription();
    String expectedDescription = "You lost your memory";
    assertEquals(expectedDescription, actualDescription);
  }

  @Test
  void firstQuestQuestionAsExpected() {
    String actualQuestion = questGraph.getCurrentQuest().getQuestion();
    String expectedQuestion = "Accept the UFO challenge.";
    assertEquals(expectedQuestion, actualQuestion);
  }
}
