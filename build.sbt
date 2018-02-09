name := "partyplanner"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)