!SLIDE center subsection

# 损失函数


损失函数测量正在训练的网络与理想的距离


!SLIDE


# 机器学习优选法中3个重要函数

* 参数
  * 转换输入值以确定网络推论的结果
* 损失函数
  * 测量预测值的正确性
* 优化函数
  * 调优网络至最小误差

!SLIDE

# 损失函数

* 回归问题的误差函数
  * 均方误差 MSE(Mean Squared Error)
  * 平均绝对误差 Mean Absolute Error(MAE)
  * 平均对数平方误差 Mean Squared Log Error (MSLE)
  * 平均绝对百分比误差 Mean Absolute Percentage Error(MAPE)

!SLIDE

# 回归误差函数常见用法

* MSE, MAE: 常见做法是将输入值往适当范围归一化然后使用 MSE 和 MAE
* MSLE，MAPE：  处理大范围数值

!SLIDE

# 分类问题的损失函数

* 铰链损失 (支持向量机)
  * -1,1 分类器
* 逻辑损失 (逻辑回归)
  * Probabilities per class （dont know how to translate)


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

# 负对数似然函数

* 似然值
  * 在0和1之间
* 对数似然函数值
  * 在负无穷和0之间
* 负对数似然函数值
  * 在0和无穷之间


~~~SECTION:notes~~~

For the sake of mathematical convenience, when dealing with
the product of probabilities it is customary to convert them to the log of the probabil
ities.

And hence the product of the probabilities transforms to the sum of the log of
the probabilities.
~~~ENDSECTION~~~
