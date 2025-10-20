package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

object boundingBox:

  private val logger = Logger("shapes.boundingBox")

  def apply(s: Shape): Location = s match
    case Rectangle(w, h) =>
      logger.debug(s"Bounding box(Rectangle): w=$w h=$h")
      Location(0, 0, Rectangle(w, h))

    case Ellipse(rx, ry) =>
      logger.debug(s"Bounding box(Ellipse): rx=$rx ry=$ry")
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

    case Location(x, y, inner) =>
      val Location(x0, y0, Rectangle(w, h)) = boundingBox(inner): @unchecked
      logger.debug(s"Bounding box(Location): ($x,$y)+($x0,$y0) w=$w h=$h")
      Location(x + x0, y + y0, Rectangle(w, h))

    case Group(shapes*) =>
      logger.debug(s"Computing group bounding box for ${shapes.size} shapes")
      val boxes = shapes.map(boundingBox(_))
      val xs = boxes.map(_.x)
      val ys = boxes.map(_.y)
      val rights = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width)
      val bottoms = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height)
      val minX = xs.min; val minY = ys.min
      val maxRight = rights.max; val maxBottom = bottoms.max
      logger.debug(s"Resulting group bbox: ($minX,$minY) w=${maxRight - minX} h=${maxBottom - minY}")
      Location(minX, minY, Rectangle(maxRight - minX, maxBottom - minY))
end boundingBox

