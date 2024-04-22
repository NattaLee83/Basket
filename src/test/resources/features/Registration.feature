Feature: Registration

  Scenario: Successful registration
    Given I have entered date of birth "01/01/2001
    And I have entered first name "Natta"
    And I have entered last name "Lee"
    And I have entered email and confirmed email "nattalee@gmail.com"
    And I have entered password and confirmed password
    And I have checked terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registrered

  Scenario: Missing surname
    And I have entered first name "Natta"
    And I have entered last name ""
    And I have entered email and confirmed email "nattalee@gmail.com"
    And I have entered password and confirmed password
    And I have checked terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registrered

  Scenario: Password does not match
    And I have entered first name "Natta"
    And I have entered last name "Lee"
    And I have entered email and confirmed email "nattalee@gmail.com"
    And I have entered password and confirmed password
    And I have checked terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registrered

  Scenario: Terms and conditions are not approved
    And I have entered first name "Natta"
    And I have entered last name "Lee"
    And I have entered email and confirmed email "nattalee@gmail.com"
    And I have entered password and confirmed password
    And I have checked terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registrered


  #Scenario Outline:
  #Given
  #When
  #Then


    #Examples:
      #| user | value | status |
      #|  |  | fail |



