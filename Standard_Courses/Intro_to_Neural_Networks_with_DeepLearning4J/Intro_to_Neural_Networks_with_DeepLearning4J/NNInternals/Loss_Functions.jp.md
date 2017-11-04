!SLIDE center subsection

# Loss Functions　損失関数

Loss functions quantify how close a given neural network is to the ideal it is training
towards.　 損失関数は、あるニューラルネットワークが訓練するのに理想的かどうかを定量化する

!SLIDE


# The three important functions at work in machine learning optimization　機械学習の最適化に使用される3つの重要な関数:

* parameters　パラメータ
  * transform input to help determine the classifications a network infers　入力を変換し、ネットワークが推論する分類の決定を助ける
* loss function　損失関数
  * gauges correctness of output　出力の正確さを測定
* optimization function　最適化関数
  * guides it toward the points of least error. 　 値を最小誤差へと導く


!SLIDE

# Available Loss Functions　利用できる損失関数

* For Regression　回帰
  * MSE(Mean Squared Error)　 平均二乗誤差（MSE）
  * Mean Absolute Error(MAE)　平均絶対誤差（MAE）
  * Mean Squared Log Error (MSLE)　 平均二乗誤差対数（MSLE）
  * Mean Absolute Percentage Error(MAPE)　 平均絶対誤差率（MAPE）


!SLIDE

# Regression Loss Function Common Usage回帰損失関数の一般的用途

* MSLE and MAPE handle large ranges,　 MSLEとMAPEは広い範囲に対応 
  * common practice to normalize input to suitable range and use MSE or MAE　通常は、入力を適切な範囲に正規化し、MSEまたはMAEを使用


!SLIDE

# Loss Functions for Classification　分類のための損失関数

* Hinge Loss (SVM) ヒンジロス（SVM）
  * Hard Classification 0,1 a -1,1 classifier　ハード分類0,1 a -1,1分類子
* Logistic Loss (logistic regression)　ロジスティックロス（ロジスティック回帰）
  * Probabilities per class　クラスごとの確率


~~~SECTION:notes~~~

Logistic loss functions are used when probabilities are of greater interest than hard
classifications. 
Great examples of these would be flagging potential fraud, with a
human-in-the-loop solution or predicting the “probability of someone clicking on an
ad”, which can then be linked to a currency number.

Predicting valid probabilities means generating numbers between 0 and 1. Predicting
valid probabilities also mean making sure the probability of mutually exclusive outcomes
should sum to one. 

For this reason, it is essential that the very last layer of a
neural network used in classification is a softmax. Note that the sigmoid activation
function will also give valid values between 0 and 1. 

However it cannot be used in
scenarios where the outputs are mutually exclusive, as it does not model the dependencies
between the output values.

~~~ENDSECTION~~~


!SLIDE

# Negative Log Likelihood　負の対数尤度

* Likelihood　尤度
  * between 0 and 1　0〜1
* Log likelihood　対数尤度
  * between negative infinity and 0　負の無限大（－∞）～0
* Negative log Likelihood　負の対数尤度
  * between 0 and infinity　0〜正の無限大（∞）


~~~SECTION:notes~~~

For the sake of mathematical convenience, when dealing with
the product of probabilities it is customary to convert them to the log of the probabil
ities. 

And hence the product of the probabilities transforms to the sum of the log of
the probabilities.

~~~ENDSECTION~~~

