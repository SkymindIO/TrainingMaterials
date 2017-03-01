# DataVec

* Neural Nets ingest numeric arrays
* Datavec helps you get from your_data => Numeric Array

-------------------
<div style="page-break-after: always;"></div>

# Data Sources

* log files
* text documents
* tabular data
* images and video
* and more !!

-------------------
<div style="page-break-after: always;"></div>

# Goal

* Convert each data type into a collection of numerical values in a MultiDimensional Array


-------------------
<div style="page-break-after: always;"></div>

# More Features

* Transformation
* Scaling
* Shuffling
* Joining
* Splitting

-------------------
<div style="page-break-after: always;"></div>

# Commonly Used Features

* RecordReaders
  * Read files or input, convert to List of Writables
* Normalizers
  * Standardize, scale or Nomralize the data
* Transform Process
  * Join datasets, replace strings with numerics, extract labels

-------------------
<div style="page-break-after: always;"></div>

# Diagram of available ETL paths

![alt text](../resources/ETL.png)

-------------------
<div style="page-break-after: always;"></div>


# Image Basics

* Images are arrays of pixel values.


![alt text](../resources/big44.png)

-------------------
<div style="page-break-after: always;"></div>

# White box black square image as INDArray

```
        INDArray imagematrix = loader.asMatrix(image);
		System.out.println(imagematrix);
```

# Output

```
[[[[255.00, 255.00, 255.00, 255.00],
   [255.00, 0.00, 0.00, 255.00],
   [255.00, 0.00, 0.00, 255.00],
   [255.00, 255.00, 255.00, 255.00]]]]
```

-------------------
<div style="page-break-after: always;"></div>

# Scale values between 0 and 1

```
    DataNormalization scaler = new ImagePreProcessingScaler(0,1);
    scaler.transform(imagematrix);
```

# Output

```
[[[[1.00, 1.00, 1.00, 1.00],
   [1.00, 0.00, 0.00, 1.00],
   [1.00, 0.00, 0.00, 1.00],
   [1.00, 1.00, 1.00, 1.00]]]]
```

-------------------
<div style="page-break-after: always;"></div>

# Manipulating images with DataVec

* Scale images to same dimensions with RecordReader

```
ImageRecordReader recordReader = new ImageRecordReader(height,width,channels);
```

* Scale image to appropriate dimenstions with NativeImageLoader

```
NativeImageLoader loader = new NativeImageLoader(height, width, channels); \\ load and scale
INDArray image = loader.asMatrix(file); \\ create INDarray
INDArray output = model.output(image);   \\ get model prediction for image
```

-------------------
<div style="page-break-after: always;"></div>

# Image Data Set Augmentation

* Create "larger" training set with OpenCV tools
	* Transform
	* Crop
	* Skew

-------------------
<div style="page-break-after: always;"></div>

# Applying Labels

* ParentPathLabelGenerator
* PathLabelGenerator

-------------------
<div style="page-break-after: always;"></div>

# Image Transform

* Grab the table from this page
https://deeplearning4j.org/etl-userguide
* Scale Pixel Values

```
DataNormalization scaler = new ImagePreProcessingScaler(0,1);
scaler.fit(dataIter);
dataIter.setPreProcessor(scaler);
```

-------------------
<div style="page-break-after: always;"></div>

# Available ND4J Pre-Processors

* ImagePreProcessingScaler
  * min max scaling default 0 + - 1
* NormalizerMinMaxScaler
  * ?
* NormalizerStandardize
  * moving column wise variance and mean
  * no need to pre-process ?

-------------------
<div style="page-break-after: always;"></div>

# Image Transforms with JavaCV, OpenCV, ffmpeg

-------------------
<div style="page-break-after: always;"></div>

# Image pipeline to pre-trained model

ETL_single_image.png

![alt text](../resources/ETL_single_image.png)

-------------------
<div style="page-break-after: always;"></div>


# DataVec Example

* CSV => NDArray
```
public class CSVExample {

    private static Logger log = LoggerFactory.getLogger(CSVExample.class);

    public static void main(String[] args) throws  Exception {

        //First: get the dataset using the record reader. CSVRecordReader handles loading/parsing
        int numLinesToSkip = 0;
        String delimiter = ",";
        RecordReader recordReader = new CSVRecordReader(numLinesToSkip,delimiter);
        recordReader.initialize(new FileSplit(new ClassPathResource("iris.txt").getFile()));

        //Second: the RecordReaderDataSetIterator handles conversion to DataSet objects, ready for use in neural network
        int labelIndex = 4;     //5 values in each row of the iris.txt CSV: 4 input features followed by an integer label (class) index. Labels are the 5th value (index 4) in each row
        int numClasses = 3;     //3 classes (types of iris flowers) in the iris data set. Classes have integer values 0, 1 or 2
        int batchSize = 150;    //Iris data set: 150 examples total. We are loading all of them into one DataSet (not recommended for large data sets)

        DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader,batchSize,labelIndex,numClasses);
        DataSet allData = iterator.next();
```
-------------------
<div style="page-break-after: always;"></div>

# DataVec Code Explained

* RecordReader recordReader = new CSVRecordReader(numLinesToSkip,delimiter);
	* A RecordReader prepares a list of Writables
	* A Writable is an efficient Serialization format
* DataSetIterator iterator = new RecordReaderDataSetIterator
	* We are in DL4J know, with DataSetIterator
	* Builds an Iterator over the list of records
* DataSet allData = iterator.next();
	* Builds a DataSet



-------------------
<div style="page-break-after: always;"></div>

# Frequently Used DataVec classes

* CSVRecordReader
	* CSV Text Data
* ImageRecordReader
	* Convert Image to numeric array representing pixel values
*  JacksonRecordReader
	* Parses JSON records
* ParentPathLabelGenerator
	* Builds labels based on Directory Path
* Transform, Transform Process Builder, TransformProcess
	* Conversion tools


-------------------
<div style="page-break-after: always;"></div>
