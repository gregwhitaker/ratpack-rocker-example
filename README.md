ratpack-rocker-example
===

Example of rendering HTML using [Rocker](https://github.com/fizzed/rocker) templates in [Ratpack](https://ratpack.io/).

This example starts a Ratpack application that is hosting an HTML page rendered by Rocker.  The page allows you to specify
a maximum number. It then generates 10 random numbers between 1 and the specified maximum and sorts them 
based on whether they are odd or even.

##Running the Example
The example can be run using the following Gradle command:

    $ ./gradlew run

Once the application has started, point your web browser to [http://localhost:5050](http://localhost:5050) to access the test page.

##Bugs and Feedback

For bugs, questions and discussions please use the [Github Issues](https://github.com/gregwhitaker/ratpack-rocker-example/issues).

##License
Copyright 2017 Greg Whitaker

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.