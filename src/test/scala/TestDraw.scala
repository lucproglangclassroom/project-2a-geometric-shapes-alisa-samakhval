package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import java.awt.image.BufferedImage
import java.awt.{Color, Graphics2D}
import Shape.*

class TestDraw extends AnyFunSuite:

  def assertSameImage(i1: BufferedImage, i2: BufferedImage): Unit =
    val w = i1.getWidth
    val h = i1.getHeight
    for y <- 0 until h; x <- 0 until w do
      val p1 = i1.getRGB(x, y)
      val p2 = i2.getRGB(x, y)
      assert(p1 == p2, s"Pixels differ at ($x, $y)")

  test("simple ellipse draw") {
    val shape = Ellipse(20, 20)
    val img1 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)
    val g1 = img1.createGraphics()
    draw(shape, g1)

    val img2 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)
    val g2 = img2.createGraphics()
    g2.setColor(Color.RED)
    g2.drawOval(-20, -20, 40, 40)

    assertSameImage(img1, img2)
  }

  test("location + group draw") {
    val shape = Location(50, 100, Group(Rectangle(60, 40), Ellipse(20, 10)))
    val img1 = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB)
    val g1 = img1.createGraphics()
    draw(shape, g1)

    val img2 = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB)
    val g2 = img2.createGraphics()
    g2.translate(50, 100)
    g2.setColor(Color.BLUE)
    g2.drawRect(0, 0, 60, 40)
    g2.setColor(Color.RED)
    g2.drawOval(-20, -10, 40, 20)

    assertSameImage(img1, img2)
  }
