
@tag
Feature: Launch DBS URL

  @tag1
  Scenario: Navigations in the website
    Given DBS url is clicked
    And website is loaded completely
    When click on Learn More
    When Scroll down and navigate to Singapore on left panel
    Then Read and write the table in excel sheet

 @tag2
Scenario: Validate and report
    Given Click on About 
    When Click on Who we are
    When Click on Awards and Accolades
    Then Read to number of awards
    Then Print report


