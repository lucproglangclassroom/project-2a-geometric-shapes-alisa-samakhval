package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

/** Computes the height of a shape tree,
  * taking all kinds of shape nodes into account.
  * Each node (Rectangle, Ellipse, Location, Group) adds +1 to the depth.
  */
object height:

  private val logger = Logger("edu.luc.cs.laufer.cs371.shapes.height")

  def apply(s: Shape): Int = s match
    case Rectangle(_, _) =>
      logger.debug(s"→ Rectangle height = 1")
      1

    case Ellipse(_, _) =>
      logger.debug(s"→ Ellipse height = 1")
      1

    case Location(x, y, inner) =>
      val innerHeight = apply(inner)
      val total = 1 + innerHeight
      logger.debug(s"→ Location($x,$y) adds +1 to inner height $innerHeight => total = $total")
      total

    case Group(shapes*) =>
      // For an empty group, height = 1 (the group itself)
      val childrenHeights = shapes.map(apply)
      val total = if shapes.isEmpty then 1 else 1 + childrenHeights.max
      logger.debug(s"→ Group(${shapes.size} shapes) child heights = ${childrenHeights.mkString(", ")} => total = $total")
      total

end height
