package core;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class GenerateMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();	
		line = line.trim();
		String[] part = line.split("\t");
		String label;
		if(part[part.length-1].equals("0"))label = "draw";
		else if(part[part.length-1].equals("1"))label = "win";
		else label = "lose";	
		String cont = "";
		for(int i=3;i<part.length-2;i++){
			cont += (part[i] + ",");
		}
		cont += part[part.length-2];
		context.write(new Text(label), new Text(cont));
	}
}
