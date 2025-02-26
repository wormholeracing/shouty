Feature: Hear Shout
  
  Shouts have a range of approximately 1000m

  Background: 
    Given Lucy is at 0, 0

  Scenario Outline: only hear in-range shouts
    Given Lucy is at 0, 0
    And Sean is at <Seans-location>
    When Sean shouts
    Then Lucy should hear <what-Lucy-hears>

    Examples: the one where Lucy hears something
      | Seans-location | what-Lucy-hears |
      | 0, 900         | Sean            |

    Examples: the one where Lucy hears nothing
      | Seans-location | what-Lucy-hears |
      | 0, 1100        | nothing         |

  @wip
  Scenario: Multiple shouts from one person
    Given Lucy is at 0, 0
    And Sean is at 0, 500
    When Sean shouts
    And Sean shouts
    Then Lucy should hear 2 shouts from Sean

  Scenario: Multiple shouters
    #Given Lucy is at 0, 0
    And Sean is at 0, 500
    And Oscar is at 1100, 0
    When Sean shouts
    And Oscar shouts
    Then Lucy should not hear Oscar
    But Lucy should hear Sean

  Scenario: Shouters should not hear their own shouts
    #Given Lucy is at 0, 0
    When Lucy shouts
    Then Lucy should hear nothing
