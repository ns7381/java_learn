package com.nathan.learn

import org.apache.spark.sql.SparkSession

object CorrelationLearn {
  def main(args: Array[String]) {
    import org.apache.spark.ml.linalg.{Matrix, Vectors}
    import org.apache.spark.ml.stat.Correlation
    import org.apache.spark.sql.Row

    val data = Seq(
      Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
      Vectors.dense(4.0, 5.0, 0.0, 3.0),
      Vectors.dense(6.0, 7.0, 0.0, 8.0),
      Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
    )
    val spark = SparkSession.builder().appName("ml").master("local").getOrCreate()
    import spark.implicits._
    val df = data.map(Tuple1.apply).toDF("features")
    val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
    println(s"Pearson correlation matrix:\n $coeff1")

    val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
    println(s"Spearman correlation matrix:\n $coeff2")
  }
}