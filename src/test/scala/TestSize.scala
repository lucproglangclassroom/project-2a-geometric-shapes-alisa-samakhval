package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestSize extends AnyFunSuite:
  test("simple rectangle") {
    assert(size(simpleRectangle) == 1)
  }

  test("simple ellipse") {
    assert(size(simpleEllipse) == 1)
  }

  test("simple location") {
    assert(size(simpleLocation) == 1)
  }

  test("basic group") {
    assert(size(basicGroup) == 2)
  }

  test("complex group") {
    assert(size(complexGroup) == 6)
  }
end TestSize
