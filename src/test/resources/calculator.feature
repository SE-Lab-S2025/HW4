Feature: Calculator
  As a user
  I want to perform arithmetic operations
  So that I can get the correct result

  Scenario Outline: Perform a valid calculation
    Given the first number is <first_number>
    And the second number is <second_number>
    When I perform the calculation with the "<operator>" operator
    Then the result should be <result>

    Examples: Basic Operations
      | first_number | second_number | operator | result |
      | 10           | 5             | +        | 15.0   |
      | 10           | 5             | -        | 5.0    |
      | 10           | 5             | * | 50.0   |
      | 10           | 5             | /        | 2.0    |

    Examples: Edge Cases and Negative Numbers
      | first_number | second_number | operator | result   |
      | 10           | 0             | /        | Infinity |
      | 5            | 0             | +        | 5.0      |
      | 5            | 0             | * | 0.0      |
      | -10          | 5             | * | -50.0    |
      | -10          | -5            | +        | -15.0    |
      | 10           | -5            | -        | 15.0     |

  Scenario: Attempting a calculation with an invalid operator
    Given the first number is 10
    And the second number is 5
    When I perform the calculation with the "^" operator
    Then the operation should fail with an error