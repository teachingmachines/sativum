package sativum

import org.joda.time.LocalDate
import peapod.Task

/**
  * This is a Task that is run on a daily basis or which can be tied to a date
  */
trait DatedTask[D] extends Task[D] {
  self : Task[D] =>
  val partition: LocalDate
  override lazy val name: String = baseName+ "/" + partition.toString()
  override lazy val versionName = baseName
  override lazy val dir = p.path + "/" + baseName + "/" + recursiveVersionShort + "/" +
    partition.toString("yyyy/MM/dd") + "/"
}
