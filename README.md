This is the code for prediction of football match result using machine learning on Hive.

## Prediction

### Environment:
- Java: 1.7 
- Hadoop: 2.x 
- Hivemall: 0.4.2-rc.2. 

The code is seperated into two parts after ETL. 
### First part: feature extraction and listing:
File: Generate.hive Gen.jar 
#### Description:

Generate.hive gets input from raw data, extracting the features we may use,
like the total win, home win, away win, possession and so on. 

Gen.jar goes one more step, to label the data outputed from Generate.hive 
and format the data into a new structure which can be used to train models. 


### Second part: machine learning.
File: AROW.hive SCW2.hive RF.hive Ensemble.hive
#### Description:
Three machine learning algorithms are implemented to give the analytics. We
use Hivemall as the machine learning library which provides us with lots of
useful functions. These three algorithms are all based on hive thus scalable.
We test lots of feature combinations as input, and get some interesting 
conclusion from the result of these algorithms. Features can be changed in 
each algorithm file to get various output. Finally, an ensemble learning is
implemented which get used of several predictions of algorithms to reach a 
more complex evaluation. 

### Usage:
For *.hive file, type
> source *.hive in Hive to run.
For *.jar file, type
> hadoop jar *.jar <params> to run.
Here for Gen.jar, <params> are <input_file> <output_dir>.

### Data sources:
All the data are crawled and extracted from these two sources.
1. https://github.com/openfootball/eng-england
2. https://www.whoscored.com/Regions/252/Tournaments/2/England-Premier-League

Features extracted are listed in the file "Feature list". Change the indexes
written in each algorithms to try lots of combinations of features.

