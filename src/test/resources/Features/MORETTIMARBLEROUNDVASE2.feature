Feature: RH Website Verification

  Scenario Outline: MORETTIMARBLEROUNDVASE2
    Given Open Browser in Chrome
    When Open "<Link>" 
    When Pull the text from locators2

    Examples:
      | Link   |
      | https://rh.com/us/en/catalog/product/product.jsp?productId=prod7700049 |
      | https://rh.com/de/de/catalog/product/product.jsp?productId=prod13100134&clientrender=true |
    