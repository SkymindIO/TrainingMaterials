# TrainingMaterials
Repo for Training Materials


## Teach from PDF's built from Markdown documents

The way courseware will be delivered is from the PDF in presentation mode. 

Pages instead of slides. 

What we lose in terms of animations, or other features is more than offset by the gain in easy to manage curriculum workflow. 

## What you will find here

This contains the Markdown source for the training materials. 

To Build a PDF from a collection of Modules or chapters use gitbook. 

For example: 

The Directory, Intro_to_Neural_Networks_with_DeepLearning4J contains the modules for the Introduction to Neural Networks with DeepLearning4J course. 

The file book.pdf was created by running gitbook pdf in that directory. 

Gitbook has the following requirements. 

To run it on your machine, you will need gitbook, and Install the command line tools from 
Calibre: https://calibre-ebook.com. Install Calibre, find the path to the command line tools and add to your $PATH. 


## ROLE OF README.md

A README.md file must exist in the directory it is run in. 

In this case the README.md has just one line. 

```
# Introduction to DeepLearning4J 
```

And that becomes the Introduction page to the Document. A project will have mulitiple directories and each one will have it's own README.md and that becomes the intro page to that section. 

## ROLE of SUMMARY.md

Summary

GitBook uses a SUMMARY.md file to define the structure of chapters and subchapters of the book. The SUMMARY.md file is used to generate the book's table of contents.

The format of SUMMARY.md is just a list of links. The link's title is used as the chapter's title, and the link's target is a path to that chapter's file.

Adding a nested list to a parent chapter will create subchapters.

Simple example

```
# Summary

* [Part I](part1/README.md)
    * [Writing is nice](part1/writing.md)
    * [GitBook is nice](part1/gitbook.md)
* [Part II](part2/README.md)
    * [We love feedback](part2/feedback_please.md)
    * [Better tools for authors](part2/better_tools.md)
Each chapter has a dedicated page (part#/README.md) and is split into subchapters.
```

## BUILDING A CUSTOM COURSE

### Example Directory

The Example Directory contains a sample one chapter book. 

Start there and become familiar with the process. 

### Your Custom Course

You can mix and match or re-organize the content we already have by downloading, modifying the SUMMARY.md 
file and running 
```
gitbook pdf
```

And that will build a pdf based upon your SUMMARY.md file

Chapters should be able to be built one chapter at a time, assuming that the practice of including a SUMMARY.md file per directory is maintained, and you symlink or copy the resources folder that contains the image resources into that directory. 

### Modifying the materials.

You are free to do what you like on a local copy, on the master, typos and fixing errors are of course welcome. Major changes should be documented in the updatelog.







