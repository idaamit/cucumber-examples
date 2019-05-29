Feature: feature2222

  Scenario Outline: (2)
    Given hi1 <name>
    Then bi1 <price>
    Examples:  example111
      | name | price | description  |
      | KMSY | 29    | description1 |
      | KSFO | 37    | description2 |
      | KSEA | 47    | description3 |
      | KJFK | 40    | description4 |


  Scenario Outline: (3) Taken from production
    Given mock PM <empId>
    When execute PM <empId>
      | media    |
      | metadata |
    Then job status should be <jobResult> for <empId> <siteID>
    Examples:
      | empId | siteID | jobResult | myAmount |
      | 8800  | 1      | COMPLETED | 6        |
