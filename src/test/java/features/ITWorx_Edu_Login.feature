Feature: Super Admin login to the website
  #As a Super Admin, I need to be able to Create course and check the created course
##################################################################
  # Happy Scenario()
  @smoke @regression @hs
  Scenario: 01 - SuperAdmin - login to the WinjiGo website
  #Open the website
    Given I open the Winjigo website
    # login with  super admin
    When I sign in with username and password
    #navigate to the courses screen
    Then I open courses page
    #Clicking on create course button
    And I click on create course button
    #Fill all basic course data and create it
    When I fill course basic info and click save
    #Navigate again to the courses page
    Then I open courses page
    #Check the created course title
    Then I should see the course title displayed on the courses list page