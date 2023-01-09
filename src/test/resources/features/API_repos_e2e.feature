
Feature: End to end API Testing, Create, Get and Delete a repository from a organization in github application


  Scenario: Create a new repository in a GitHub organization
    When Send a Post HTTP request for creating a new repository in a GitHub Organization
    Then Verify the status code is 201 for creating a repo
    Then Verify the response body for creating a repo
    Then verify the headers for creating a repo
  @wip
  Scenario: Get the list of repositories in a GitHub organization
    When Send a Get HTTP request for getting the list of the repositories in the given GitHub Organization
    Then Verify the status code is 200
    Then Verify the response body
    Then Verifty the headers