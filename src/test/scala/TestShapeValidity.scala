package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*

class TestShapeValidity extends AnyFunSuite:

  test("invalid rectangle should throw exception") {
    assertThrows[IllegalArgumentException] {
      Rectangle(-5, 20)
    }
  }

  test("invalid ellipse should throw exception") {
    assertThrows[IllegalArgumentException] {
      Ellipse(0, 15)
    }
  }
end TestShapeValidity
