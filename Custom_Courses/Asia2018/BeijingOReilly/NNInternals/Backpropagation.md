!SLIDE center subsection

# 反向传播与优化方法


!SLIDE

# 什么是反向传播

* 更新神经网络的权重以减少误差的过程
* 正向传播产生输出值
* 误失函数计算误差
* 梯度下降让误差最小化
* 步骤重复, 使网络继续改善



~~~SECTION:notes~~~


Backpropagation learning is the same general idea as the perceptron learning algorithm.
We want to compute the input example’s output with a forward pass through
the network.
If the output matches the label then we don’t do anything.
If the output
does not match the label, then we need to adjust the weights on the connections in
the neural network.


~~~ENDSECTION~~~

!SLIDE

# 在权值空间的梯度下降

<img src="../../resources/convex.png">

~~~SECTION:notes~~~

We consider backpropagation to be doing gradient descent in weights space where the
gradient is on the error surface. This error surface describes the error of the input features
as a function of the weight values in the neural network.

Backpropagation and Fractional Error Responsibility
The general idea with backpropagation is how we distribute the
“blame” backwards through the network. Each hidden node sending
input to the current node is somewhat “responsible” for some
portion of the error in each of the neurons it has a forward connection
to.
The first hidden layer uses the input from the raw feature vector as
input. All subsequent layers use the activation value of the previous
layer’s neurons as input. However, for hidden layers before the output
layer we have to divide up this error appropriately. With error
backpropagation we divide the Δi values according to the connection
weight between the hidden node and the output node.
To calculate Δj in the code above we see the equation:
Δj = g′ input_sumj ΣiWj, iΔi
This equation takes a look at each node i in the current layer and
takes the current error value delta_i and multiplies it by the weight
on the incoming connection times the derivative of the activation
function. This produces the fractional error value for the node in
the previous layer which is used as we update the incoming connections
to that layer. We progressively perform this algorithm


Backpropagation and Mini-Batch Stochastic Gradient Descent
In chapter 1 we learned about a variant of stochastic gradient descent called “minibatch”
where we train the model on multiple examples at once as opposed to a single
example at a time. We see mini-batch used with backpropagation and stochastic gradient
descent in neural networks as well to improve training.
Under the hood we’re computing the average of the gradient across all the the examples
inside the mini-batch. Specifically we compute the forward pass for all of the
examples to get their output scores as a batch linear algebra matrix operation. During
the backward pass for each later we are computing the average of the gradient (for the
88 | Chapter 2: Foundations of Neural Networks
layer). By doing backpropagation this way we’re able to get a better gradient approximation
and use our hardware more efficiently at the same time.

~~~ENDSECTION~~~

!SLIDE

# 适应变化的误差

* 最初误差值大
* 输出大多数是随机的
* 两种方法
  * 动态学习速率
  * 使用自适应优化器（Adaptive Optimizer）


!SLIDE

# 自适应优化器（Adaptive Optimizer） / 动态学习速率

* 最初网络可调以迅速训练
  * 误差大
  * 学习速率大以大步迈向收敛
* 当误差减少时
  * 适将学习速率调小


!SLIDE

# 优化期动画

*  感谢 Alec Radford

<img src="../resources/updater_animation.gif">


!SLIDE

# 优化期动画

* 感谢 Alec Radford

<img src="../resources/updater_animation2.gif">
