package edu.luc.cs.laufer.cs371.shapes

/** Represents the hierarchy of geometric shapes. */
sealed trait Shape derives CanEqual

/** A rectangle with given width and height. */
case class Rectangle(width: Int, height: Int) extends Shape:
  require(width > 0 && height > 0,
    s"Invalid Rectangle dimensions: ($width, $height)")

/** An ellipse with given horizontal and vertical radii. */
case class Ellipse(horizontalRadius: Int, verticalRadius: Int) extends Shape:
  require(horizontalRadius > 0 && verticalRadius > 0,
    s"Invalid Ellipse radii: ($horizontalRadius, $verticalRadius)")

/** A location offset for a shape, moving it by (x, y). */
case class Location(x: Int, y: Int, shape: Shape) extends Shape

/** A group that contains multiple shapes. */
case class Group(shapes: Shape*) extends Shape





