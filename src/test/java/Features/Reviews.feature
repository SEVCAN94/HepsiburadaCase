@2.1-Review

Feature: Login and Review an Order
  Scenario: Click Yes Icon for First Review of Product
    * Navigate to https://www.hepsiburada.com/
    * Enter iphone parameter to search box
    * Click list item called iphone 11
    * Wait for 1
    * Click product item called iPhone 11 128 GB
    * Wait for 1
    * Switch Page 1
    * Wait for 1
    * Hover over navigation tab Değerlendirmeler
    * Wait for 1
    * Click Yes icon for first comment
    * Wait for 1
    * Verify Teşekkür Ederiz. text displayed
    * Wait for 1

@2.2-SortDropdown

  Scenario: List of Sort Module
    * Navigate to https://www.hepsiburada.com/
    * Enter iphone parameter to search box
    * Click list item called iphone 11
    * Wait for 1
    * Click product item called iPhone 11 128 GB
    * Wait for 1
    * Switch Page 1
    * Wait for 1
    * Hover over navigation tab Değerlendirmeler
    * Wait for 1
    * Click sort dropdown
    * Wait for 1
    * List of dropdown elements:
