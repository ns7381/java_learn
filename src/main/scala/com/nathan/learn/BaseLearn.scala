package com.nathan.learn

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

import org.junit.Assert._
import org.junit._

class BaseLearn {

  @Before
  def before(): Unit = {
    println("before test")
  }

  @After
  def after(): Unit = {
    println("after test")
  }

  @Test
  def testList(): Unit = {
    println("testList")
    val list = List("a", "b")

    assertEquals(List("a", "b"), list)
    assertNotEquals(List("b", "a"), list)
  }

  @Test
  def testNow(): Unit = {
    val now = Calendar.getInstance().getTime
    println(now)
    println(getCurrentTimeStamp)
  }

  @Test
  def testFor(): Unit = {
    for {i <- 1 to 10}
      println(i)
  }

  def getCurrentTimeStamp: Timestamp = {
    val today: java.util.Date = Calendar.getInstance.getTime
    val timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val now: String = timeFormat.format(today)
    val re = java.sql.Timestamp.valueOf(now)
    re
  }
}
