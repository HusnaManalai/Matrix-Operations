import javax.swing.*;

public class CalcGraphics{
    
	public static void main(String args[]){
       JFrame frame = new JFrame("Matrix(add, sub, mult)");
      
       
      
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       frame.setSize(700,700);
       
       JButton button = new JButton("Choose Operation");
       
       frame.getContentPane().add(button); // Adds Button to content pane of frame
       
       
       JLabel label = new JLabel();
       label.setText("HELLO WELCOME");
       label.setText("You can add, subtract or multiply square matrices!");
    	   
       frame.add(label);       
       
       
       
       
       
       
       
       
       
       
       frame.setVisible(true);
       
    }
}