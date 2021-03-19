

CASSAVA ERROR REPORT
1)econet-utils
-LOGGER ERROR
Non-static field 'LOGGER' cannot be referenced from a static context
Solution
Declared variable 'LOGGER' changed to a static varible so that it can be used on the static methods

2)electronic-payments-domain
Error
-@PreInsert annotation is not found. This class does not exists in the hibernate persistence library hence the error.
Solution
Replaced @PreInsert with @PrePersist

3) electronic-payments-domain
Error
Named query is incorrect. 
Solution
When writing a named query, the select query should include the correct classname. Replaced Request with SubscriberRequest.

4)electronic-business-payments
Error1: Missing econet-utils dependency
Error2: Sytanx error when calling super method inside constructor.

Solution
Imported the econet-utils dependency in the pom file.
Corrected the syntanx error.

5)electronic-business-payments
Error1: Used subscriberRequestDao.persist() to save SubscriberRequest. The persist() method is not defined in subscriberRequestDao repository.
Error2: Used subscriberRequestDao.update() to update SubscriberRequest. The update() method is not defined in subscriberRequestDao repository.

Solution
Used the save() of subscriberRequestDao repository to save/insert and update SubscriberRequest.

6)electronic-business-payments
Error1: persist method not found
Error2: update methos not found

7)electronic-payments-api
Error2: Request Interceptor Error. and instead of (&&)
Solution: replaced and with &&

8)log4j2.xml Error
Error1: log path error
Solution: Fixed the configuration


  
9)intelligent-network-api
log4j dependencies not found, however added log4j in pom file with the same version as parent module.
path variable partnerCode was not passed as parameter on method enquireAirtimeBalance. However added the path variable

11)electronic-payments-api
Added @Autowired annotation in EpayResource for EpayRequestProcessor & ReportingProcessor

12)intelligent-network-api
partnerCode parameter not annotated





