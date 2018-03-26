!SLIDE center subsection

# Loss Functions

Loss functions quantify how close a given neural network is to the ideal it is training
towards.

!SLIDE


# The three important functions at work in machine learning optimization:

* parameters
  * transform input to help determine the classifications a network infers
* loss function
  * gauges correctness of output
* optimization function
  * guides it toward the points of least error.
  
!SLIDE

# AVAILABLE LOSS FUNCTIONS

* For Regression
  * MSE(Mean Squared Error)
  * Mean Absolute Error(MAE)
  * Mean Squared Log Error (MSLE)
  * Mean Absolute Percentage Error(MAPE)

!SLIDE

# Regression Loss Function Common Usage

* MSLE and MAPE handle large ranges, 
  * common practice to normalize input to suitable range and use MSE or MAE

!SLIDE

# Loss Functions for Classification

* Hinge Loss (SVM)
  * Hard Classification 0,1 a -1,1 classifier
* Logistic Loss (logistic regression)
  * Probabilities per class  


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

# Negative Log Likelihood

* Likelihood 
  * between 0 and 1
* Log likelihood
  * between negative infinity and 0
* Negative log Likelihood
  * between 0 and infinity


~~~SECTION:notes~~~

For the sake of mathematical convenience, when dealing with
the product of probabilities it is customary to convert them to the log of the probabil
ities. 

And hence the product of the probabilities transforms to the sum of the log of
the probabilities.
~~~ENDSECTION~~~
