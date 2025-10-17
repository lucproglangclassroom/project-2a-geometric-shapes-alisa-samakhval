package edu.luc.cs.laufer.cs371.shapes

/** Defines the abstract shape hierarchy. */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Ellipse(rx: Int, ry: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)
end Shape


