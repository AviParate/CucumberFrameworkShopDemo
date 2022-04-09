Feature: Cucumber End2End Test
Description: The purpose of this feature is to test End 2 End Integration

Scenario: Customer place an order by purchasing an item from search
Given user is on Home Page
When he search for "dress"
And choose to buy the first item
And moves to checkout from mini mart
And enter personal details on chekout page
And place the order

 