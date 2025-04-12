import Examen.Pregunta1._
import Examen.Pregunta2._
import Examen.Pregunta3._
import Examen.Pregunta4._
import Examen.Pregunta5._
import org.apache.spark.sql.SparkSession

////////
object Main1 {

  def main(arg: Array[String]): Unit = {

    implicit val spark: SparkSession = SparkSession.builder()
      .appName("Ejercicio 1 - DataFrame")
      .master("local[*]")
      .getOrCreate()
    import spark.implicits._

    val estudiantes = Seq(
      ("Juan", 20, 8.5),
      ("Lucía", 22, 9.2),
      ("Carlos", 19, 7.8),
      ("María", 21, 8.9))

    val df = estudiantes.toDF("nombre", "edad", "calificacion")

    val resultado1= ejercicio1(df)(spark)
    df.printSchema()
    resultado1.show()
  }

}

  /////////////
  object Main2 {
    def main(args: Array[String]): Unit = {

      implicit val spark: SparkSession = SparkSession.builder()
        .appName("Ejercicio 2 - UDF")
        .master("local[*]")
        .getOrCreate()

      import spark.implicits._

      val numerosDF = Seq(1, 2, 3, 4, 5, 6).toDF("numero")
      val dfConPar = ejercicio2(numerosDF)

      dfConPar.show()
      spark.stop()
    }
  }
  /////////////

object Main3 {
  def main(args: Array[String]): Unit = {

    implicit val spark: SparkSession = SparkSession.builder()
      .appName("Ejercicio 3 - Joins y Agregaciones")
      .master("local[*]")
      .getOrCreate()

    val estudiantesDF = crearEstudiantesDF(spark)
    val calificacionesDF = crearCalificacionesDF(spark)
    val resultadoDF = ejercicio3(estudiantesDF, calificacionesDF)


    resultadoDF.show()
    spark.stop()
  }
}
  /////////////////
  object Main4 {
    def main(arg: Array[String]): Unit = {

      implicit val spark: SparkSession = SparkSession.builder()
        .appName("Ejercicio 4 - RDD")
        .master("local[*]")
        .getOrCreate()

      val palabras = List("Scala", "Spark", "scala", "RDD", "Spark", "spark", "RDD")
      val resultadoRDD = ejercicio4(palabras)(spark)

      println("Resultado del conteo:")
      resultadoRDD.foreach(println)

      spark.stop()
    }
  }

/////////////////

object Main5 {

  def main(args: Array[String]): Unit = {

    implicit val spark: SparkSession = SparkSession.builder()
      .appName("Ejercicio 5 - CSV")
      .master("local[*]")
      .getOrCreate()


    val ventas = spark.read
      .option("header","true")
      .option("inferSchema", "true")
      .csv("C:\\Users\\oridi\\Desktop\\Programacion\\Scala\\PracticaKC\\examen\\examen\\ventas.csv")

    val ingresoTotal= ejercicio5(ventas)(spark)

    ingresoTotal.show()
    spark.stop()

  }
}









