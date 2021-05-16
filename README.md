# Java_Maven_Lab
Create java application using Lombok and Maven.
## Task
Write code for Lab

- Zoo. Implement the hierarchy of birds present in the zoo. Search for birds that are counted in warm countries. Sort the search result by bird weight. Implement the ability to sort found birds for several consumer foods. Implementation of sorting provides the ability to sort both for publication and for enlargement. The implementation of sorting should provide the ability to sort both in descending and ascending order	
- Use java code convention
- CLasses must be distributed in packages
- Work with console must be minimal
- Code must contain only that classes that are described in the diagram
- Sorting must use java built-in methods
- Sorting must be implemented in separate method
- No static methods/attributes are allowed (the only exception is a main method)
- You must use an Enum
- Code must be in a separate branch with PR
- Comparison must be implemented using lambdas
- Instead of getters/setters you should use @Data annotation from lombok
- Use maven and Jococo(in build section), FindBugs, PMD, CheckStyle plugins(reporting section)
- Run mvn site and fix errors reported by checkstyle, pmd and findbugs
## To run:
- download project files `git clone https://github.com/DanyloZhubryd/java_lab_8/pull/1`
- switch to Lab8 branch `git checkout Lab8_Maven`
- compile maven project `mvn compile`
- package compiled code into .jar `mvn package`
- run application: `java -cp target\zoo-0.0.1-SNAPSHOT.jar ua.lviv.iot.zoo.App`
- run checkstyle: `mvn checkstyle:check`
- check for bugs `mvn findbugs:gui`
- check for dublications in code `mvn pmd:pmd`
