package core;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class GenerateReducer extends Reducer<Text, Text, IntWritable, Text> {
	public int count = 1;
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		
		for (Text value : values) {
			context.write(new IntWritable(count++), new Text(key + "\t" + value));
		}
	}
}
