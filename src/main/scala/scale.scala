package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Recursively scales all numeric dimensions and coordinates by a given factor. */
object scale:
  def apply(s: Shape, factor: Double): Shape = s match
    case Rectangle(w, h) =>
      Rectangle((w * factor).toInt, (h * factor).toInt)

    case Ellipse(rx, ry) =>
      Ellipse((rx * factor).toInt, (ry * factor).toInt)

    case Location(x, y, inner) =>
      Location((x * factor).toInt, (y * factor).toInt, apply(inner, factor))

    case Group(shapes*) =>
      Group(shapes.map(shape => apply(shape, factor))*)
end scale
