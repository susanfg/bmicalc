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
Feature: Determine category
  As a user I want to determine my category according to my BMI so that I will know if I am in a healthy category.

  @tag1
  Scenario Outline: Valid category
    Given I have a bmi calculator
    When I input a weight equal to <w>
   	And I input a height equal to <h>
    Then The system calculates the bmi 
    And The system determines the category
    And returns the category <c>
    
		Examples:
   | w   |  h   | c             |
   | 70.0| 1.95 | "UNDERWEIGHT" |
   | 65.0| 1.68 | "NORMAL"      | 
   | 94.6| 1.87 | "OVERWEIGHT"  |
   |100.2| 1.77 | "OBESE"       |
 
