package scala_learn

/**
  * Created by vinaygangadhar on 6/24/16.
  */

//A generic implementation of stack
//mutable stack

//invariant implementation
class Stack[T] {
  var elems: List[T] = Nil
  def push(x: T) = { elems = x :: elems}
  def Top: T = elems.head
  def pop()  {elems = elems.tail}  //collection of elems leaving the head
}

//Testing stack
object stackTest {
  def main(args: Array[String]) = {

    val s = new Stack[Int]

    s.push(2)
    s.push('a')

    println(s.Top)

    s.pop
    println(s.Top)
  }
}
