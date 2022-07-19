Feature: As admin I want to login, so I can register patients


  Scenario: POST - As admin I want to login with valid id and valid password
    Given admin Post API endpoint
    When admin send POST HTTP request
    Then admin receive valid HTTP response code 200

  Scenario: POST - As admin I want to login with invalid id and valid password
    Given admin Post API endpoint
    When admin send POST HTTP request with invalid id
    Then admin receive HTTP response code 404

  Scenario: POST - As admin I want to login with valid id and invalid password
    Given admin Post API endpoint
    When admin send POST HTTP request with invalid password
    Then admin receive HTTP response code 400

  Scenario: POST - As admin I want to login with invalid id and invalid password
    Given admin Post API endpoint
    When admin send POST HTTP request with invalid id and invalid password
    Then admin receive HTTP response code 404
