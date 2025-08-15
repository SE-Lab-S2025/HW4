Feature: Calculator

  Scenario Outline: Perform a calculation
    Given the first number is <first_number>
    And the second number is <second_number>
    When the operator is "<operator>"
    Then the result should be <result>

    Examples:
      | first_number | second_number | operator | result |
      | 10           | 5             | +        | 15.0   |
      | 10           | 5             | -        | 5.0    |
      | 10           | 5             | * | 50.0   |
      | 10           | 5             | /        | 2.0    |
      | 10           | 0             | /        | Infinity |