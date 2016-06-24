package scala_learn

/**
  * Created by vinaygangadhar on 6/24/16.
  */


//exports constructor parameters
abstract class Tree
case class Node(left: Tree, right: Tree) extends Tree
case class Leaf[A](value: A) extends Tree
case object EmptyLeaf extends Tree




object binary_tree {

  def main(args: Array[String]) = {
    val treeA = Node(EmptyLeaf, Leaf(5))
    val treeB = Node(Node(Leaf(2), Leaf(4)), Leaf(1))

    val treeC = treeA.copy(left = treeB.left)

    println("Tree A: "+treeA)
    println("Tree B: "+treeB)
    println("Tree C: "+treeC)

    //Comaprison
    println("TreeA == TreeB: %s" format (treeA == treeB).toString)

  }

}
