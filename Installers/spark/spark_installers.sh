#!/bin/sh

SPARK_VERSION=2.2.0
SPARK_HADOOP_VERSION=2.7
EXTERNAL_DEST_DIR=$INSTALL_DEST_DIR

wget https://d3kbcqa49mib13.cloudfront.net/spark-${SPARK_VERSION}-bin-hadoop${SPARK_HADOOP_VERSION}.tgz \
     && tar xvzf spark-${SPARK_VERSION}-bin-hadoop${SPARK_HADOOP_VERSION}.tgz -C ${EXTERNAL_DEST_DIR} \
     && rm spark-${SPARK_VERSION}-bin-hadoop${SPARK_HADOOP_VERSION}.tgz

rm -rf ${EXTERNAL_DEST_DIR}/spark
ln -s  ${EXTERNAL_DEST_DIR}/spark-${SPARK_VERSION}-bin-hadoop${SPARK_HADOOP_VERSION} ${EXTERNAL_DEST_DIR}/spark
