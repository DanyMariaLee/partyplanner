# Party planner with Scala

[![N|Solid](/logo.png)](logo.png)

Hey there!

If you want to learn Scala from scratch this workshop will help you out with that.

What we have:
1) build.sbt - file with all information about application:
- dependncies ([scalatest](http://www.scalatest.org) only)
- scala version (2.12.4)
- name of application (partyplanner)
- version of application (0.1) 
- setting ```concurrentRestrictions```, that says we will run tests in one thread  

```scala
name := "partyplanner"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)
```
2) PartyPlanner object in src/main/scala directory where you will implement all functions
3) Tests in src/test/scala directory
4) resource folder withh input data for our party planner

## The task
We have three files in resource directory:
- price.txt
- consumption.txt
- party.txt

Using console dialog get information from user - party type, number of people invited to the party and a budget. 
Calculate how much will such a party cost and respond to the user if we can to arrange that event.

Start from src/main/scala/PartyPlanner.scala
You'll find tips there that can help you to implement the logic step by step.

## How to run SBT

Using terminal go to your project directory and type "sbt"
You'll see something like

```sh
Marinas-MacBook-Pro:partyplanner marina$ sbt
[info] Loading settings from plugins.sbt ...
[info] Loading project definition from /Users/marina/IdeaProjects/partyplanner/project
[info] Loading settings from build.sbt ...
[info] Set current project to partyplanner (in build file:/Users/marina/IdeaProjects/partyplanner/)
[info] sbt server started at 127.0.0.1:5727
```

## How to run project

Are you still in your project directory? If no - go there and type "sbt run" or just "run" if sbt is running already.

## How to run specific test

In your project directory with sbt running
```sh
testOnly partyplanner.SuiteName
```
You can also run all tests in the project by typing
```
test
```

## Everything done?
So fast?
Ok!
We have more for you)

1) What if party can be for kids? pets?
- take new resources/additional/consumption.txt file and replace old consumption.txt in resources folder with that. Two new columns contain info for kids and pets respectively.
- expand Consumption model to fit new informaion
- don't forget to add new questions into chat with user
- write more tests!
2) Create a REST API with existing functionality.
- get Request model as input in your app, and respond with Receipt model. 
- Request to your app in json will be like this
```json
{
   "party": {
       "name": "birthday",
       "products": ["apple","coffee"]
   },
   "numberOfPeople": 10,
   "budget": 100
}
```
- And your response will look like this
```json
{
"request": {
   "party": {
       "name": "birthday",
       "products": ["apple","coffee"]
   },
   "numberOfPeople": 10,
   "budget": 100
},
"totalAmount": 99
}
```
- there are a lot of frameworks to do that, the most popular is [Akka](https://doc.akka.io/docs/akka-http/current/introduction.html). You can find examples in internet, this is one of [apps](https://github.com/DanyMariaLee/scale), feel free to use it.
3) Use external API data to get prices for products instead of price.txt. One of useful API can be [Tesco](https://devportal.tescolabs.com/docs/services/57f247f9e2813e07d8663943/operations/57f2518fe2813e07d8663945/console). Feel free to use any of the API you can find or even write your own that will get data from file price.txt and respond with json response containing that data.

### Have fun!
