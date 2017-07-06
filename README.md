## Walmart Labs Challenge, due 07/07/2017

### Installation instructions

1. Download the Java JDK (I am using the macOS version) from [Oracle's Java 8 Downloads Page](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html):
    - When I run `java -version` in bash, this output is returned:

    ```bash
    java version "1.8.0_131"
    Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
    Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
    ```

    Alternatively, this output is also returned (on another machine):

    ```bash
    java version "1.8.0_121"
    Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
    Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)
    ```

    The important thing is to use Java 1.8.

2. Download Gradle, a Java package manager, using Homebrew:
    - `brew update && brew install gradle`
    - When I run `gradle -v` in bash, this output is returned:

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

    The important thing is to use Gradle 4.0.

3. Clone the repository:
    - `git clone https://github.com/yingw787/walmart_challenge_07_07_2017 /path/to/directory`

4. Install dependencies:
    - TODO!!!


### Dependencies
    - TODO!!!

### Scripts

- Build the project:
    - `gradle build`

- Execute the executable:
    - TODO!!!

- Run tests:
    - `gradle test`
