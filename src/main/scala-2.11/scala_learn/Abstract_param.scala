package scala_learn

//Implementation with class type parameetrers
//type member and value member of an object
abstract class PBuffer[+T]{
  val element: T
}

abstract class PSeqBuffer[U, +T<:Seq[U]] extends PBuffer[T]{
  def length = element.length
}

object Abstract_param {

  //+T allows the type param to be overidden by a new
  //type in the subsequent classes or anonymous class calls -- Variance annotation


  def newIntSeqBuf(el1: Int, el2: Int): PSeqBuffer[Int, Seq[Int]] = {
    new PSeqBuffer[Int, List[Int]] {
      val element: List[Int] = List(el1, el2)
    }
  }

  def main(args: Array[String]): Unit = {
    val buf = newIntSeqBuf(4, 8)

    println("Buffer Length=" + buf.length)
    println("Buffer Elements=" + buf.element)
  }

}

