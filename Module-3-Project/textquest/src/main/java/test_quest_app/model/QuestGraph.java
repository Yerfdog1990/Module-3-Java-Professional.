package test_quest_app.model;

import lombok.Data;

@Data
public class QuestGraph {
  private final Quest currentQuest;
  private final Quest rightQuest;
  private final QuestGraph leftQuest;

  private QuestGraph(Quest currentQuest, Quest rightQuest, QuestGraph leftQuest) {
    this.currentQuest = currentQuest;
    this.rightQuest = rightQuest;
    this.leftQuest = leftQuest;
  }

  public QuestGraph(Quest currentQuest) {
    this(currentQuest, null, null);
  }

  public static QuestGraph instance() {
    Quest youLostYourMemoryRight = new Quest("You rejected the challenge.");
    Quest youLostYourMemoryLeft = new Quest("You lost your memory", "Accept the UFO challenge.");
    return new QuestGraph(youLostYourMemoryLeft, youLostYourMemoryRight, null);
  }
}
