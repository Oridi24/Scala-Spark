package Examen
/**Ejercicio 4: Uso de RDDs
 Pregunta: Crea un RDD a partir de una lista de palabras y cuenta la cantidad de ocurrencias de cada palabra.

 */
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


object Pregunta4 {

  def ejercicio4(palabras: List[String])(spark: SparkSession): RDD[(String, Int)] = {
    val rdd = spark.sparkContext.parallelize(palabras)
    val conteo = rdd
      .map(_.toLowerCase)
      .map(palabra => (palabra, 1))
      .reduceByKey(_ + _)
    conteo
  }
}

