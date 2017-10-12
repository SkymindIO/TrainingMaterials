# Overview of process for building the materials and other details

## Lab IntelliJ project

Let's use this one. 

https://github.com/tomthetrainer/class_labs

As far as I know it has ALL the possible Labs I have ever written in it. 

The structure is. 

### Demos

Stuff for the isntructor to demonstrate. Currently a simple network to show UI and basic hyper parameters, VGG16, and a spark transform with Datavec

### Labs

This is where the student works, stubbed out file with comments that match the isntructions from the Lab PDF

### Solutions

Complete working solutions

# Building the content. 

The Presentation(slides) are delivered with showoff from puppet labs. 

You build MarkDown, Table of Contents is JSON, apply CSS as needed. The pages rendered are html so html tags can be used as well as Markdown. 

# Presenting the content

Switch to the directory "Time_Series_Analysis_With_DL4J"

Run "showoff serve"

This will launch a Sinatra Ruby web server with the content. 

## Running the Presenter window. 

http://localhost:9090/presenter

Is the presenter window. You will see Nav Panel on left, Slide being server in center and Instructor notes below. 

## Controlling a Slave Window

A browser window pointed at, http://localhost:9090/

Will be driven by the Presenter window. You click next in presenter and the Slave window advances. You annotate the Presenter and it shows up on slave. 

I use this to have two monitors, one with slave broswer full screen and the other with presenter. 

## Editing the content

It should be obvious,feel free to ask or see puppet labs documentation and issues.  

* !SLIDE subsection center  is the topic header, no logo centered text. 
* !SLIDE is the basic slide, logo is applied with some CSS in showoff.css

## Editing the table of contents to add a new section. 

This is less obvious. 

showoff.json controls it. 

It looks like this..

```
{
"name": "DeepLearning: Building Neural Networks with DeepLearning4J",
    "sections": {

        "Welcome to the Course": [
            "Introduction/01.md"
        ],

        "What is DeepLearning?": [
            "What_is_deep_learning/01.md"
        ],

        "Framing the Question":
        ["Framing_the_Question/01.md"],

        "Neural Network Demonstration":
        ["Simplest_network_Lab_intro/01.md"],
```

To add a section do this...

```
{
"name": "DeepLearning: Building Neural Networks with DeepLearning4J",
    "sections": {

        "Welcome to the Course": [
            "Introduction/01.md"
        ],

        "What is DeepLearning?": [
            "What_is_deep_learning/01.md"
        ],
		
		"NEW SECTION": [
            "NEW_DIRECTORY/01.md"
        ],


```

Once a new section is added then make sure you restart the server with showoff serve and refresh the browser windows. 

## Printing a PDF of the slides

This is best done from the presenter window. The command line to pdf fails for me. 

# The Labs

Unfortunately the Labs are still in gitbook and not in showoff. So the labs are built by running "gitbook pdf" in the Labs directory. This creates a file "book.pdf" I tend to rename to Labs.pdf and distribute in class. 

Gitbook is a little different. 

## Gitbook the RULES

Required files. 
README.md, SUMMARY.md

The README becomes first content, the SUMMARY defines table of contents for other content. 


## Adding New Content

Edit SUMMARY.md

Watch the spaces and newlines, when in doubt add a newline :-)

```
# Introduction to Neural Networks with DeepLearning4j Lab Manual


* [Simplest Network Lab](Simplest_network_lab/01.md)


* [DataVec Lab](Iris_DataVec_Lab/01.md)


* [FeedForward Classification Lab](Feedforward_classification/01.md)


* [LSTM Lab](Character_generation_LSTM_Lab/01.md)


* [NEW CHAPTER](Your_New_directory/01.md)

```

## Generate the pdf

Run gitbook pdf in that directory. 

