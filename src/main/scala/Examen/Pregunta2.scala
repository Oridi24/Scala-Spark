package Examen

/**Ejercicio 2: UDF (User Defined Function)
 Pregunta: Define una función que determine si un número es par o impar.
 Aplica esta función a una columna de un DataFrame que contenga una lista de números.
 */

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.udf

object Pregunta2 {

  def esParOImpar(numero: Int): String = {
    if (numero % 2 == 0) "Par" else "Impar"
  }

  def ejercicio2(numeros: DataFrame)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._

    val parOImparUdf = udf(esParOImpar _)
    val resultado = numeros.withColumn("par", parOImparUdf($"numero"))


    resultado
  }
}

