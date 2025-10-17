package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:
  test("scale rectangle") {
    val scaled = scale(Rectangle(10, 20), 2.0)
    assert(scaled == Rectangle(20, 40))
  }

  test("scale ellipse") {
    val scaled = scale(Ellipse(10, 5), 3.0)
    assert(scaled == Ellipse(30, 15))
  }

  test("scale location") {
    val scaled = scale(Location(10, 5, Rectangle(10, 10)), 2.0)
    assert(scaled == Location(20, 10, Rectangle(20, 20)))
  }

  test("scale group") {
    val g = Group(Rectangle(10, 10), Ellipse(5, 5))
    val scaled = scale(g, 2.0)
    assert(scaled == Group(Rectangle(20, 20), Ellipse(10, 10)))
  }
end TestScale
