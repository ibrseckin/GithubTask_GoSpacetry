
# Github Api and UI Automation Task


This project is for automating the api testing of creating getting and deleting a repository, and UI testing of creating a new repository for a github account.


## API Task

#### Scenario 1 : Create a new repository in a GitHub organization

```http
  o Validate the response
```


#### Scenario 2 : Get the list of repositories in a GitHub organization

```http
  o Validate the response
  o Validate that the created repository in step #1 exist in the list
```



#### Scenario 3 : Delete a repository in a GitHub organization


```http
  o Could be the same repository that was created in step #1
  o Validate the response
```


## UI Task

#### Scenario : Create a new repository in a GitHub organization

```http
  - GitHub user sign in scenario
  - Getting the list of user’s repositories
  - Creating a new repository and validating the creation by revisiting the list of repositories
after adding a new one into the list.
```
  
## Tools Used in The Project

**Framework:** ________Cucumber BDD

**Design Patterns:** ____Page Object Model, Singleton

**Structures:** _________ConfigurationReader, Environment, Driver utility


  
## Run

For executing the tests, 

1- 'verify' or 'test' button can be used under the maven life cycle.

2- 'Run' button in the 'CukesRunner' class can be used, it's under the 'runner' package.

3- or this code can be used for executing all tests in the run everything terminal.

```bash
  mvn test
```

  