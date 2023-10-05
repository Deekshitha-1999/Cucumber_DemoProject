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
Feature: Login
  I want to use this template for my feature file


  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser 
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And  Click on Login
    Then Login Page Title should be "Dashboard / nopCommerce administration"
    When User cick on Log out link
    Then Logout Page Title should be "Your store. Login"   
    And close browser
   Scenario: Login Data Driven
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Login Page Title should be "Dashboard / nopCommerece administration"
    When User cick on Log out link
    Then Logout Page Title should be "Your store. Login"   
    And close browser
    Examples: 
    |email|password|
    |admin@yourstore.com|admin|
    |admin@yourstore.com|admin123|