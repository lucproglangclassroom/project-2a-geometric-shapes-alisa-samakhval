package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestHeight extends AnyFunSuite:
  test("rectangle height") {
    assert(height(simpleRectangle) == 1)
  }

  test("location height") {
    assert(height(simpleLocation) == 2)
  }

  test("group height") {
    assert(height(simpleGroup) == 3)
  }

  test("complex group height") {
    assert(height(complexGroup) == 5)
  }
end TestHeight
