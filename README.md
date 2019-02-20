# Speaking clock

Translates given time into words. Time is converted in 12 hours clock format.

#### Examples 

| Input | Output                  |
| ------| ----------------------- |
| 00:00 | It's midnight           |
| 12:00 | It's noon               |
| 01:00 | It's one o'clock        |
| 00:01 | It's one past midnight  |
| 09:12 | It's twelve past nine   |
| 03:15 | It's quarter past three |
| 08:30 | It's half past eight    |
| 01:45 | It's quarter to two     |
| 03:50 | It's ten to four        |

## Build and run instructions
1. Build JAR   
`$ lein compile`   
`$ lein uberjar`   
2. Run   
`$ cd target/`   
`$ java -jar speaking-clock-1.0-standalone.jar 19:00`   

## License

Copyright © 2018 Red Pixel Ltd

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
