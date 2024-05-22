# Playwright-JUnit-Platform-Cucumber
Java Junit platform cucumber concurrent playwright test

To run tests locally use the following command 
 * `mvn clean test -Dbrowser=chromium`

To run the tests on a selenium grid, use the follow command
 * Start distributed docker hub/grid, using the grid.yml file
   * Command to start selenium grid `docker-compose -f grid.yml up`
   * Command to tear down selenium grid `docker-compose -f grid.yml down`

Once Selenium hub grid is running, then use the command below to execute the test
 `DEBUG=pw:browser* SELENIUM_REMOTE_URL=http://localhost:4444 mvn clean test -Dbrowser=chromium`

After the tests have executed, use the following command to produce the report
* `mvn allure:report`
  * The report will be found in the following location 
    * `target/site/allure-maven-plugin/index.html`
