package com.mw.java.test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mawei on 2016/6/17.
 */
public class WorldCount_J {
    public static void main(String[] args) {
        String path = "E:\\TestWork\\src\\main\\resources\\worldcount";
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("JavaWordCount");
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);
        JavaRDD<String> lines = ctx.textFile(path);
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterable<String> call(String s) {
                return Arrays.asList(s.split(" "));
            }
        });
        List<String> wordsResults = words.collect();
        for (String s : wordsResults) {
            System.out.printf(s);
        }

        JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) {
                return new Tuple2<String, Integer>(s, 1);
            }
        });
        List<Tuple2<String, Integer>> output_1 = ones.collect();
        for (Tuple2<?, ?> tuple : output_1) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }
        /**
         * i1和i2都是输入
         *  i1是累加的结果
         *  i2是第二个加数
         * 第三个参数是输出的结果
         */
        JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }
        });

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?, ?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }
        ctx.stop();
    }
}
