#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Determine abdominal obesity
  I want to determine if I have abdominal obesity according to my waist circumference and gender 
  so that I will know wether I must change my diet and excercise routine.

  @tag1
  Scenario Outline: Correctly determines abdominal obesity
    Given I have a bmi calculator
    When I input my waist circumference of <w> cm
    And I input my gender <g>
    And the system determines abdominal obesity
    Then The system returns <r>
    Examples:
    | w   | g |r    |
    |95.0 |'F'|"true" | 
    |75.0 |'f'|"false"|
	  |75.0 |'M'|"false"|
	  |95.0 |'m'|"true"|

  @tag2
  Scenario Outline: Wrong wait circumference value
    Given I have a bmi calculator
    When I input my waist circumference of <w> cm
    And I input my gender <g>
    Then The system compares an invalid value
    And The calculator throws an exception

    Examples: 
      | w  | g |
      | 80.0 |     's' |
      | 79.0 |     'p' |
