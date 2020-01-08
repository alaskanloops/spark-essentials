package part2dataframes

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.LongType

object DataFramesBasics extends  App {
  val spark = SparkSession.builder()
    .appName("DataFrames Basics")
    .config("spark.master","local")
    .getOrCreate()


  val firstDF = spark.read
    .format("json")
    .option("inferSchema", "true")
    .load("src/main/resources/data/cars.json")

  firstDF.show()
  firstDF.printSchema()

  // get rows
  firstDF.take(10).foreach(println)

  // spark types
  val longType = LongType











}
