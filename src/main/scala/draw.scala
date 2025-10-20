package edu.luc.cs.laufer.cs371.shapes

import java.awt.{Color, Graphics2D}
import Shape.*   


object draw:

  /** Draws the given shape */
  def apply(s: Shape, g: Graphics2D): Unit = s match
    case Rectangle(w, h) =>
      g.setColor(Color.BLUE)
      g.drawRect(0, 0, w, h)

    case Ellipse(rx, ry) =>
      g.setColor(Color.RED)
      g.drawOval(-rx, -ry, 2 * rx, 2 * ry)

    case Location(x, y, inner) =>
      val oldTransform = g.getTransform
      g.translate(x, y)
      apply(inner, g)
      g.setTransform(oldTransform)

    case Group(shapes*) =>
      shapes.foreach(shape => apply(shape, g))
