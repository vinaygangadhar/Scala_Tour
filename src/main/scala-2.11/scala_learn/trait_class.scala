package scala_learn

/**
  * Created by vinaygangadhar on 6/22/16.
  */


trait trait_example {
  def isSimilar(x: Any): Boolean
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}


class trait_class(xc: Int, yc: Int) extends trait_example {   //constructor arguments

  var x : Int = xc
  var y : Int = yc

  //returns Unit
  def move(xm: Int, ym: Int): Unit = {
    x = x + xm
    y = y + ym
  }

  override def toString(): String = "(" + x + ", " + y + ")"

  //concrete implementation of isSimilar method of trait
  //check if the object of type class is instance and value x
  //is same
  def isSimilar(obj: Any) = obj.isInstanceOf[class_example] &&
                            obj.asInstanceOf[class_example].x == x
}

object TraitTest{
  def main(args: Array[String]) = {
    val p1 = new trait_class(1, 2)
    val p2 = new trait_class(3, 4)
    val p3 = new trait_class(3, 5)

    println(p1.isNotSimilar(p2))
    println(p2.isSimilar(p3))
  }

}