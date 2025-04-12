package Examen

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types._

/**Ejercicio 1: Crear un DataFrame y realizar operaciones básicas
 Pregunta: Crea un DataFrame a partir de una secuencia de tuplas que contenga información sobre
 estudiantes (nombre, edad, calificación).
 Realiza las siguientes operaciones:

 Muestra el esquema del DataFrame.
 Filtra los estudiantes con una calificación mayor a 8.
 Selecciona los nombres de los estudiantes y ordénalos por calificación de forma descendente.
 */

object Pregunta1 {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("DataFrame Estudiantes")
      .master("local[*]")
      .getOrCreate()
  }

  def ejercicio1(df: DataFrame)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._

    val estudiantes = Seq(
      ("Juan", 20, 8.5),
      ("Lucía", 22, 9.2),
      ("Carlos", 19, 7.8),
      ("María", 21, 8.9)
    )

    val df = estudiantes.toDF("nombre", "edad", "calificacion")
    val filtrados = df.filter($"calificacion" > 8)

    filtrados.show()

    val nombresOrdenados = filtrados
      .select("nombre", "calificacion")
      .orderBy($"calificacion".desc)

    println("Nombres ordenados por calificación descendente:")
    nombresOrdenados.show()
  }
}