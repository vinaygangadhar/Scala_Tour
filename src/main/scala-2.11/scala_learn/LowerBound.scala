package scala_learn

/**
  * Created by t-vigan on 6/24/2016.
  */

// A linked list case class
//with type class param

//abstract class NewList[+T]

//covariant annotation is needed as String is not a
//subtype of Any

//Also, covarianece annotation is possible
//only if type variable is used in covariant poisitions
//and not methods -- In that case use abstact classes
//for covariance annotation or use lower bounds
case class ListNode[+T](h: T, list: ListNode[T]) {
  def head: T = h
  def tail: ListNode[T] = list

  //This is done to prevent type parmaeter T
  //appear only in covariant poisitions and not method param
  def prepend[U >: T](elem: U): ListNode[U] = ListNode(elem, this)
}


object LowerBound {

  def main(args: Array[String]): Unit = {
    val empty: ListNode[Null] = ListNode(null, null)

    val intList: ListNode[Int] = ListNode(1, ListNode(2, null))
    val strList: ListNode[String] = ListNode("hello", ListNode("world", null))

    val checkList: ListNode[Any] = empty.prepend("Cross-List").prepend("1")

    println(empty)
    println(intList)
    println(strList)
    println(checkList)
  }
}
