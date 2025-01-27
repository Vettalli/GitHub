# GitHub

Tests description. All tests are divided into API and UI groups.

Api tests
Auth test with valid token
Auth test with invalid token
Auth test with empty token
UI tests Browser driver set on chrome driver. The driver is configured automatically. So, there is no need to download chrome(or another browser) driver and store it locally
HomePageTest - Github home page tests
LoginTest - Github login page tests
SearchPageTestt - Github search page tests
UserHomePageTest - Github user home page page tests
There is a description above each test. Also when calling the method logging is used logger.info(description of what the method does).

ToDo:

- move user data to Github variables secrets and get them using env

- send locale as parameter to test (relevant for all tests)

- create tests with different localisations
