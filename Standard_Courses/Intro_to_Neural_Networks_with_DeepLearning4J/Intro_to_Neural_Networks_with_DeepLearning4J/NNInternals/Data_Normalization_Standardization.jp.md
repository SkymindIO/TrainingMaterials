!SLIDE center subsection

# Data Normalization and Standardization　データの正規化と標準化

!SLIDE

# Normalization is first step for most Machine Learning　正規化はほとんどの機械学習での最初のステップ

* Prevent Features with large natural scale from dominating　大規模で自然なスケールの特徴に支配されない
* Set min to 0 max to 1　最低0～最大1に設定
* Exception for Tree Based Machine Learning　ツリーベースの機械学習の例外
  * Can cope with varying ranges　変動レンジに対応可
* No Exceptions for Neural Networks　ニューラルネットワークに例外なし


!SLIDE

# Normalization　正規化

* Convert to range of values 0-1　0〜1の範囲へ変換
  * Max Value becomes 1　最大値1
  * Min Value becomes 0　最小値0


!SLIDE

# Standardization　標準化

* More Common　より一般的
* Convert Values to　値の変換
  * mean 0　平均0
  * Standard Deviation of 1　標準偏差1


!SLIDE

# Data Analysis　データ分析

* Datavec provides analysis tool　 Datavecは分析ツール
* Min max standard deviation etc　最小最大標準偏差等
* Also generates histograms　ヒストグラムも生成


~~~SECTION:notes~~~

# Min Max Scaler

# Put sharper point on this
# See blog http://sebastianraschka.com/Articles/2014_about_feature_scaling.html
~~~ENDSECTION~~~

