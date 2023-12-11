Feature: Verifying that the Meeting is assigned or not

  
  Scenario: To check whether the Meeting is assigned to the contact under Activities Section
    Given   User must be in a login page and use the demo username & demo password to login
    When    Click on Sales and Marketting and also Click Create contact
    And     Needs to enter our deatils like Firstname, Lastname, address etc,.
    And     If the Contact already exists create new contact
    And     Click Schedule meeting in Activities
    And     Schedule the day and timing for the meeting
    And     After that click contacts in Sales and Marketing
    Then    Verify that the Meeting is assigned to the contact under Activities Section
