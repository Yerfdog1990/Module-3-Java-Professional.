package org.example.equalsbuilder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ComparingArrays {
  public static void main(String[] args) {
    PersonalInfo p1 = new PersonalInfo("John", new int[] {1, 2, 3});
    PersonalInfo p2 = new PersonalInfo("John", new int[] {1, 2, 3});
    System.out.println("p1.equals(p2): " + p1.equals(p2));
    System.out.println("p1 == p2: " + (p1 == p2));
    System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
  }
}

class PersonalInfo {
  private String name;
  private int[] scores;

  public PersonalInfo(String name, int[] scores) {
    this.name = name;
    this.scores = scores;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    PersonalInfo other = (PersonalInfo) obj;
    return new EqualsBuilder().append(name, other.name).append(scores, other.scores).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(name).append(scores).toHashCode();
  }
}
/*
Comparison with Arrays
EqualsBuilder provides built-in support for array comparisons, unlike default equals().

Why Use append() for Arrays?
1.Java’s default equals() does not compare array contents (== checks references).
2.EqualsBuilder.append() correctly compares array contents.
 */
