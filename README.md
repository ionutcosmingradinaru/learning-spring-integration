# Spring Integration: Getting Started

This is a demo project for understanding Spring Integration.
Using the start project from "Spring Integration: Getting Started" PluralSight course by Jesper de Jong.

### Building

Build the application using one of the following commands:

    ./mvnw clean install

### Running

Run the application using one of the following commands:

    ./mvnw spring-boot:run

When the application has started, point your browser to: http://localhost:8080
Select a ticket type, fill in the registration form and click the "Register" button.

Then go to the H2 Console at: http://localhost:8080/h2-console
Use JDBC URL: `jdbc:h2:mem:globomantics`, username: `sa`, and no password to connect to the in-memory H2 database.

You will see records in the tables `ATTENDEES` and `ATTENDEE_TICKETS`.
