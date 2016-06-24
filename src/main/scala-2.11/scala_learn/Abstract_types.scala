package scala_learn

/**
  * Created by vinaygangadhar on 6/24/16.
  */

//type member and value member of an object
trait Buffer{
  type T
  val element: T
}

//More concrete defintition for abstract type
//type overriding
//abstrct classes cant have objects
//Says it must be of a sequence type
abstract class SeqBuffer extends Buffer{
  type U
  type T <: Seq[U]        //type T must be a subtype of sequences of U

  def length = element.length
}


//Traits or class with anonymous class instantiations
abstract class IntSeqBuffer extends SeqBuffer{
  type U = Int
}


object Abstract_types {

  //returns an IntDeqBuf object with anonymous class instantiaion
  //Inturn abstract type members of a class are turned
  //into class type parameter

  def newIntSeqBuf(el1: Int, el2: Int): IntSeqBuffer = {
    new IntSeqBuffer {
      override type T = List[U]
      override val element: List[U] = List(el1, el2)
    }
  }

  def main(args: Array[String]): Unit = {
    val buf = newIntSeqBuf(4, 8)

    println("Buffer Length=" + buf.length)
    println("Buffer Elements=" + buf.element)
  }

}
