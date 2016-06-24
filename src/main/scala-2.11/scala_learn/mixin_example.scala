package scala_learn

/**
  * Created by vinaygangadhar on 6/22/16.
  */

//abstract class with type and
//incomplete methods
abstract class TemplateIterator{
  type T                    //Type parameter
  def hasNext: Boolean
  def next: T
}

//mixin class -- trait with a method
//extending the abstract base class
//function of each item returned by iterator
trait RichIterator extends TemplateIterator{
  def foreach(f: T => Unit) {
    while (hasNext) f(next)
  }
}

//class to define the object type
//and methods
class StringIterator(s: String) extends TemplateIterator{
  type T = Char

  private var i = 0
  def hasNext = i  < s.length()

  //returns next char
  def next = {
    val ch = s charAt(i)
    i+= 1
    ch
  }
}

//object with all functionalities
//mixin class composition
object TemplateIterator {
  def main(args: Array[String]): Unit ={

    //new class defintion with mixin class
    class Iter extends StringIterator(args(0)) with RichIterator

    val iter = new Iter

    //call the method
    iter.foreach(println)
  }

  TemplateIterator.main(Array("Vinay"))
}
