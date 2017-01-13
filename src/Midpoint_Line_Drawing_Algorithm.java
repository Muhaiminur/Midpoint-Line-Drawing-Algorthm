import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Midpoint_Line_Drawing_Algorithm implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	   Midpoint_Line_Drawing_Algorithm l = new Midpoint_Line_Drawing_Algorithm();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
       	  try {
       		Scanner s = new Scanner(new File("Midpoint_Line_Drawing_Algorithm_Input.txt"));
            double x0 =0.0;
            double y0=0.0;
            double x1=0.0;
            double y1=0.0;
            while(s.hasNext()){

                x0 = s.nextDouble();
                y0 = s.nextDouble();


                x1 = s.nextDouble();
                y1 = s.nextDouble();
                double dx =x1-x0;
                double dy=y1-y0;
                //gl.glVertex2d(fx,fy);

                //System.out.println(fx+" "+fy+" "+lx+" "+ly);
                if(abs(dx)>=abs(dy)){ //****zone 0,3,4,7*******
                    if(dx>=0 && dy>=0){ // zone 0
                        double d = 2*dy - dx;
                        double dE = 2*dx;
                        double dNE = 2*dy - 2*dx;
                        double x=x0;
                        double y=y0;

                        gl.glVertex2d(x,y);
                        gl.glColor3d(0.0, 1.0, 0.0);

                        while(x<x1){
                            if(d>0){ //dNE
                                x+=.001;
                                y+=.001;
                                d+=dNE;
                            }else{ //dE
                                x+=.001;
                                d+=dE;
                            }
                            gl.glVertex2d(x,y);
                            gl.glColor3d(0.0, 1.0, 0.0);
                        }
                    }else if(dx>=0 && dy<0){ //zone 7
                        double d = 2*dy + dx;
                        double dE = 2*dy;
                        double dSE = 2*dy + 2*dx;
                        double x=x0;
                        double y=y0;

                        gl.glVertex2d(x,y);
                        gl.glColor3d(1.0, 0.0, 0.0);

                        while(x<x1){
                            if(d>0){ //dE
                                x+=.001;
                                d+=dE;
                            }else{ //dSE
                                x+=.001;
                                y-=.001;
                                d+=dSE;
                            }
                            gl.glVertex2d(x,y);
                            gl.glColor3d(1.0, 0.0, 0.0);
                        }
                    }else if(dx<0 && dy>=0){ //zone 3
                        double d = -2*dy - dx;
                        double dW = -2*dy;
                        double dNW = -2*dy - 2*dx;
                        double x=x0;
                        double y=y0; 

                        gl.glVertex2d(x,y);
                        gl.glColor3d(1.0, 0.0, 0.0);

                        while(x>x1){
                            if(d>0){ //dW
                                x-=.001;
                                d+=dW;
                            }else{ //dNW
                                x-=.001;
                                y+=.001;
                                d+=dNW;
                            }
                            gl.glVertex2d(x,y);
                            gl.glColor3d(1.0, 0.0, 0.0);
                        }
                    }else { //zone 4
                        double d = -2*dy + dx;
                        double dW = -2*dy;
                        double dSW = -2*dy + 2*dx;
                        double x=x0;
                        double y=y0;

                        gl.glVertex2d(x,y);
                        gl.glColor3d(1.0, 0.0, 0.0);

                        while(x>x1){
                            if(d>0){ //dSW
                                x-=.001;
                                y-=.001;
                                d+=dSW;
                            }else{ //dW
                                x-=.001;
                                d+=dW;
                            }
                            gl.glVertex2d(x,y);
                            gl.glColor3d(1.0, 0.0, 0.0);
                        }
                    }
                }else{ //*******zone 1,2,5,6***********
                    if(dx>=0 && dy>=0){ //zone1
                        double d = dy - 2*dx;
                        double dN = -2*dx;
                        double dNE = 2*dy - 2*dx;
                        double x=x0;
                        double y=y0;

                        gl.glVertex2d(x,y);
                        gl.glColor3d(1.0, 0.0, 0.0);

                        while(y<y1){
                            if(d>0){ //dN
                                y+=.001;
                                d+=dN;
                            }else{ //dNE
                                y+=.001;
                                x+=.001;
                                d+=dNE;
                            }
                            gl.glVertex2d(x,y);
                            gl.glColor3d(1.0, 0.0, 0.0);
                        }
                    }else if(dx>=0 && dy<0){ //zone 6
                        double d = dy + 2*dx;
                        double dS = 2*dx;
                        double dSE = 2*dy + 2*dx;
                        double x=x0;
                        double y=y0;

                        gl.glVertex2d(x,y);
                        gl.glColor3d(1.0, 0.0, 0.0);

                        while(y>y1){
                            if(d>0){ //dSE
                                x+=.001;
                                y-=.001;
                                d+=dSE;
                            }else{ //dS
                                y-=.001;
                                d+=dS;
                            }
                            gl.glVertex2d(x,y);
                            gl.glColor3d(1.0, 0.0, 0.0);
                        }
                    }else if(dx<0 && dy>=0){ //zone 2
                        double d = -dy - 2*dx;
                        double dN = -2*dx;
                        double dNW = -2*dy - 2*dx;
                        double x=x0;
                        double y=y0;

                        gl.glVertex2d(x,y);
                        gl.glColor3d(1.0, 0.0, 0.0);

                        while(y<y1){
                            if(d>0){ //dN
                                y+=.001;
                                d+=dN;
                            }else{ //dNW
                                x-=.001;
                                y+=.001;
                                d+=dNW;
                            }
                            gl.glVertex2d(x,y);
                            gl.glColor3d(1.0, 0.0, 0.0);
                        }
                    }else{ //zone 5
                        double d = -dy + 2*dx;
                        double dS = 2*dx;
                        double dSW = -2*dy + 2*dx;
                        double x=x0;
                        double y=y0;

                        gl.glVertex2d(x,y);
                        gl.glColor3d(1.0, 0.0, 0.0);

                        while(y>y1){
                            if(d>0){ //dS
                                y-=.001;
                                d+=dS;
                            }else{ //dSW
                                x-=.001;
                                y-=.001;
                                d+=dSW;
                            }
                            gl.glVertex2d(x,y);
                            
                        }
                    }
                }
            }

		} catch (Exception e) {
			// TODO: handle exception
		}
       	  
       	  
          
          gl.glEnd();
          
      
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;

//public class CSE423LAB01CLASS
