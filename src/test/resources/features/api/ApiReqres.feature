Feature: API Reqres.in

  Scenario: GET List User
    When I send GET List User with page 2
    Then The response status code is 200
    And response body with jsonPath "page" should be equal 2
    And response body should be with jsonSchema "list-user.json"

  Scenario: CREATE User
    When I send POST Request for "Create" with body "create-user.json"
    Then The response status code is 201
    And response body should be with jsonSchema "create-user.json"


