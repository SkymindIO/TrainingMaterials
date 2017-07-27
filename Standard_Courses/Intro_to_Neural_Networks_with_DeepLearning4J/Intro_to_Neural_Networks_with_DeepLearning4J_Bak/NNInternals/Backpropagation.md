!SLIDE center subsection

# Back Propagation and Updaters/optimizers


!SLIDE

# What is BackPropagation

* The process of updating the weights of a Neural Network to reduce error
* The Forward Pass generates an output
* The Loss Function calculates the error
* Gradient Descent is used to minimize the error
* Steps are repeated and network continues to improve



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

# Gradient Descent in Weight Space

* Use Josh's picture here


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

# Adapting to Changing Error 

* Initially error will be large
* Output more or less random
* Two approaches
  * Dynamic Learning Rate(Anneal the Learning Rate)
  * Use Adaptive Optimizer


!SLIDE 

# Adaptive Optimizers / Dynamic Learning Rate a Simplified View
 
* Initially you want the network to train quickly
  * Error is large
  * Take Large Steps
* As Error decreases
  * Smaller steps are better
  
  
!SLIDE

# Updater Animation

* Thanks to Alec Radford

<img src="../resources/updater_animation.gif">


!SLIDE 

# Updater Animation

* Thanks to Alec Radford

<img src="../resources/updater_animation2.gif">


 
