name := "azure-cosmosdb-cassandra-spark"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
    "com.microsoft.azure" % "azure-cosmosdb-spark_2.4.0_2.11" % "1.3.5",
    "org.apache.spark" % "spark-core_2.11" % "2.3.0" % "provided",
    "org.apache.spark" % "spark-sql_2.11" % "2.3.0" % "provided"
  )
}

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7"

