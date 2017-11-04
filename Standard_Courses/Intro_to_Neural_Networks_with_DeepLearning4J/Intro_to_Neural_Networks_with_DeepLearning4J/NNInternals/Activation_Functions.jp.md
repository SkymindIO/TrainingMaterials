!SLIDE center subsection

# Activation Functions　活性化関数

!SLIDE

# What is an Activation Function　活性化関数とは

* Determines output of Neuron Based on Inputs　ニューロンの出力を入力に基づいて決定
* Non-Linear Transform function at each node　各ノードに非線形変換関数
* Defined per layer　各層で設定
* Allow neural networks to make complex boundary decisions for features at various levels of abstraction. 　 ニューラルネットワークは様々な抽象化レベルで複雑な特徴の境界決定が行える


!SLIDE

# Activation Function　活性化関数

* Hidden Layer　隠れ層
* Controls what is sent to connected Neurons　接続したニューロンへの送信をコントロール
* Output Layer　出力層
* Determines Output Value　出力値を決定
  * Regression　回帰
  * Classification　分類
  * Etc　その他


!SLIDE

# Common Activation Functions　一般的な活性化関数

* ReLU　 ReLU関数
  * Recent Breakthrough　最近のブレイクスルー
  * Good Default　デフォルトとして良い
* Sigmoid　シグモイド関数
  * Had been Standard　過去におけるスタンダード
  * S curve Range 0 to 1　Ｓ字カーブ、0～1の範囲
* TanH　 TanH関数
  * S curve Range -1 to 1　Ｓ字カーブ、-1～1の範囲


~~~SECTION:notes~~~
# Keep SImple Listing and move most to the appendix
~~~ENDSECTION~~~

!SLIDE
 
# Activation Functions　活性化関数

![img](../resources/Activation-func.png)
 
!SLIDE
 
# Output Layer Activation　出力層の活性化
 
* Special Case　特別なケース
* Goal of hidden Layer activation is to squash intermediate values　隠れ層の活性化により中間値を押し込める
* Goal of output Layer is to answer our question　出力層に質問に答えさせる
  * Classification = softmax　分類=ソフトマックス
  * regression = identity　回帰=恒等


~~~SECTION:notes~~~

Add One Hot Encoding discussion with Classification and SoftMax

~~~ENDSECTION~~~

!SLIDE

# Output Layer Guidelines　出力層のガイドライン

* Classification　分類
  * softmax activation　ソフトマックス活性化
  * Negative Log Likelihood for loss Function　損失関数の負の対数尤度
  * Multi Class Cross Entropy　多クラス交差エントロピー
* Softmax　ソフトマックス
  * Probability Distribution over classes　クラスの確率分布
  * Outputs sum to 1.0　出力合計～1.0
* Regression　回帰
  * Identity Activation　恒等関数による活性化
  * MSE(Mean Squared Error) Loss Function　MSE（平均二乗誤差）損失関数


!SLIDE

# Quick Statistics Review: Probability　統計クイックレビュー：確率

* Probability　確率
	* We define probability of an event E as a number always between 0 and 1　事象Eの確率を常に0～1の値として定義
	* In this context the value 0 infers that the event E has no chance of occurring and the value 1 means that the event E is certain to occur　ここでは、値0は事象Eが発生する可能性がなく、値1は事象Eが確実に発生することを意味
* The Canonical Coin Example　標準的コインの例
	* Fair coin flipped, looking for heads/tails (0.5 for each side)　コイン投げ（表も裏も0.5）
	* Probability of sample space is always 1.0　標本空間の確率は常に1.0
	* P( Heads ) = 0.5 every time　 P（表）= 毎回0.5


!SLIDE


# Classification　分類

* A type of answer we can get from a model　モデルから得ることのできる答え
* Example:　例
	* “Is this an image of a cat or a dog?”　「これは猫または犬の画像ですか？」
	* Binary classification　2クラス分類
	* Classes: { cat, dog }　クラス：{猫、犬}
* Binary classification is where we have only 2 labels　2クラス分類ではラベルが2つのみ
	* Example: { positive, negative }　例：{正、負}
* Multi-Label Classification　マルチラベル分類
	* N number of labels　N個のラベル


!SLIDE


# Regression　回帰


* Where we seek a continuous value output from the model　モデルから連続値の出力を求める
* Example: “predict the temperature for tomorrow” 　例：「明日の気温を予測せよ」
	* Output: 75F　出力：華氏75度
* Example: “predict price of house based on square footage”　例：「平方フィートに基づく家の価格を予測せよ」
	* Output: $250,000.00　出力：$ 250,000.00


~~~SECTION:notes~~~

activation function for the output layer: 
this is usually application specific. 
For classification problems, you generally want to use the softmax activation function, combined with the negative log likelihood / MCXENT (multi-class cross entropy). 

The softmax activation function gives you a probability distribution over classes (i.e., outputs sum to 1.0). For regression problems, the “identity” activation function is frequently a good choice, in conjunction with the MSE (mean squared error) loss function.


~~~ENDSECTION~~~

