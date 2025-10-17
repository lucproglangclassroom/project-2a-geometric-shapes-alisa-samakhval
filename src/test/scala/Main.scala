package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.*

object Main:
  def main(args: Array[String]): Unit =
    println("Bounding box of simpleLocation: " + boundingBox(simpleLocation))
    println("Size of complexGroup: " + size(complexGroup))
    println("Height of complexGroup: " + height(complexGroup))
    println("Scaled simpleRectangle by 2: " + scale(simpleRectangle, 2.0))
end Main


