name := "elastic4s-client-aws"

organization := "com.github.pjfanning"

scalaVersion := "2.13.5"

crossScalaVersions := Seq("2.12.12", "2.13.5")

ThisBuild / scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked")

val awsSdkVersion = "2.16.43"
val elastic4sVersion = "7.9.2"

libraryDependencies ++= Seq(
  "com.sksamuel.elastic4s" %% "elastic4s-core" % elastic4sVersion,
  "com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % elastic4sVersion,
  "com.sksamuel.exts" %% "exts" % "1.61.1",
  "org.slf4j" % "slf4j-api" % "1.7.30",
  "software.amazon.awssdk" % "auth" % awsSdkVersion,
  "software.amazon.awssdk" % "core" % awsSdkVersion,
  "software.amazon.awssdk" % "regions" % awsSdkVersion,
  "software.amazon.awssdk" % "regions" % awsSdkVersion,
  "org.scalatest" %% "scalatest" % "3.2.7" % Test
)

publishMavenStyle := true

Test / publishArtifact := false

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { x => false }

homepage := Some(new URL("https://github.com/pjfanning/elastic4s-client-aws"))

startYear := Some(2021)

licenses := Seq(("Apache License 2.0", new URL("http://www.apache.org/licenses/LICENSE-2.0.html")))

releasePublishArtifactsAction := PgpKeys.publishSigned.value

pomExtra := (
  <scm>
    <connection>scm:git:git@github.com:pjfanning/elastic4s-client-aws.git</connection>
    <developerConnection>scm:git:git@github.com:pjfanning/elastic4s-client-aws.git</developerConnection>
    <url>https://github.com/pjfanning/elastic4s-client-aws</url>
  </scm>
  <issueManagement>
    <system>github</system>
    <url>https://github.com/pjfanning/elastic4s-client-aws/issues</url>
  </issueManagement>
  <developers>
    <developer>
      <id>sksamuel</id>
      <name>Sam Samuel</name>
      <url>https://github.com/sksamuel</url>
    </developer>
  </developers>
)
