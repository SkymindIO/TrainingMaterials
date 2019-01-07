package org.deeplearning4j.solution;

import org.apache.commons.io.FileUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.File;
import java.net.URL;

/**
 * This example read in data from a text file, perform some analysis using Spark, and output the data.
 *
 * Set up a simple spark application up and runnning with two methods below
 *     1. as an application running embedded Spark
 *
 *     2. as a spark job submitted to the master node
 *
 *           a. on local cluster
 *
 *              (On command prompt)
 *              Step 1: Command out this line -->  .setMaster("local[*]")
 *              Step 2: mvn clean package
 *              Step 3: /usr/local/spark/bin/spark-submit --master local[*] \
 *                  --class org.ex1 \
 *                  path/to/helloworldspark-1.0-SNAPSHOT-jar-with-dependencies.jar
 *
 *           b. on remote cluster
 *
 *              (On command prompt)
 *              Start a Spark master node:
 *
 *                  /usr/local/spark/sbin/start-master.sh
 *
 *              Start Spark worker node/nodes:
 *
 *                  /usr/local/spark/sbin/start-slave.sh spark://yourhostname.local:7077
 *
 *              Follow the steps 1 2 above.
 *
 *              Step 3: /usr/local/spark/bin/spark-submit --master spark://yourhostname.local:7077 \
 *                     --class org.ex1 \
 *                     path/to/helloworldspark-1.0-SNAPSHOT-jar-with-dependencies.jar
 *
 *
 *
 */
public class HelloWorldSpark {

    public static void main(String[] args) throws Exception
    {
        String filePath = downloadFile();

        SparkConf conf = new SparkConf()
                .setAppName("HelloWorldSpark");
                //.setMaster("local[*]"); // Delete this line when submitting to a cluster

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> javaRDD = sc.textFile(filePath);

        System.out.println("Number of lines in file = " + javaRDD.count());

        System.out.println("Program end");

    }

    public static String downloadFile() throws Exception
    {
        File path = new File(System.getProperty("java.io.tmpdir") + "/temp/spark");
        path.mkdirs();

        File filePath = new File(path.toString() + "/sample.csv");

        FileUtils.copyURLToFile(new URL("https://skymindacademy.blob.core.windows.net/training/sample.csv"), filePath);

        return filePath.toString();
    }
}
