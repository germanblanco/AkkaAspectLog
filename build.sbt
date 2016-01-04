name := "AkkaAspectLog"

version := "1.0"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaVersion = "2.3.14"
  val aspectjVersion = "1.8.7"
  Seq(
  "com.typesafe.akka"      %% "akka-actor"                 % akkaVersion,
  "com.typesafe.akka"      %% "akka-slf4j"                 % akkaVersion,
  "org.aspectj"             % "aspectjweaver"              % aspectjVersion,
  "org.aspectj"             % "aspectjrt"                  % aspectjVersion,
  "net.logstash.logback"    % "logstash-logback-encoder"   % "4.5.1",
  "ch.qos.logback"          % "logback-classic"            % "1.1.3",
  "com.typesafe"           %% "scalalogging-slf4j"         % "1.1.0"
  )
}

javaOptions in run += "-javaagent:" + System.getProperty("user.home") + "/.ivy2/cache/org.aspectj/aspectjweaver/jars/aspectjweaver-1.7.2.jar"

fork in run := true
