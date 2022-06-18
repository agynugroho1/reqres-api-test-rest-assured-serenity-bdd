Feature: API Reqres.in

  Scenario: REGISTER User (success)
    When I send POST Request for "Register" with body "register.json"
    Then The response status code is 200
    And response body should be with jsonSchema "register.json"

  Scenario: Unsuccess REGISTER User without password
    When I send POST Request for "Register" with body "unsuccess-register.json"
    Then The response status code is 400
    And response body with jsonPath "error" should be equal "Missing password"
    And response body should be with jsonSchema "unsuccess-register-or-login.json"

  Scenario: Login User (success)
    When I send POST Request for "Login" with body "login.json"
    Then The response status code is 200
    And response body should be with jsonSchema "login.json"

  Scenario: unsuccess LOGIN User without password
    When I send POST Request for "Login" with body "unsuccess-login.json"
    Then The response status code is 400
    And response body with jsonPath "error" should be equal "Missing password"
    And response body should be with jsonSchema "unsuccess-register-or-login.json"

  Scenario: GET Single User
    When I send GET Single User with id 2
    Then The response status code is 200
    And response body with jsonPath "data.id" should be equal 2
    And response body with jsonPath "data.email" should be equal "janet.weaver@reqres.in"
    And response body should be with jsonSchema "single-user.json"
  
  Scenario: CREATE User
    When I send POST Request for "Create" with body "create-user.json"
    Then The response status code is 201
    And response body should be with jsonSchema "create-user.json"

  Scenario: UPDATE User
    Given Set user id is 2
    When I send PUT Request with body "update-user.json"
    Then The response status code is 200
    And response body should be with jsonSchema "update-user.json"
    
  Scenario: DELETE Single User
    When I send DELETE by selecting id 2
    Then The response status code is 204

