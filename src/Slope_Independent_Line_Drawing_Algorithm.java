import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Slope_Independent_Line_Drawing_Algorithm implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Slope_Independent_Line_Drawing_Algorithm l = new Slope_Independent_Line_Drawing_Algorithm();
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
       		Scanner r=new Scanner(new File("Slope_Independent_Line_Drawing_Algorithm_INPUT"));
       		while(r.hasNext()){
       			double x0 = r.nextDouble();
                double y0 = r.nextDouble();
                double x1 = r.nextDouble();
                double y1 = r.nextDouble();
                System.out.println("output = "+x0+" "+y0+" "+x1+" "+y1);
                double dx = x1 - x0;
                double dy = y1 - y0;
                // initializing loop variables
                int zone = zoneFinder(x0, y0, x1, y1, dx, dy);
                if (zone == 1 || zone == 2 || zone == 5 || zone == 6) {
                    // Swap (x0,y0)
                    double temp = x0;
                    x0 = y0;
                    y0 = temp;
                    // Swap (x1,y1)
                    temp = x1;
                    x1 = y1;
                    y1 = temp;
                }
                double Dinit = (2.0 * dy) - dx;
                double dE = 2.0 * dy;
                double dNE = 2.0 * (dy - dx);
                double x = x0;
                double y = y0;
                while (x < x1) {
                    if (Dinit < 0) {
                        Dinit += (dE * .001);
                        x += (1 * .001);
                    } else {
                        Dinit += (dNE * .001);
                        x += (1 * .001);
                        y += (1 * .001);
                    }
                    ConvBack(x,y,zone,gl);
                }
                gl.glEnd();
      		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
       	  
       	  
          
          gl.glEnd();
          
      
   }
   public void ConvBack(double x, double y, int zone, GL2 gl) {
       // zone 0
       gl.glColor3f(0f, 0.5f, 0.5f);
       gl.glVertex2d(x / 10, y / 10);
       
       // zone 1
       gl.glColor3f(0f,0f,1f);
       gl.glVertex2d(y / 10, x / 10);
       
       // zone 2
       gl.glColor3f(0f, 1f, 0f);
       gl.glVertex2d(-y / 10, x / 10);
       
       // zone 3
       gl.glColor3f(0f, 1f, 1f);
       gl.glVertex2d(-x / 10, y / 10);
       
       // zone 4
       gl.glColor3f(1f, 0f, 0f);
       gl.glVertex2d(-x / 10, -y / 10);
       
       // zone 5
       gl.glColor3f(1f, 0f, 1f);
       gl.glVertex2d(-y / 10, -x / 10);
       
       // zone 6
       gl.glColor3f(1f, 1f, 0f);
       gl.glVertex2d(y / 10, -x / 10);
       
       // zone 7
       gl.glColor3f(0.5f, 0.5f, 0.5f);
       gl.glVertex2d(x / 10, -y / 10);
   }
   public int zoneFinder(double x0, double y0, double x1, double y1,double dx, double dy){
	   if (Math.abs(dx) > Math.abs(dy)) {
           if (dx > 0 && dy > 0) {
               return 0;
           } else if (dx < 0 && dy > 0) {
               return 3;
           } else if (dx < 0 && dy < 0) {
               return 4;
           } else {
               return 7;
           }
       } else {
           if (dx > 0 && dy > 0) {
               return 1;
           } else if (dx < 0 && dy > 0) {
               return 2;
           } else if (dx < 0 && dy < 0) {
               return 5;
           } else {
               return 6;
           }
       }
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
