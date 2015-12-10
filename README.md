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
Now you can use it. For example:
```
hive> select crc32(name) from names;
OK
3632233996
Time taken: 0.103 seconds, Fetched: 1 row(s)
```
