Feature: Registration

  Scenario Outline:
    Given I am using <browser> as browser
    Given I have entered date of birth "<date>"
    And I have entered first name "<firstname>"
    And I have entered last name "<lastname>"
    And I have entered email and confirmed email "<email>"
    And I have entered password "<password>"
    And I have "<confirmed>" password
    And I have <status> terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registered and verifies <text>

    Examples:
      | browser | date       |  | firstname | lastname | email                    | password   | confirmed  | status      | text                 |
      | firefox | 01/01/2001 |  | Natta     | Lee      | nattalee456789@gmail.com | nattalee01 | nattalee01 | checked     | registered           |
      | chrome  | 02/02/2002 |  | Nova      |          | nova16@gmail.com         | novalito16 | novalito16 | checked     | missing lastname     |
      | chrome  | 03/03/2003 |  | Mila      | Mila     | mila22@gmail.com         | milamila22 | milamila2  | checked     | wrong password       |
      | firefox | 04/04/2004 |  | Zoran     | Zoran    | zoran83@gmail.com        | zoran83    | zoran83    | not checked | terms and conditions |



