## Java Assessment
To complete this assessment, clone this git repository and follow the instructions provided below. Please spend no more
than one hour total on this assignment — you don't need to complete every step, but you should be prepared to discuss
any steps that you do not complete. After you're done, please push your code to a public git repository and share a
link to the repository with your UL contact.

### Resources
* You will need to build the project with gradle, and compile it with Java 8+
    * Gradle: Run either `./gradlew` or `.\gradlew.bat` in the project root directory to build, then the appropriate `gradlew test` will run the application tests
    * An IDE like Intellij or Eclipse may make running/debugging the application tests easier
* Please feel free to use any online references, including api documentation and StackOverflow, to help solve these problems
* You may also add any libraries/dependencies that you find useful, provided that they can be easily installed with the gradle build
* Please reach out to your UL contact if you have any questions or need help running the application


### TLV - Background
In payments, small blobs of data are encoded such that they can be decoded by parsers that have some knowledge of the format of the data.

One way that data can be encoded is in TLV (Tag, Length, Value) format broken down as follows:

* Tag: The unique identifier of the TLV structure. e.g. '8A' in payments is the [Authorization Response Code](https://www.emvlab.org/emvtags/?number=8A) 

* Length: The length of the data that follows this field e.g. '02' specifies 2 bytes of data make up the value of this field

* Value: The payload of the TLV. Consists of 'L' bytes of data where 'L' is the Length field preceding this value field. e.g. if 'L' was '02' and the next two bytes were '3030', the Value, V, would be '3030'.
    
**A valid TLV can be defined as an object containing a one-byte tag field, and one-byte length field, and a value field whose number of bytes is defined by the Tlv's length field.**

Using the examples above, a valid TLV could be encoded as a String as follows: "8A023030".


### TLV Parser - Assessment
Two classes are provided: 
* com.ul.Tlv models a TLV as an Object.
* com.ul.TlvParser offers methods (to be completed in this exercise) for validating and parsing TLV encoded Strings.

Given the com.ul.TlvParser class, the goal is to complete the steps outlined below to create a functional TLV Parser. 
The inputs are expected to be ASCII Strings, similar the example shown above.
    

1.  Complete the "parseTlvFromString" method that takes a String input parameter.
    
    Assumptions:
    * Tag will be 1 byte (2 Characters)
    * Length will be 1 byte (2 Characters)
        
    Examples:
    * "8A023030" should be parsed into a new TLV object:
        * Tag = "8A"
        * Length = 2
        * Value = "3030"
    
    This method should parse the input String into a com.ul.Tlv Object.
    
    Upon successful completion of this step, the tests in [Problem1Test.java](src/test/java/com/ul/Problem1Test.java) should all pass.
    
2.  For this step the pass criteria testing "parseTlvFromString" become more strict.
    
    The input data may contain spaces. This whitespace should be ignored. 
    * For example input of "8A 02 30 30", should parse as a valid TLV.
    
    Upon successful completion of this step, the tests in [Problem2Test.java](src/test/java/com/ul/Problem2Test.java) should all pass.

3.  For this step the pass criteria testing "parseTlvFromString" become more strict.

    The input data is no longer guaranteed to be valid.
    * For example, the following inputs are not valid:
        * "NotATlv,I'mARandomString!"
        * ""
        * "8A 01 010203040506070809"
        * "8A 09 01"

    If the input String is not valid, return the INVALID_TLV object available in com.ul.Tlv
    
    Upon successful completion of this step, the tests in [Problem3Test.java](src/test/java/com/ul/Problem3Test.java) should all pass.


### Summary:
* clone repo `git clone https://github.com/michaelvaldes/tlv-parser.git`
    * code is in: src\main\java\com\ul
    * tests are in: src\test\java\com\ul
* install with `./gradlew.bat`
* run tests with `./gradlew.bat test`
* fix the broken tests by updating com.ul.TlvParser