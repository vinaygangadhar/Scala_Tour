package scala_learn

/**
  * Created by vinaygangadhar on 6/26/16.
  */
//Abstract implementation of Graph
abstract class Graph{
  type Edge
  type Node <: NodeInfer

  //inner abstract class -- Nodeinfer class
  //abstract classes allow concrete implementations
  //of nodes and edges
  abstract class NodeInfer{
    def connectWith(node: Node): Edge
  }

  //other methods
  def nodeList: List[Node]
  def edgeList: List[Edge]
  def addNode: Node       //add nodes to the graph
}

//More conrete graph implementation
abstract class DirectedGraph extends Graph{

  //concrete imp of edge class
  type Edge <: EdgeImpl
  class EdgeImpl(orig: Node, dest: Node) {
    def from = orig
    def to = dest
  }

  //concrete impl of Node class
  class NodeImpl extends NodeInfer {

    //this is of type NodeImpl but newEdge needs Node
    //explicit type annotation (Node implemented in future)
    //has to denote subtype of Node for to be instantiable
    self: Node =>       //tieing another class explicitly
    def connectWith(node: Node): Edge = {
      val edge: Edge = newEdge(this, node)
      edges = edge :: edges
      edge
    }
  }

  //factory methods -- what concrete classes to call
  protected def newNode: Node
  protected def newEdge(orig: Node, dest: Node): Edge

  //edges and nodes
  var nodes: List[Node] = Nil
  var edges: List[Edge] = Nil

  //methods for edges and nodes
  def nodeList: List[Node] = nodes
  def edgeList: List[Edge] = edges


  //addNode method
  def addNode: Node = {
    val node = newNode
    nodes = node :: nodes
    node
  }
}

//Concrete impl of directed graph
class ConcreteDirectedGraph extends DirectedGraph{
  type Edge = EdgeImpl        //class type
  type Node = NodeImpl

  protected def newNode: Node = new NodeImpl
  protected def newEdge(from: Node, to: Node): Edge = {
    new EdgeImpl(from, to)
  }

}


object Self_Reference {
  def main(args: Array[String]): Unit = {
    val g = new ConcreteDirectedGraph

    val n1 = g.addNode
    val n2 = g.addNode
    val n3 = g.addNode

    //Nodeimpl subtype of Node
    n1.connectWith(n2)
    n2.connectWith(n1)
    n2.connectWith(n3)

  }

}
