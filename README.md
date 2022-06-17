## Task:
Create an application that provides REST API for the following requests:
  
  1. List of common holidays for the two given countries and the given year: http://localhost:8080/myperfectapp/LV/GB/2021
  2. Result wolud be a list of dates with holiday names for both countries.
  3. As source of data please use the public REST API: https://date.nager.at/
  4. You do not need to cache/load/store data, each request to your REST API can result in request to https://date.nager.at/.
  5. Add swagger.
  6. Add unit tests.

**Non-functional requirements**: Java 11 or >, Spring Boot as framework, Maven as a buld tool.
