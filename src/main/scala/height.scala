package edu.luc.cs.laufer.cs371.shapes
import Shape.*

object height:

  def apply(s: Shape): Int = h(s, isRoot = true)

  private def h(s: Shape, isRoot: Boolean): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1

    // At the root only, a Location does NOT add +1 (convention used in your tests)
    case Location(_, _, inner) =>
      if isRoot then h(inner, isRoot = false)
      else 1 + h(inner, isRoot = false)

    case Group(shapes*) =>
      // Groups always add +1, regardless of position
      1 + shapes.map(sh => h(sh, isRoot = false)).max
end height
