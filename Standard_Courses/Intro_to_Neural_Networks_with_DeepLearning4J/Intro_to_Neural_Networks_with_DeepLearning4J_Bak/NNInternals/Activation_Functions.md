!SLIDE center subsection

# Activation Functions

!SLIDE

# What is an Activation Function

* Determines output of Neuron Based on Inputs
* Non-Linear Transform function at each node
* Defined per layer
* Allow neural networks to make complex boundary decisions for features at various levels of abstraction.

!SLIDE

# Common Activation Functions

# Keep SImple Listing and move most to the appendix

DeepLearning4J and Keras support the following Activation functions

* CUBE
* ELU
* HARDSIGMOID
* HARDTANH
* IDENTITY
* LEAKYRELU

!SLIDE 

# Supported Activation Functions...


* RATIONALTANH
* RELU
* RRELU
* SIGMOID
* SOFTMAX
* SOFTPLUS
* SOFTSIGN
* TANH

!SLIDE

# Commonly Used Activation Functions

* Sigmoid
* TanH
* Relu

!SLIDE
 
# Activation Functions

![img](../resources/Activation-func.png)
 
!SLIDE
 
# Output Layer Activation
 
* Special Case
* Goal of hidden Layer activation is to squash intermediate values
* Goal of output Layer is to answer our question
  * Classification = softmax
  * regression = identity


!SLIDE

# Output Layer Guidelines

* Classification 
  * softmax activation
  * Negative Log Likelihood for loss Function 
  * Multi Class Cross Entropy
* Softmax
  * Probability Distribution over classes
  * Outputs sum to 1.0
* Regression
  * Identity Activation
  * MSE(Mean Squared Error) Loss Function

~~~SECTION:notes~~~

activation function for the output layer: 
this is usually application specific. 
For classification problems, you generally want to use the softmax activation function, combined with the negative log likelihood / MCXENT (multi-class cross entropy). 

The softmax activation function gives you a probability distribution over classes (i.e., outputs sum to 1.0). For regression problems, the “identity” activation function is frequently a good choice, in conjunction with the MSE (mean squared error) loss function.


~~~ENDSECTION~~~
