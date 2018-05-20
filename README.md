Make Your Selenium Suite Faster and Reliable: Test Setup with REST APIs
=======================================================================
This project is an example of building a test automation framework using WebDriver, Java, TestNG, Maven with InteliJ (or Eclipse).

There are a several of key concepts demonstrated in this project:

- Page Objects Pattern
- Test setup using OkHttp
- Test setup and clean up using Rest api calls  
- Organized Selenium WebDriver setup
- Using TestNG and Maven to run the tests

Please contact me if you have any questions or suggestions.

Summary
=======
Performance is one of the main painful areas of Selenium suits. Usually, engineers trying to login, logout, navigate, create data, execute an action from the UI via Selenium, then, in the end, performing test assertions. This creates serious performance issue for the Selenium suite and makes Selenium tests more brittle. Also, the problem solution could be better if the test data creation and deletion also will be done before Selenium will open the browser. This will help to create independent tests later to be able to run them in parallel.
