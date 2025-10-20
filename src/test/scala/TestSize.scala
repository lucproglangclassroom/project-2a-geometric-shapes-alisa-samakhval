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
    // wrapping does not add leaves
    assert(size(simpleLocation) == 1)
  }

  test("basic group") {
    // Ellipse + Rectangle
    assert(size(basicGroup) == 2)
  }

  test("complex group") {
    // five concrete leaves in the provided fixtures
    assert(size(complexGroup) == 5)
  }
end TestSize
