!SLIDE center subsection

# Weight Initialization　重みの初期化

!SLIDE

# Why not initialize all weights to zero?　すべての重みをゼロに初期化しない理由は？

* Nodes would never diverge　ノードは決して分岐しないため
  * All would learn the same thing　全ノードが同じことを学ぶ

   *
!SLIDE

# Solution　解決策

* Randomize weights　重みをランダムにする
* Mean 0 + some randomized distribution　平均0＋いくつかのランダム分布にする


!SLIDE

# Probability Distributions　確率分布

* A specification of the stochastic structure of random variables　ランダムな変数の確率的構造を明らかにする
* In statistics we rely on making assumptions about how the data is distributed　統計学ではどのようにデータが分布するかを想定し、これを頼りにする
	* To make inferences about the data　データを推測するため
* We want a formula specifying how frequent values of observations in the distribution are　分布における観測値の頻度が明らかになる公式が欲しい
	* And how values can be taken by the points in the distribution分布上の点からの値の取り方
![alt text](../resources/3_line_graph.png)



!SLIDE

# Weight Initialization: The Challenge　重みの初期化：課題

* Weights too small　小さすぎる重み
  * Signal shrinks as it passes through layers　信号が層を通過時に信号が収縮する
  * Becomes too small to be useful　小さすぎるため役に立たない
  * Vanishing Gradient Problem　勾配消失の問題
* Weights too large　大きすぎる重み
  * Signal Grows as it passes through Layers　信号がレイヤーを通過時に信号が拡大する
  * Becomes to large to be useful　大きすぎるため役に立たない
  * Exploding Gradient Problem　勾配急増の問題


!SLIDE

# Further Challenges of Weight Initialization　重みの初期化のさらなる課題

* Choose weights appropriate to number of connections/size of Layer　層の接続数・サイズに応じた重みを選択
* Outliers throw things off　外れ値は混乱を引き起こす


!SLIDE

# Useful Weight Distribution Techniques　有用な重み分布技術

* Xavier　 Xavier分布
* Relu　 Relu関数


!SLIDE

# Xavier Distribution　 Xavier分布

* Most Common　最も一般的
* 0 mean and a specific variance　0平均値と特定の分散値
  * Var(W)=1/nIn


~~~SECTION:notes~~~ 
where W is the initialization distribution for the neuron in question, 
and nIn is the number of neurons feeding into it. 
The distribution used is typically Gaussian or uniform.
~~~ENDSECTION~~~

!SLIDE 

# Benefits of Xavier　 Xavierの利点

* Xavier Enabled Full Network Training vs per-Layer Pre-Training　Xavierによりフルネットワークの訓練vs層毎の事前訓練ができる
* Big Breakthrough　ブレークスルー



~~~SECTION:notes~~~

Xavier initialization was one of the big enablers of the move away from per-layer generative pre-training.

~~~ENDSECTION~~~


!SLIDE

# Relu　 Relu関数

* Relu　 Relu関数
* Works well with CNN's and Relu activations　 CNNとRelu関数による活性化に有用




