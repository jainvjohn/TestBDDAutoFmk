Feature: Recruitment CRUD operations

  @DryRunRecruitment
  Scenario Outline: Add view and Delete newly added candidate
    Given Navigate to Recruitment page after log in with Admin
    When Add new Candidate with below field and values
      | FieldName  | FieldValue               |
      | FirstName  | Samuel                   |
      | MiddleName | L                        |
      | LastName   | Jackson                  |
      | Email      | samueljacksonv@gmail.com |
    Then I verify that candidate is added with currentDate
    And I delete the searched Candidate

    Examples: 
      | fName  | mName | Lname   |
      | Samuel | L     | Jackson |
