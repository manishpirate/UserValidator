## Project Spring-cloud

This is my code repository for some of my practice for the spring cloud. First of all I would like to thank [Frank Moley](https://www.linkedin.com/in/frankmoley/?trk=lil_course) to provide such a wonderful tutorial. Some of the things has changed over the period of time, such as spring cloud server details and have updated those as of the current time. 

Although I have not implemented all the services, you are free to use the code and add modification to that.

Due to some time issue, I was not able to add comments to the code, which is one thing I hate but most of the code is self explanatory. The list of code contains :-

 - Config server
 - guestservice
 - roomservice
 - reservationservice
 - Eureka Server
 - feign client using roomreservationservice project.

Internal H2 database is used for the saving the data. All the data and table schema were provided in the excercise files by Frank. 

Have used the domain entity directly in the web which is not a good practise for the production system but will be good for the learning purpose.

# Project # Spring-Security

This project is to configure the spring security for a rest service. The user is provided a token (JWT Token). This token is generated with the jjwt library. The token is provided via a rest call which has been allowed permission to all. The rest service needs a user name and password for basic authentication for the first time. When the user is authenticated, he can use the JWT token provided in the autorization header for subsequent requests. This is also a mix of some MVC and rest program, the only purpose of this is to show how to create the JWT token and consume the same. 





