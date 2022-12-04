# Read Me

This application answers both question 1 & question 3 of the given test.

System Requirements
  - Maven
  - Java 17

To compile please run
```
mvn clean compile
```
## Question 1

Please see com.sojern.techtest.utils.VersionUtils for implementation and com.sojern.techtest.utils.VersionUtilsTest for test cases.

Fairly straight forward given the assumptions and the use of the library. 
Was unsure whether or not to use the library to achieve the solution but as it was fairly standard practise I didn't see the harm, 
and being honest would encourage the use of tried and tested libraries over implementing custom solutions.  
This would allow developers to focus on business logic and not waste time implementing functionality that comes free.

## Question 3 

File paths for both the `img` and the `ping` are both configurable using spring properties as opposed to hardcoded.

Both configured endpoint have been given cached capabilities in an effort to make the application more efficient for concurrent users. 

The `/ping` endpoint uses an in memory object which acts as a cache and after 15 minutes it invalidates the object and checks if the file is there.
This approach was chosen as the file was stored in the /tmp/ directory and I considered it safe to assume 
wouldn't be a deleted resource but to be safe would reevaluate every 15 minutes 

The `/img` endpoint utilises spring cache functionality. As this img is fully under system control as a local resource and unchanging it could be safely cached upon first request.

A log interceptor has been implemented to ensure all requests are logged.
