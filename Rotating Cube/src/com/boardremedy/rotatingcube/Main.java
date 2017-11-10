/** 
 *  @author keyboardroaster@gmail.com
 *  @version 0.1
 * */

package com.boardremedy.rotatingcube;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends JComponent
{

	public static void main(String args[]) throws Exception 
	{
	    JFrame f = new JFrame("Rotating Cube");
	    f.setSize(300, 300);
	    f.setLocation(300, 300);
	    f.setResizable(false);
	        
	    final Vectoroperations vo = new Vectoroperations();
	    final Vectortransformations vt = new Vectortransformations();
	    
	    JPanel p = new JPanel() 
	    {
	    	double angle = 0.0;
	    	
	        {
	            Timer timer = new Timer();	// timer to redraw the cube every 100ms
	            timer.scheduleAtFixedRate(new TimerTask() 
	            {
	            	  @Override
	            	  public void run() 
	            	  {
	            		  repaint();
	            		  System.out.println("rotation step");
	            	  }
	            }, 0, 100);	// 100ms period
	        }

	        public void paint(Graphics g) 
	        {
	            super.paint(g);
	            
	            g.setColor(Color.RED);
	                
	            // position vectors of cube corner points
	        	Vector4D vector_1 = new Vector4D(-50,-50,-50, 1);
	        	Vector4D vector_2 = new Vector4D(50,-50,-50, 1);
	        	Vector4D vector_3 = new Vector4D(50,50,-50, 1);
	        	Vector4D vector_4 = new Vector4D(-50,50,-50, 1);
	        	Vector4D vector_5 = new Vector4D(-50,-50,50, 1);
	        	Vector4D vector_6 = new Vector4D(50,-50,50, 1);
	        	Vector4D vector_7 = new Vector4D(50,50,50, 1);
	        	Vector4D vector_8 = new Vector4D(-50,50,50, 1);
	        	    
	        	// offset to origin
	        	Vector4D vector_offset = new Vector4D(150,120,0, 1);	
	        	   
	        	// rotate cube for 'angle' @ y-axis 
	        	vt.rotation3DaxisY(vector_1, angle);
	        	vt.rotation3DaxisY(vector_2, angle);
	        	vt.rotation3DaxisY(vector_3, angle);
	        	vt.rotation3DaxisY(vector_4, angle);
	        	vt.rotation3DaxisY(vector_5, angle);
	        	vt.rotation3DaxisY(vector_6, angle);
	        	vt.rotation3DaxisY(vector_7, angle);
	        	vt.rotation3DaxisY(vector_8, angle);
	        	    
	        	// rotate cube for 20° @ x-axis
	        	vt.rotation3DaxisX(vector_1, 20);
	        	vt.rotation3DaxisX(vector_2, 20);
	        	vt.rotation3DaxisX(vector_3, 20);
	        	vt.rotation3DaxisX(vector_4, 20);
	        	vt.rotation3DaxisX(vector_5, 20);
	        	vt.rotation3DaxisX(vector_6, 20);
	        	vt.rotation3DaxisX(vector_7, 20);
	        	vt.rotation3DaxisX(vector_8, 20);
	        	    
	        	// add to each position vector an offset (100,100)
	        	vector_1 = vo.sumVector4D(vector_1, vector_offset);
	        	vector_2 = vo.sumVector4D(vector_2, vector_offset);
	        	vector_3 = vo.sumVector4D(vector_3, vector_offset);
	        	vector_4 = vo.sumVector4D(vector_4, vector_offset);
	        	vector_5 = vo.sumVector4D(vector_5, vector_offset);
	        	vector_6 = vo.sumVector4D(vector_6, vector_offset);
	        	vector_7 = vo.sumVector4D(vector_7, vector_offset);
	        	vector_8 = vo.sumVector4D(vector_8, vector_offset);    	    
	        	  
	        	// build a cube from the position vectors 
	        	g.drawLine((int)vector_1.x, (int)vector_1.y, (int)vector_2.x, (int)vector_2.y);
	        	g.drawLine((int)vector_2.x, (int)vector_2.y, (int)vector_6.x, (int)vector_6.y);
	        	g.drawLine((int)vector_6.x, (int)vector_6.y, (int)vector_5.x, (int)vector_5.y);
	        	g.drawLine((int)vector_5.x, (int)vector_5.y, (int)vector_1.x, (int)vector_1.y);
	        	    
	        	g.drawLine((int)vector_1.x, (int)vector_1.y, (int)vector_4.x, (int)vector_4.y);
	        	g.drawLine((int)vector_2.x, (int)vector_2.y, (int)vector_3.x, (int)vector_3.y);
	        	g.drawLine((int)vector_6.x, (int)vector_6.y, (int)vector_7.x, (int)vector_7.y);
	        	g.drawLine((int)vector_5.x, (int)vector_5.y, (int)vector_8.x, (int)vector_8.y);
	        	    
	        	g.drawLine((int)vector_4.x, (int)vector_4.y, (int)vector_3.x, (int)vector_3.y);
	        	g.drawLine((int)vector_3.x, (int)vector_3.y, (int)vector_7.x, (int)vector_7.y);
	        	g.drawLine((int)vector_7.x, (int)vector_7.y, (int)vector_8.x, (int)vector_8.y);
	        	g.drawLine((int)vector_8.x, (int)vector_8.y, (int)vector_4.x, (int)vector_4.y);
	        	    
	        	// increase angle +5° -> causes rotation around the y-axis
	        	angle = angle + 5;
	         } 
	    };
	    
	    f.add(p);
	    f.setVisible(true); 
	}
}
	

