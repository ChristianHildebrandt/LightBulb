LightBulb
=========

Sample Application

The lightbulb sample application project is a work sample for displaying my technical skills. The project is developed and build with Netbeans IDE 8.0.2 and deployed on an Apache TomCat 8.0.9. As persistence unit a h2 database is used as you can see in the persistence.xml For JPA support hibernate libraries are used, for JSF the standard javax implementation is used. Maven was choosen as build tool and as you can imagine - git for version control.

The Application itself shows how a JPA/JSF application can be developed without using a heavy application server like JBoss or WebSphere. A clickable lightbulb image is shown on the index page where the last switch state is got from the database. The bean also is session scoped to reduce the communication between backend and frontend. Per click the light is toggled and a switch is written into the database. The last 5 switches are shown in a table below the image.

Architecture:

Data access objects and their interfaces are used to realize the bridge between a model object and a database object. In this special case both are the same - a model equals an entity.

For the business logic a singleton (instance - can also be done as enum) service is used. Its interface can also be used for developing/generating web services for other client applications (would be step 2). Note: The next step for populating the funcionality of the service could be implementing it as webservice. I also entertained the idea of developing a second (android) client application with use of that webservice. Therefore a library named ksoap2-android would be used to do a lightweight and efficient android via SOAP to server communication. 

As frontend i decided to use JSF with page beans and xhtml pages. JSF is an easy to use frontend framework and for this kind of application sufficient. 

I hope this application gives you an idea of what is possible with low cost and leightweight components in a short time window (over christmas days everybody is busy).
