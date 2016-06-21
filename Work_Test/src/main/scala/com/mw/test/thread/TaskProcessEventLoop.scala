package com.mw.test.thread

/**
  * Created by ZX on 2016/3/29.
  */
class TaskProcessEventLoop(name:String) extends EventLoop[TaskEvent](name){

  /*
  override protected def onReceive(event: TaskEvent): Unit = event match {
    case TaskSubmitted(name) => {
      println(name + " submitted")
    }

    case TaskSucceeded(name) => {
      println(name + " succeeded")
    }

    case TaskFailed(name) => {
      println(name + " filled")
    }
  }
  */


  override protected def onStart(): Unit = {
    println("pre start ...on start......")
  }

  override protected def onReceive: PartialFunction[TaskEvent, Unit] = {
    case TaskSubmitted(name) => {
      println(name + " submitted")
    }

    case TaskSucceeded(name) => {
      println(name + " succeeded")
    }

    case TaskFailed(name) => {
      println(name + " filled")
    }
  }

}
