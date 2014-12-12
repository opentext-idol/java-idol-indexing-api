Autonomy Non ACI API

This API is for communicating with Autonomy Servers that do not use ACI, for
example IDOL server's index port. The API relies on some third party JAR files
for its operation, these are in the libs folder. There are also a number of
optional JAR files that maybe required for the API to function correctly, 
these are listed below.


HttpClient

This API uses the Apache HttpComponents HttpClient library to do the actual
HTTP communication with the desired Server. There are some JAR files that are 
shipped with the HttpClient distribution that are not used by this API, they 
are included in the libs/httpclient folder for completeness.


Logging

This API uses the Simple Logging Facade for Java (SLF4J), http://www.slf4j.org/
which serves as a simple facade for various logging APIs allowing the end user
to plug in the desired implementation at deployment time.

By default an application should compile against the third party libraries in
the libs folder of the distribution. However, an application will throw an
exception if one on the extra logging libraries from the libs/logging folder
isn't included for application execution.

As a starting point, the SLF4J documentation should be read, especially the
Bridging Legacy APIs article, http://www.slf4j.org/legacy.html. This details
integration with existing logging frameworks and facades such as, Commons
Logging, log4j and JUL.

If your application is simple and a full blown logging framework is overkill,
then you can just put the slf4j-simple-x.x.x.jar file into your application and
all INFO and above logging will be output to the console. Similarly, if you
don't want any logging, then put the slf4j-nop-x.x.x.jar into your application
and you will get no logging.
