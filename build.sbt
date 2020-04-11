name := "tdd-scala-PokerHands"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.1" % "test"
)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
