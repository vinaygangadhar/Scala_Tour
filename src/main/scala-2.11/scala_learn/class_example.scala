package scala_learn

/**
  * Created by vinaygangadhar on 6/22/16.
  */
class class_example(xc: Int, yc: Int) {   //constructor arguments

  var x : Int = xc
  var y : Int = yc

  //returns Unit
  def move(xm: Int, ym: Int): Unit = {
    x = x + xm
    y = y + ym
  }

  override def toString(): String = "(" + x + ", " + y + ")"
}


//singleton object
object Point{
  def main(args: Array[String]) = {
    val class_obj = new class_example(1, 10)

    println(class_obj)

    class_obj.move(10, 10)
    println(class_obj)
  }
}
