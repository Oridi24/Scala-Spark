package Examen
/**Ejercicio 3: Joins y agregaciones
 Pregunta: Dado dos DataFrames,
 uno con información de estudiantes (id, nombre)
 y otro con calificaciones (id_estudiante, asignatura, calificacion),
 realiza un join entre ellos y calcula el promedio de calificaciones por estudiante.
 */

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SparkSession}

object Pregunta3 {

  def crearEstudiantesDF(spark: SparkSession): DataFrame = {
    import spark.implicits._

    val estudiantes = Seq(
      (1, "Ana"),
      (2, "Juan"),
      (3, "Carla"))

    estudiantes.toDF("id", "nombre")
  }


  def crearCalificacionesDF(spark: SparkSession): DataFrame = {
    import spark.implicits._

    val calificaciones = Seq(
      (1, "Matemáticas", 8),
      (1, "Historia", 9),
      (2, "Historia", 7),
      (3, "Matemáticas", 10),
      (3, "Historia", 9))

    calificaciones.toDF("id_estudiante", "asignatura", "calificacion")
  }


  def ejercicio3(estudiantes: DataFrame, calificaciones: DataFrame): DataFrame = {


    val joinDF = estudiantes
      .join(calificaciones, estudiantes("id") === calificaciones("id_estudiante"))

    val promedioDF = joinDF
      .groupBy("nombre")
      .agg(avg("calificacion").alias("promedio-calificacion"))


    promedioDF.show()

  }
}

