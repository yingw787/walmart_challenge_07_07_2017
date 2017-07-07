## Walmart Labs Challenge, due 07/07/2017

### Installation instructions

1. Download the Java 1.8 JDK (I am using the macOS version) from [Oracle's Java 8 Downloads Page](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html):
    - Run `java -version` in your bash terminal to ensure you have the proper version of Java accessible in your command line:

    ```bash
    java version "1.8.0_131"
    Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
    Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
    ```

2. Download Gradle, a Java package manager, using Homebrew:
    - `brew update && brew install gradle`
    - Run `gradle -v` in your bash terminal to ensure you have the proper version of Gradle accessible in your command line:

    ```bash
    ------------------------------------------------------------
    Gradle 4.0
    ------------------------------------------------------------

    Build time:   2017-06-14 15:11:08 UTC
    Revision:     316546a5fcb4e2dfe1d6aa0b73a4e09e8cecb5a5

    Groovy:       2.4.11
    Ant:          Apache Ant(TM) version 1.9.6 compiled on June 29 2015
    JVM:          1.8.0_131 (Oracle Corporation 25.131-b11)
    OS:           Mac OS X 10.12.5 x86_64
    ```

3. Clone the repository:
    - `git clone https://github.com/yingw787/walmart_challenge_07_07_2017 /path/to/directory`

4. Install dependencies:
    - Build the project using the script in the [Scripts](#scripts).


### Dependencies
- Listed in `build.gradle`.


### Scripts

- Build the project:
    - `./gradlew build`

- Execute the executable:
    - `./gradlew run`

- Run tests:
    - `./gradlew test`


### Assumptions

- The problem describes a "performance venue", which is assumed to be some collection of seats.
- Assume that there is one instance of a "performance venue" in any given process.
- The problem describes "best available seats", which is taken to assume that seats have different desirability.
    - Assume that for the BasicPerformanceVenue, the desirability of a seat is linearly proportional to the row the seat is in (do not consider columns, levels, etc.)
- Assume that end-user inputs are all sanitized, and all user information (such as email addresses) are validated.
- Assume that one ticket matches one seat.
- Assume that you can only reserve a seat after it has been held.
    - This is because seatHoldId is only accessible in reserveSeats() after SeatHold object has been returned from findAndHoldSeats().
- Assume that no assumption is made about the seat's position within the performance venue,
  and that value is attached to each seat by itself.
- Assume that if not all the seats could be allocated in findAndHoldSeats(), then do not reserve any seats (instead of reserving all BasicSeats possible).
- Assume that for BasicPerformanceVenue, the venue will never change size after being constructed (if in the future it does, instantiate a new BasicPerformanceVenue and copy data over).


### Design Considerations

- All classes should implement an interface.
- Use private variables when possible, and only expose with public methods, to
  avoid pollution.

- I considered having a barebones BasicSeat class, and having the BasicPerformanceVenue be a pair of stacks. That way, allocating a BasicSeat would be popping a BasicSeat off of an "available" stack of BasicSeats and pushing onto a stack of "held" or "reserved" BasicSeats. However, using a Stack would limit access to BasicSeats not recently pushed or popped, and access may be required for those BasicSeats.
