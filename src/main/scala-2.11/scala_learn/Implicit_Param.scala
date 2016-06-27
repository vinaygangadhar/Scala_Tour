package scala_learn

/**
  * Created by vinaygangadhar on 6/26/16.
  */

abstract class addGroup[T] {
  def add(x: T, y: T): T
}

//add and unit operations
abstract class addUnitGroup[T] extends addGroup[T]{
  def unit: T
}

object Implicit_Param {

  //Implicit object companion module
  implicit object IntImplicit extends addUnitGroup[Int]{
    def add(x: Int, y: Int): Int =  x + y
    def unit: Int = 0
  }

  //String type implicit object
  implicit object StringImplicit extends addUnitGroup[String]{
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }

  //implict member of companion module
  //m object of type addUnitGroup is the implicit member here
  def sum[T](xs: List[T])(implicit m: addUnitGroup[T]): T = {
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))
  }

  def main(args: Array[String]): Unit = {

    println(sum(List(4, 7, 9)))
    println(sum(List("Copa", "-D", "America")))
  }

}
