Feature: Customer navigation through product categories: Phones, Laptops and Monitors

  @wip
  Scenario:
    Given Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
    When Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    And Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
    And Click on "Place order".
    And Fill in all web form fields.
    And Click on "Purchase".
    And Capture and log purchase Id and Amount.
    And Assert purchase amount equals expected.
    Then Click on "Ok".