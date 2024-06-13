Feature: login in app example

 @demo
 Scenario: Verification the correct login
   Given the daniel enter credential
   When the user logon with success
   Then he should see products