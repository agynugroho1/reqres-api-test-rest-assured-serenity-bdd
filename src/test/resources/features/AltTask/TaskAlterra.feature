Feature: Alterra Cumcumber Testing

  Scenario Outline: Cucumber Functionality in Alterra
    When I want count <angka1> and <angka2>
    And Using operator "<operator>"
    Then i receive a <hasil> that matches the example
    Examples:
      | angka1 | angka2 | operator | hasil |
      | 1      | 40     | +        | 41 |
      | 15     | 10     | -        | 5  |
      | 5      | 10     | *        | 50 |
      | 10     | 2      | /        | 5  |