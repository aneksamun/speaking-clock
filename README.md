# Speaking clock

Translates given time to 12 hours clock words sentence. For example, "08:34" should be translated  

Specification
-------------
1. Given a 24 hour clock convert the current time into words
	e.g. "08:34" should be converted to "It's eight thirty four"

2. Return Midday and Midnight as "It's Midday" and "It's Midnight"

Build and run instructions
--------------------------
1. Build project:   
`./mvnw clean install`
   
2. Run by commands:   
$ lein compile
$ lein uberjar
$ java -jar speaking-clock-1.0.0-standalone.jar 19:00 
## Usage

FIXME

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
