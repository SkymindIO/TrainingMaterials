!SLIDE center subsection

# Data Normalization and Standardization


!SLIDE

# Normalization is first step for most Machine Learning

* Prevent Features with large natural scale from dominating
* Set min to 0 max to 1
* Exception for Tree Based Machine Learning
  * Can cope with varying ranges
* No Exceptions for Neural Networks

!SLIDE

# Normalization

* Convert to range of values 0-1
  * Max Value becomes 1
  * Min Value becomes 0

!SLIDE

# Standardization

* More Common
* Convert Values to 
  * mean 0
  * Standard Deviation of 1
  
!SLIDE

# Data Analysis

* Datavec provides analysis tool
* Min max standard deviation etc
* Also generates histograms



~~~SECTION:notes~~~

# Min Max Scaler


# Put sharper point on this
# See blog http://sebastianraschka.com/Articles/2014_about_feature_scaling.html
~~~ENDSECTION~~~
