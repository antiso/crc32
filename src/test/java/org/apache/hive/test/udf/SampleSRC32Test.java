package org.apache.hive.test.udf;

import static org.junit.Assert.*;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class SampleSRC32Test {

	@Test
	public void testEvaluate() throws UDFArgumentException {
		SampleCRC32 crc = new SampleCRC32();
		assertNull("Should return null on null argument", crc.evaluate(null));
		assertEquals(new LongWritable(3632233996l), crc.evaluate(new Text("test")));
		
	}

}
