package com.mw.test.sparkstreaming

object FlumePollWordCount {
  def main(args: Array[String]) {
//    val conf = new SparkConf().setAppName("FlumePollWordCount").setMaster("local[2]")
//    val ssc = new StreamingContext(conf, Seconds(5))
//    //从flume中拉取数据
//    val address = Seq(new InetSocketAddress("172.16.0.11", 8888))
//    val flumeStream = FlumeUtils.createPollingStream(ssc, address, StorageLevel.MEMORY_AND_DISK)
//    val words = flumeStream.flatMap(x => new String(x.event.getBody().array()).split(" ")).map((_,1))
//    val results = words.reduceByKey(_+_)
//    results.print()
//    ssc.start()
//    ssc.awaitTermination()
  }
}
