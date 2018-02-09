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

### Have fun!
