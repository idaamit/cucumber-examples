Feature: bbbb

  Scenario Outline: an example of scenario
    """
    We have a remarkable remark
    """
    Given hi1 <name>
    Then bi1 <price>
    Examples:
      | example description  | name | price | description |
      | example description  | KMSY | 29    | a           |
      | example description  | KSFO | 37    | v           |
      | example description  | KSEA | 47    | v           |
      | example description  | KJFK | 40    | d           |
