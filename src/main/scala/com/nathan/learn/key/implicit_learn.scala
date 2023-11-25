package com.nathan.learn.key


object implicit_learn {
  //隐式转换函数
  implicit def int2str(x: Int): String = x.toString

  //隐式类
  implicit class SayhiImpl(ivalue:Int) {
    val value:Int = ivalue
    def sayhi = println(s"Hi $value!")
  }

  123.sayhi  //合法

  //隐式参数
  def compare[T](x: T, y: T)(implicit ordered: Ordering[T]): Int = {
    ordered.compare(x, y)
  }
  trait Adder[T] {
    def add(x:T,y:T):T
  }

  implicit val a = new Adder[Int] {
    override def add(x: Int, y: Int): Int = x+y
  }

  def addTest(x:Int,y:Int)(implicit adder: Adder[Int]) = {
    adder.add(x,y)
  }
  //隐式值
  implicit val x: Int = 0

  //隐式对象
  implicit object Obj {
    def hello(s:String) = println(s"Hello $s!")
  }

  def test2(s:String)(implicit o: Obj.type ) = {
    o.hello(s)
  }

  //context bound
  def compare2[T: Ordering](x: T, y: T) = {
    val ord = implicitly[Ordering[T]]
    ord.compare(x, y)
  }


  def main(args: Array[String]): Unit = {
    10.concat("hello")
    println(10.length)


    10.sayhi


    compare(1,2)
    addTest(1,2)      // 正确, = 3
    addTest(1,2)(a)   // 正确, = 3


    test2("world")
  }
}


