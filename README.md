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
- Assume that end-user inputs are all sanitized, and all user information (such as email addresses) are validated.
- Assume that one ticket matches one seat.


### Design Considerations

- All classes should implement an interface.
