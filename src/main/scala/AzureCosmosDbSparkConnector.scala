import com.microsoft.azure.cosmosdb.spark.schema._
import com.microsoft.azure.cosmosdb.spark._
import com.microsoft.azure.cosmosdb.spark.config.Config

object AzureCosmosDbSparkConnector {

  def main(args: Array[String]): Unit = {
    val readConfig = Config(Map(
      "Endpoint" -> "https://qa-wakanda-ca.documents.azure.com:443/",
      "Masterkey" -> "2JGov0jL83tVhmaKbYAcfGKX0WW6qLQmUlzZRrPZA1M36ev01poUg2cQmYtQ0GHTnhMsfwpF1prqF8PHItQ40A==",
      "Database" -> "bashenga",
      "Collection" -> "fulfillment-nodes"
    ))

    val df = spark.read.cosmosDB(readConfig)
    df.count()
  }
}
