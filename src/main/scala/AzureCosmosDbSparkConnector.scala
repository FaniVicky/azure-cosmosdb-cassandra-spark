import com.microsoft.azure.cosmosdb.spark.config.Config
import org.apache.spark.sql.SparkSession


object AzureCosmosDbSparkConnector {

  def main(args: Array[String]): Unit = {
    val readConfig = Config(Map(
      "Endpoint" -> "https://qa-wakanda-ca.documents.azure.com:443/",
      "Masterkey" -> "2JGov0jL83tVhmaKbYAcfGKX0WW6qLQmUlzZRrPZA1M36ev01poUg2cQmYtQ0GHTnhMsfwpF1prqF8PHItQ40A==",
      "Database" -> "bashenga",
      "Collection" -> "fulfillment-nodes",
      "query_custom" -> "SELECT c.sId FROM c WHERE c.et = 'nodeCreated/1'"
    ))

    val spark = SparkSession.builder()
      .appName("AzureCosmosDBRead")
      .master("local[1]")
      .getOrCreate()

    import com.microsoft.azure.cosmosdb.spark.schema._
    val df = spark.read.cosmosDB(readConfig)

    df.explain()
    df.show(3)
    df.count()
  }
}
