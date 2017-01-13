# Midpoint-Line-Drawing-Algorthm
Welcome to the Midpoint-Line-Drawing-Algorithm wiki!
# Midpoin Line drawing algorithm using Open GL
**Midpoint-Line-Drawing-Algorithm Example**
![Midpoint-Line-Drawing-Algorithm](https://github.com/Muhaiminur/Midpoint-Line-Drawing-Algorthm/blob/master/Midpoint%20Line%20example.PNG)
Implement the midpoint line drawing algorithm (slope dependent) only for zone 0. For all the other zones use the GL library function GL_LINES.

1. For given set of coordinates (from a file or randomly generated) determine the zone (0...7)
2. if the zone is '0' implement the midpoint line drawing algorithm for zone 0. draw the line in green color.
3. if the zone is anything other than '0' use the GL_LINES function to draw the line in red color.

Hint:
gl.glColor3f(1f,0f,0f);   //gives us red          
gl.glColor3f(0f,1f,0f);   //gives us green            
gl.glColor3f(0f,0f,1f);   //gives us blue

Step 1:x0=?, y0=?, x1=?, y1=?
Step 2: determine zone
Step 3:
	step 3.1: if zone==0
		step 3.1.1 midpoint line drawing
			dinit, dn, dnw etc.
			glColor3f(green)
			drawPixel()
 
	step 3.2: else
		glColor3f(red)
		glBegin(GL_LINES)
		glVertex(x0,y0)
		glVertex(x1,y1)
		glEnd
# slope independent line drawing algorithm

![slope independent line drawing algorithm](https://github.com/Muhaiminur/Midpoint-Line-Drawing-Algorthm/blob/master/slope%20independent%20line%20drawing%20algorithm.PNG)

Write a program to implement the slope independent line drawing algorithm. 
Steps:
1.	Generate coordinates for a line AB. A(x0,y0) and B(x1,y1)
2.	Determine the zone of the line [0 … 7]
a.	If(|dx|>|dy|) [zones 0,7,3,4]
i.	If(dx>0 && dy>0)
1.	Return Zone=0
ii.	Else if (?)
1.	Return zone=7
iii.	Else if (?)
1.	Return zone=3
iv.	Else 
1.	Return zone=4
b.	Else [zones 1,2,5,6
i.	If(?)
1.	Return Zone=1
ii.	Else if (?)
1.	Return zone=2
iii.	Else if (?)
1.	Return zone=5
iv.	Else 
1.	Return zone=6
3.	Calculate next pixel for zone 0
a.	If (zone 1|| 2||5||6)
i.	Swap (x0,y0)
ii.	Swap (x1,y1)
b.	Dinit=2dy-dx
c.	dNE=?
d.	dE=?
e.	Loop until (x0<x1)
i.	If(dinit<0)
1.	Dinit+=dE
ii.	Else 
1.	Dinit+=dNE
2.	Y++
iii.	X++
iv.	Convert back to correct zones coordinates ConvBack(x,y)

4.	ConvBack(x,y){ //each zone should have a different color
a.	If(zone==0)
      gl.glColor3f(1f,0f,0f);
i.	drawPixel(x,y)
b.	else if (zone==7)
i.	drawPixel(x,-y)
c.	else if(zone==3)
i.	drawPixel(?,?)
d.	else if(zone==4)
i.	drawPixel(?,?))
e.	else if(zone==1)
i.	drawPixel(?,?)
f.	else if(zone==2)
i.	drawPixel(?,?)
g.	else if(zone==3)
i.	drawPixel(?,?)
h.	else if(zone==4)
i.	drawPixel(?,?)


}
gl.glColor3f(1f,0f,0f); //gives us red
gl.glColor3f(0f,1f,0f); //gives us green
gl.glColor3f(0f,0f,1f); //gives us blue


