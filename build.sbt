name := "Uta"

version := "0.1"

libraryDependencies ++= Seq(
  // JSON support
  "org.json" % "json" % "20190722",
  // Logger
  "org.apache.logging.log4j" % "log4j-core" % "2.11.1",
  // Logging impl
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.11.1",
  // Logging API
  "org.apache.logging.log4j" % "log4j-api" % "2.11.1"
)
