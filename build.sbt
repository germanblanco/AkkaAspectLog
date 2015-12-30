name := "AkkaAspectLog"

version := "1.0"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaVersion = "2.2.0-RC1"
  val aspectjVersion = "1.7.2"
  Seq(
  "com.typesafe.akka"      %% "akka-actor"                 % akkaVersion,
  "com.typesafe.akka"      %% "akka-slf4j"                 % akkaVersion,
  "org.aspectj"             % "aspectjweaver"              % aspectjVersion,
  "org.aspectj"             % "aspectjrt"                  % aspectjVersion,
  "net.logstash.logback"    % "logstash-logback-encoder"   % "4.3",
  "ch.qos.logback"          % "logback-classic"            % "1.0.13",
  "com.typesafe"           %% "scalalogging-slf4j"         % "1.0.1"
  )
}

javaOptions in run += "-javaagent:" + System.getProperty("user.home") + "/.ivy2/cache/org.aspectj/aspectjweaver/jars/aspectjweaver-1.7.2.jar"

fork in run := true
