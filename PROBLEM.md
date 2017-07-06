Implement a simple ticket service that facilitates the discovery, temporary hold, and final reservation of seats within a high-demand performance venue.

For example, see the seating arrangement below:


                 ----------[[ STAGE ]]----------

                ---------------------------------

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

                sssssssssssssssssssssssssssssssss

Your homework assignment is to design and write a Ticket Service that provides the following functions:

- Find the number of seats available within the venue
    - NOTE: available seats are seats that are neither held nor reserved.

- Find and hold the best available seats on behalf of a customer.
    - NOTE: each ticket should expire within a set number of seconds.

- Reserve and commit a specific group of held seats for a customer


### Requirements

- The ticket service implementation should be written in Java
- The solution and tests should build and execute entirely via the command line using either Maven or Gradle as the build tool
- A README file should be included in your submission that documents your assumptions and includes instructions for building the solution and executing the tests
- Implementation mechanisms such as disk-based storage, a REST API, and a front-end GUI are not required

Your solution will be reviewed by engineers that you will be working with if you join the Walmart Technology team. We are interested in seeing how you design, code, and test software.

You will need to implement the following interface. The design of the SeatHold object is entirely up to you.

```java
public static void main(string[] args) {
    System.out.println('Hello World')
}
```
