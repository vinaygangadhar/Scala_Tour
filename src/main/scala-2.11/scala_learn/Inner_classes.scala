package scala_learn

/**
  * Created by vinaygangadhar on 6/24/16.
  */

//Inner classes are bound to objects of outer type
class Graph {
  //Inner class as a member
  class Node {
    var connectedNodes: List[Node] = Nil    //mutable list of nodes

    //to add to a connected nodes of the current node
    //need a defiention of generic type Graph#Node if we want to
    //connect nodes of 2 different graphs
    def connectTo(node: Node) = {
      if(connectedNodes.find(node.equals).isEmpty){
        connectedNodes = node :: connectedNodes
      }
    }
  }

  var nodes: List[Node] = Nil     //List of objects of type member class nodes
  //create a new node in the grap and add to list
  def newNode(): Node = {
    val n = new Node
    nodes = n :: nodes
    n
  }

}

object Inner_classes {

  def main(args: Array[String]) = {
    val g: Graph = new Graph //of type Graph

    val n1: g.Node = g.newNode() //of type Node associated with outer graph object
    val n2: g.Node = g.newNode()

    n1.connectTo(n2)
    n2.connectTo(n1)
  }

}

