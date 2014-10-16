package game2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class label extends JLabel{
	public int a;
	public label (){
		a=-1;
		this.setcolor();
		this.setText("");
		 setOpaque(true);
	}
	public void setcolor(){
	if (a==1)
		super.setBackground(Color.GRAY );		
	else 
		{
		this.setBackground(Color.LIGHT_GRAY);
		}
		}
}
class gamewin extends JFrame implements MouseListener,ActionListener{
	
	 JPanel p1=new JPanel();  
     JPanel p2=new JPanel();  
     int fs = 0 ;
     
     JLabel fenshu = new JLabel("次数:\n"+fs);
     label [][] cube=new label[5][5];
     JButton jb = new JButton("重新开始");
     JDialog dialog = new JDialog();
		JLabel label=new JLabel("你赢了，重新开始？");
		JButton button = new JButton("ok");
     int i,j;
     
	 public gamewin() {
			
		 super.setTitle("game2");
		 super.setResizable(false);
		 super.setVisible(true);
		 super.setBounds(80,80,500,300);
		
		 super.add(p1,BorderLayout.CENTER); 
		 super.add(p2,BorderLayout.EAST);
		 this.p1.setLayout(new GridLayout(5,5,3,3));
		 this.p2.setLayout(new GridLayout(6,1,3,3));
		 jb.addMouseListener(this);
		 
		 for( i=0;i<5;i++){
			 for ( j = 0; j < 5; j++) {
				cube[i][j]=new label(); 
				cube[i][j].addMouseListener(this);
	           this.p1.add(cube[i][j]); }
	        }  
		
		 this.p2.add(this.fenshu);
		 this.p2.add(this.jb);
		 dialog.setLayout(new GridLayout(2,1));
			dialog.add(label);
			dialog.add(button);
			dialog.setSize(200,100);
			dialog.setLocation(200, 200);
			dialog.setVisible(false);
			button.addActionListener(this);
		}
	 public void chang(int a,int b){
		 System.out.print(a+" "+b);
		 this.cube[a][b].a =  this.cube[a][b].a*(-1);this.cube[a][b].setcolor();
		 if (a!=0)	{ this.cube[a-1][b].a =  this.cube[a-1][b].a*(-1);this.cube[a-1][b].setcolor(); }
		 if (b!=0)	{ this.cube[a][b-1].a =  this.cube[a][b-1].a*(-1);this.cube[a][b-1].setcolor();}
		 if (a!=4)	 {this.cube[a+1][b].a =  this.cube[a+1][b].a*(-1); this.cube[a+1][b].setcolor();}
		 if (b!=4)	 {this.cube[a][b+1].a =  this.cube[a][b+1].a*(-1);this.cube[a][b+1].setcolor();}
		 
	 }
	 public void win(){
		 int k=0;
		 for( int i=0;i<5;i++){
			 for (int  j = 0; j < 5; j++) {
				if (this.cube[i][j].a==-1) 
					k++;
				
	        }
	        }
		 if (k==25)
			 dialog.setVisible(true);
			 
	}
	public void mouseClicked(MouseEvent e) {
		int n=0 ,m=0;
		if (e.getSource()==jb)
		{
			for( int i=0;i<5;i++){
				 for (int  j = 0; j < 5; j++) {
					cube[i][j].a=-1; 
					cube[i][j].setcolor();
		        }
		        }
			fs=0;
			this.fenshu.setText("次数:\n"+fs);
			
		}
		for ( n = 0; n < 5; n++) {
			for ( m = 0; m <5; m++) {
				 if (e.getSource()==cube[n][m])
				 {
					 this.fs++;
					 this.fenshu.setText("次数:\n"+fs);
					 chang(n,m);
					 System.out.print("点击");
				 }
			}
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==button)
		{
			for( int i=0;i<5;i++){
				 for (int  j = 0; j < 5; j++) {
					cube[i][j].a=-1; 
					cube[i][j].setcolor();
		        }
		        }
			fs=0;
			this.fenshu.setText("次数:\n"+fs);
		}
		
	}
	
	
}
public class game2 {

	public static void main(String[] args) {
		
		gamewin jfg  = new gamewin()  ;
	}

}
