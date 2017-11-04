!SLIDE center subsection

# DataVec

* Neural networks process numeric arrays　ニューラルネットワークは数値配列を処理
* Datavec helps you get from your_data => numeric array　Datavecによりデータを数値配列に変換


!SLIDE

# Data Sources　データのソース

* Log files　ログファイル
* Text documents　テキスト文書
* Tabular data　表形式のデータ
* Images and video　画像やビデオ
* and more !!　その他

!SLIDE

# Goal　目標

* Build a user freindly comprehensive toolkit for data pilelines into Neural Netowrks　ニューラルネットワークに使用するデータパイプラインのための使いやすく包括的なツールキットを構築する


!SLIDE

# DataVec Features　DataVecの機能

* Transformation　変換
* Scaling　スケーリング
* Shuffling　シャッフリング
* Joining　結合
* Splitting Test and Train　分割テストと訓練


!SLIDE

# Commonly Used Features　よく使われる機能

* RecordReaders
  * Read files or input, convert to List of Writables　ファイルの読み込み・入力、書き込み可能リストに変換
* Normalizers　正規化プログラム
  * Standardize, scale or normalize the data　データの標準化、スケーリングまたは正規化
* Transform Process　変換プロセス
  * Join datasets, replace strings with numerics, extract labels　データセットの結合、文字列を数値へ置き換え、ラベルの抽出


!SLIDE

# Diagram of available ETL paths　使用可能なETLパスの図

![alt text](../resources/ETL.png)

!SLIDE


# DataVec Image Basics　 DataVec画像の基本

* Images are arrays of pixel values　画像はピクセル値の配列

<img src="../resources/big44.png" align="center" height="480" width="480" >


!SLIDE

# Code Example: Load above image as INDArray　コード例：画像をINDArrayとして読み込む
```
        INDArray imagematrix = loader.asMatrix(image);
		System.out.println(imagematrix);
```

# Output　出力

```
[[[[255.00, 255.00, 255.00, 255.00],
   [255.00, 0.00, 0.00, 255.00],
   [255.00, 0.00, 0.00, 255.00],
   [255.00, 255.00, 255.00, 255.00]]]]
```

!SLIDE

# Code Example: Scale values between 0 and 1　コード例：スケール値（0～1）

```
    DataNormalization scaler = new ImagePreProcessingScaler(0,1);
    scaler.transform(imagematrix);
```

# Output　出力

```
[[[[1.00, 1.00, 1.00, 1.00],
   [1.00, 0.00, 0.00, 1.00],
   [1.00, 0.00, 0.00, 1.00],
   [1.00, 1.00, 1.00, 1.00]]]]
```

!SLIDE

# Manipulating Images with DataVec 　DataVecによる画像操作

* Scale images to same dimensions with RecordReader　 RecordReaderにより画像を同次元にスケーリング
* Used in pipeline for example in training　訓練などパイプラインで使用

ImageRecordReader recordReader = new ImageRecordReader(height,width,channels);
```

* Scale image to appropriate dimenstions with NativeImageLoader　NativeImageLoaderにより適切な次元に画像をスケーリング
* Used one-off for example in inference　推論など一度だけ使用

NativeImageLoader loader = new NativeImageLoader(height, width, channels); \\ load and scale　読み込み、スケーリングする
INDArray image = loader.asMatrix(file); \\ create INDarray　 INDarrayを作成
INDArray output = model.output(image);   \\ get model prediction for image　画像のモデル予測を得る
```

!SLIDE

# Code Example: Image Transform　コード例：画像変換

* Scale pixel values　ピクセル値をスケーリング

```
DataNormalization scaler = new ImagePreProcessingScaler(0,1);
scaler.fit(dataIter);
dataIter.setPreProcessor(scaler);
```


!SLIDE

# Image Data Set Augmentation　画像データセットの拡張

* Create "larger" training set with OpenCV/dataVec tools　OpenCV / dataVecツールにより「より大きい」訓練セットを作成
	* Transform　変換
	* Crop　トリミング
	* Skew　スキュー


!SLIDE

# Applying Labels　ラベリング

* ParentPathLabelGenerator
* PathLabelGenerator

!SLIDE

# Available Record Readers　利用可能なレコードリーダー

* Table of available record readers:　 
  * https://deeplearning4j.org/etl-userguide


*利用可能なレコードリーダーのテーブル：
   * https://deeplearning4j.org/etl-userguide


!SLIDE

# Available ND4J Pre-Processors　利用可能なND4J 事前プロセッサ

* ImagePreProcessingScaler
  * min max scaling default 0 + - 1　最小最大スケーリングデフォルト0 + - 1
* NormalizerMinMaxScaler
  * Scale values observed min -> 0, observed max -> 1 スケール値、min - > 0、観測されたmax - > 1
* NormalizerStandardize
  * moving column wise variance and mean　列方向に分散や平均を動かす
  * no need to pre-process　事前処理が不要
* ImagePreProcessingScaler


!SLIDE

# Image Transforms with JavaCV, OpenCV, ffmpeg　 JavaCV, OpenCV, ffmpegによる画像変換

* Libraries included　ライブラリーを含む


!SLIDE

# Make this first intro to this for inference, and clean order　これを推論の手始めとして使い、順序を整える

# Image pipeline Single Image to Pre-Trained Model　画像パイプラインは単一画像から事前訓練モデルへ



<img src="../resources/ETL_single_image.png" align="center" height="480" width="480" >

!SLIDE


# Code Example: CSV Data to INDArray　コード例：INDArrayへのCSVデータ

	
	public class CSVExample {
	private static Logger log = LoggerFactory.getLogger(CSVExample.class);
	public static void main(String[] args) throws  Exception {
        //First: get the dataset using the record reader. 最初にリコードリーダーを使ってデータセットを入手
		//CSVRecordReader handles loading/parsing　 CSVRecordReaderは読み込み、解析を行う
        int numLinesToSkip = 0;
        String delimiter = ",";
        RecordReader recordReader = 
		new CSVRecordReader(numLinesToSkip,delimiter);
        recordReader.initialize(new FileSplit
		(new ClassPathResource("iris.txt").getFile()));


!SLIDE 

# Code Example: Continued.... コード例（続き）


	//Second: the RecordReaderDataSetIterator 　次にRecordReaderDataSetIteratorが
		//handles conversion to 　　　　　　　ニューラルネットで使用できるよう、　　　　　　
		//DataSet objects, ready for use in neural network　 DataSetオブジェクトに変換
        int labelIndex = 4;     
		//5 values in each row of the iris.txt CSV: 　 iris.txt CSVの各行に5つの値
		//4 input features followed by an integer label (class) index. 整数のラベル（クラス）インデックスに続いて4つの入力特徴
		//Labels are the 5th value (index 4) in each row　ラベルは各行の5つ目の値（インデックス4）
        int numClasses = 3;     
		//3 classes (types of iris flowers) in the iris data set. アイリスデータセット内の3クラス（あやめという花の種類）
		//Classes have integer values 0, 1 or 2　クラスには整数値の0または1 、2がある
        int batchSize = 150; 
		//Iris data set: 150 examples total. アイリスデータセットは全部で150例
		//Loading all of them into one DataSet それら全部をデータセット一つに読み込む
		//(not recommended for large data sets)　（大型データには不向き）

        DataSetIterator iterator = 
		new RecordReaderDataSetIterator
		(recordReader,batchSize,labelIndex,numClasses);
        DataSet allData = iterator.next();



!SLIDE

# DataVec Code Explained　 DataVec コードの説明

* RecordReader recordReader = new CSVRecordReader(numLinesToSkip,delimiter);
	* A RecordReader prepares a list of Writables　 RecordReaderによりWritableリストを準備
	* A Writable is an efficient Serialization format 　Writableは効率的なシリアル化形式
* DataSetIterator iterator = new RecordReaderDataSetIterator
	* We are in DL4J know, with DataSetIterator　DL4J ではDataSetIteratorを使う
	* Builds an Iterator over the list of records　レコードのリスト上にIterator構築
* DataSet allData = iterator.next();
	* Builds a DataSet　 DataSetを構築
	* INDArray of Features, INDArray of Labels　特徴のINDArray、ラベルのINDArray
* RecordReader recordReader =新しいCSVRecordReader（numLinesToSkip、delimiter）;
 

!SLIDE

# Frequently Used DataVec classesよく使用されるDataVecクラス

* CSVRecordReader
	* CSV text data　CSVテキストデータ
* ImageRecordReader
	* Convert image to numeric array representing pixel values　画像をピクセル値の数値配列に変換
*  JacksonRecordReader
	* Parses JSON records　JSONレコードを解析
* ParentPathLabelGenerator
	* Builds labels based on directory path　ディレクトリパスに基づいてラベルを作成
* Transform, Transform Process Builder, TransformProcess　変換、変換プロセスビルダー、TransformProcess
	* Conversion tools　変換ツール

 
!SLIDE

