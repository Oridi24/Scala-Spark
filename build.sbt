ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.16"

lazy val root = (project in file("."))
  .settings(
    name := "PracticaKC"
  )

libraryDependencies ++= Seq(

  "org.scalatest" %% "scalatest" % "3.2.17" % Test,
  "org.apache.spark" %% "spark-core" % "3.5.5",
  "org.apache.spark" %% "spark-sql" % "3.5.5",
  "org.apache.spark" %% "spark-hive" % "3.5.5"

)