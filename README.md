# Training Class Repo

## Course slides are built with showoff

An Example: 

To build the June 26, OReilly AI time series course

* CD to this directory
TrainingMaterials/Custom_Courses/June_26_OReilly_AI_Class/Time_Series_Analysis_With_DL4J

* RUn this command

```showoff serve```





* Open a browser for the presenter window

http://localhost:9090/presenter

* Open a Slave Browser window for the users

http://localhost:9090/

* Using the presenter window controls the slave window.

Put the slave window on your second monitor and go man go

### Advanced showoff notes

To print the slides for the students

1. Showoff static print 
2. open static/index.html in a browser
3. Print with "save as pdf"

To build a custom version

1. Create custom showoff.json
2. Run showoff -serve -f custom.json


## Course labs are built with gitbook

1. cd TrainingMaterials/Custom_Courses/June_26_OReilly_AI_Class/Labs
2. Generate Labs PDF ``` gitbook pdf ```
3. mv book.pdf Labs.pdf
