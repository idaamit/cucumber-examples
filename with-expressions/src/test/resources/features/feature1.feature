Feature: feature1111

  Scenario: (1)
#    The following Given doesn't work in Cucumber 3.0.2 will be retested in Cucumber verion 4.x
#    Given the following colors are available
#    | RED |
    Given the price list for an international coffee shop
      | name | price |
      | KMSY | 29    |
      | KSFO | 37    |
      | KSEA | 47    |
      | KJFK | 40    |
    Given I have 3 RED balls
    Given We have 4 cookies in my belly
    Given I have 42 cucumbers in my belly
    Given I have 1 cucumber in my stomach
    Then the result should be 123
