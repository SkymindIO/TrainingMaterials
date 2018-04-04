!SLIDE center subsection

# 权值初始化


!SLIDE

# 为何不把权值全初始化成0？

* 各节点将集中学习同样的东西

!SLIDE

# 解决方案

* 将权值随机化
* 平均值 0 + 随机化分布


!SLIDE

# 概率分布


* 随机变数的概率性结构
* 在统计里， 我们对数据如何分布做出假设
	* 对数据进行推断
* 找出分布中观察值频繁程度的公式
  * 以及怎么从分布中的点取值
  
![alt text](../resources/3_line_graph.png)


!SLIDE

# 权值初始化的挑战性

* 权值太小
  * 信号穿过网络层时减小
  * 变得太小而无法使用
  * 梯度消失
* 全职太大
  * 信号穿过网络层时增长
  * 变得太大而无法使用
  * 梯度爆炸

!SLIDE

# 有效的权值分配技巧

* 截尾正态（Truncated Normal）
* Xavier
* Relu


!SLIDE

# Xavier 分布

* 最普通使用
* 平均值 0 和指定的方差
  * Var(W)=1/nIn

~~~SECTION:notes~~~
where W is the initialization distribution for the neuron in question,
and nIn is the number of neurons feeding into it.
The distribution used is typically Gaussian or uniform.
~~~ENDSECTION~~~

!SLIDE

# Xavier 的好处

* Xavier 启用全面的网络训练 vs 各层预训练
* 大突破




~~~SECTION:notes~~~

Xavier initialization was one of the big enablers of the move away from per-layer generative pre-training.

~~~ENDSECTION~~~


!SLIDE

# ReLu

* add Relu function graph
* 与 CNN 和 ReLu 激活适合一起用
