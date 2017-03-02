/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */


/*
Java Homework 2
Author: Eason Smith 
des460@nyu.edu

*/
package hw2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
        
/**
 *
 * @author epiczero
 */
public class HW2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int rows = 4;
        int cols = 2;
        
        MyFrame jf = new MyFrame(500,500,"Window of buttons",rows,cols);
        
    }
}

//creates buttons and listens for button presses
class MyFrame extends JFrame implements ActionListener{
    
    MyButton[] jbarr;
    int numbuttons = 0;
        
    MyFrame(int width,int height, String title,int rows, int cols){
        numbuttons = rows*cols;
        
        this.setTitle(title);
        this.setSize(width,height);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        //make window in the center of the screen 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        //create and add 2 jpanels
        JPanel jp = new JPanel();
        this.add(jp);
        jp.setLayout(new BorderLayout());
        JPanel jpCenter = new JPanel();
        jp.add(jpCenter, BorderLayout.CENTER);
        jpCenter.setLayout(new GridLayout(rows, cols));
        
        //create and init buttons. Register action listener. add them to panel.
        jbarr = new MyButton[numbuttons];
        for(int i =0; i < numbuttons; i++){
            jbarr[i] = new MyButton("b"+ i);
            //jbarr[i].addActionListener(new ButtonPress());
            jbarr[i].addActionListener(this);
            jpCenter.add(jbarr[i]);
        }     
    }
    
    //change all the button colors except the button pressed
    public void actionPerformed(ActionEvent e) {
        MyButton jb = (MyButton) e.getSource();
        for(int i =0; i < numbuttons; i++){
            if(jbarr[i] != jb){
                jbarr[i].changeToRandomColor();
            }
        }
    }
}

//button class
class MyButton extends JButton {

    //initialize with random color
    MyButton(String s) {
        setText(s);
        changeToRandomColor();
    }
    
    //change the color of the button
    public void changeToRandomColor() {
        setVisible(false);
        Random rand = new Random(); //initialize random number gen
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color myColor = new Color(r,g,b);
        setBackground(myColor);
        setVisible(true);
        }
}
    
/*
//button press event listner class (not currently implimented)
class ButtonPress implements ActionListener{
    MyButton arr[];
    
    //constructor
    ButtonPress(){ }
    
    //set colors on event
    @Override
    public void actionPerformed(ActionEvent ae){
        MyButton jb = (MyButton) ae.getSource();
        for(MyButton c: arr){
            if(c != jb){
                c.changeToRandomColor();
             }
        }
    }
}*/
    

    

