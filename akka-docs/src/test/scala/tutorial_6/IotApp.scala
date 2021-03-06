/**
 * Copyright (C) 2009-2018 Lightbend Inc. <https://www.lightbend.com>
 */

package tutorial_6

import akka.actor.ActorSystem
import DeviceManager.RequestTrackDevice

import scala.io.StdIn

object IotApp {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("iot-system")

    try {
      // Create top level supervisor
      val supervisor = system.actorOf(DeviceManager.props(), "iot-supervisor")

      supervisor ! RequestTrackDevice("mygroup", "device1")

      // Exit the system after ENTER is pressed
      StdIn.readLine()
    } finally {
      system.terminate()
    }
  }

}
