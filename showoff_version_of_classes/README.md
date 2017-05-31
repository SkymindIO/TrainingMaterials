# A Showoff slide is delimited with 

!SLIDE

I need to change

------
<page break > 

to slide, I will try sed

This works

sed -e 's/^--.*/!SLIDE/g' 01.md | sed '/^<div*/d' >> 01_showoff_format.md

Need to add !SLIDE at the begining. 


