Feature: Employee CRUD and Search Operations

  Scenario Outline: I am able to add new employee
    Given Navigate to PIM after log in with Admin user
    When I Add employee with first name as "<fName>" and mname as "<mName>" and lName as "<Lname>"
    Then I verify employeeAdded in list with first name as "<fName>" and mname as "<mName>" and lName as "<Lname>"

    Examples: 
      | fName         | mName        | Lname        |
      | AutUserFname  | AutUserMname | AutUserLname |

  @DryRun
  Scenario Outline: I am able to add, edit, search and delete the employee
    Given Navigate to PIM after log in with Admin user
    When I Add employee with first name as "<fName>" and mname as "<mName>" and lName as "<Lname>"
    Then I verify employeeAdded in list with first name as "<fName>" and mname as "<mName>" and lName as "<Lname>"
    When I click on Edit button and update below values and save the data
      | updatefNamevalue | 1 |
      | updatedmName     | 1 |
      | updatedLname     | 1 |
    Then I search the employee and ensure that it is searched using below values
      | updatefNamevalue | AutUserFname1 |
      | updatedmName     | AutUserMname1 |
    And I select and delete the Updated Employee and verify Employee is not in search result

    Examples: 
      | fName         | mName        | Lname        |
      | AutUserFname  | AutUserMname | AutUserLname |
