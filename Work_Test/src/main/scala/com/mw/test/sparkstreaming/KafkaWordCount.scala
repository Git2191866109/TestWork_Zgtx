package com.mw.test.sparkstreaming

/**
  * Created by ZX on 2015/6/22.
  * zoo01,zoo02,zoo03 group1 topic1,topic2 1
  * node-1.itcast.cn:2181,node-2.itcast.cn:2181,node-3.itcast.cn:2181 group1 wordcount 2
  */
object KafkaWordCount {

  val updateFunc = (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
    //iter.flatMap(it=>Some(it._2.sum + it._3.getOrElse(0)).map(x=>(it._1,x)))
    iter.flatMap { case (x, y, z) => Some(y.sum + z.getOrElse(0)).map(i => (x, i)) }
  }

  def main(args: Array[String]) {
//    LoggerLevels.setStreamingLogLevels()
//    val Array(zkQuorum, group, topics, numThreads) = args
//    val sparkConf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
//    val ssc = new StreamingContext(sparkConf, Seconds(5))
//    ssc.checkpoint("c://ck1")
//    //"alog-2016-04-16,alog-2016-04-17,alog-2016-04-18"
//    //"Array((alog-2016-04-16, 2), (alog-2016-04-17, 2), (alog-2016-04-18, 2))"
//    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap
//    val data = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap)
//    data.print()
//    val words = data.map(_._2).flatMap(_.split(" "))
//    val wordCounts = words.map((_, 1)).updateStateByKey(updateFunc, new HashPartitioner(ssc.sparkContext.defaultParallelism), true)
//    wordCounts.print()
//    ssc.start()
//    ssc.awaitTermination()
  }
}
