# crc32
Sample Hive crc32() function

## Build
Execute `mvn clean package`

## Define new function
Copy `target\crc32-0.0.1-SNAPSHOT.jar` into Hive directory. Start Hive from main directory using `bin/hive`.
Then execute command:
```
hive> create function crc32 as 'org.apache.hive.test.udf.SampleCRC32' using jar 'crc32-0.0.1-SNAPSHOT.jar'
Added [crc32-0.0.1-SNAPSHOT.jar] to class path
Added resources: [crc32-0.0.1-SNAPSHOT.jar]
OK
Time taken: 0.494 seconds
```

## Check results
Create sample table:
```
hive> create table names(name string);
OK
Time taken: 0.601 seconds
hive> insert into names values('test');
Query ID = sva_20151210120651_93f8ecd2-319a-4c36-a4ac-dd47cd8be2bf
Total jobs = 3
Launching Job 1 out of 3
Number of reduce tasks is set to 0 since there's no reduce operator
Job running in-process (local Hadoop)
2015-12-10 12:06:53,211 Stage-1 map = 100%,  reduce = 0%
Ended Job = job_local831773395_0002
Stage-4 is selected by condition resolver.
Stage-3 is filtered out by condition resolver.
Stage-5 is filtered out by condition resolver.
Moving data to: file:/user/hive/warehouse/names2/.hive-staging_hive_2015-12-10_12-06-51_084_4560328531559469165-1/-ext-10000
Loading data to table default.names
Table default.names stats: [numFiles=1, numRows=1, totalSize=5, rawDataSize=4]
MapReduce Jobs Launched:
Stage-Stage-1:  HDFS Read: 0 HDFS Write: 0 SUCCESS
Total MapReduce CPU Time Spent: 0 msec
OK
Time taken: 2.492 seconds
```
This will create HDFS structure:
```
C:\USER
└───hive
    └───warehouse
        └───names
```

Now check new function:
```
hive> select crc32(name) from names;
OK
3632233996
Time taken: 0.103 seconds, Fetched: 1 row(s)
```
