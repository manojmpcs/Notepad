//creation of notepad
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Dimension;
import java.awt.Toolkit.*;
import javax.swing.event.*;
import java.time.*;
public class Notepad1 extends JFrame implements ActionListener,KeyListener,CaretListener
{
int i=17;
int j=79;
Container c;
public JTextArea ta;
String str="";
String str1="";
String str2;
JMenuBar mb;
JMenu  file,edit,format,help;
JMenuItem new1,open,save,saveas,exit,cut,copy,paste,delete,selectall,time,font,about;
JCheckBoxMenuItem wordwrap;
String d,o,h,selectedText,s7,r1;
int n1,gg,dot,mark;
Notepad1(String s,String l,String m,String s1,int b,String f,String o1)
{
c=getContentPane();
c.setLayout(new BorderLayout());
d=s;
o=l;
h=m;
gg=b;
str2=f;
r1=o1;
int n=Integer.parseInt(m);
if(l.equals("Regular"))
{
n1=(int)Font.PLAIN;
}
if(l.equals("Italic"))
{
n1=(int)Font.ITALIC;
}
if(l.equals("Bold"))
{
n1=(int)Font.BOLD;
}
if(l.equals("Bold Italic"))
{
n1=(int)(Font.BOLD+Font.ITALIC);
}
ImageIcon img=new ImageIcon("index1.jpg");
setIconImage(img.getImage());
mb=new JMenuBar();
ta=new JTextArea(s1);
c.add("North",mb);
file=new JMenu("File");
edit=new JMenu("Edit");
format=new JMenu("Format");
help=new JMenu("Help");
mb.add(file);
mb.add(edit);
mb.add(format);
mb.add(help);
new1=new JMenuItem("New                 Ctrl+N");
open=new JMenuItem("Open...            Ctrl+O");
save=new JMenuItem("Save                Ctrl+S");
saveas=new JMenuItem("Save As...         ");
exit=new JMenuItem("Exit       ");
file.add(new1);
file.add(open);
file.add(save);
file.add(saveas);
file.add(exit);
cut=new JMenuItem("Cut                     Ctrl+X");
copy=new JMenuItem("Copy                  Ctrl+C");
paste=new JMenuItem("Paste                Ctrl+V");
delete=new JMenuItem("Delete                    del");
selectall=new JMenuItem("Select All         Ctrl+A");
time=new JMenuItem("Time/Date              F5");
cut.setEnabled(false);
copy.setEnabled(false);
delete.setEnabled(false);
edit.add(cut);
edit.add(copy);
edit.add(paste);
edit.add(delete);
edit.add(selectall);
edit.add(time);
wordwrap=new JCheckBoxMenuItem("Word Wrap");
font=new JMenuItem("Font... ");
format.add(wordwrap);
format.add(font);
about=new JMenuItem("About Notepad");
help.add(about);
JScrollPane pane=new JScrollPane();
ta.setFont(new Font(s,n1,n));
ta.setWrapStyleWord(true);
pane.getViewport().add(ta);
c.add(pane);
exit.addActionListener(this);
open.addActionListener(this);
saveas.addActionListener(this);
save.addActionListener(this);
new1.addActionListener(this);
delete.addActionListener(this);
time.addActionListener(this);
wordwrap.addActionListener(this);
font.addActionListener(this);
about.addActionListener(this);
cut.addActionListener(this);
paste.addActionListener(this);
copy.addActionListener(this);
selectall.addActionListener(this);
ta.addKeyListener(this);
ta.addCaretListener(this);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void caretUpdate(CaretEvent ce)
   {
         dot=ce.getDot();
         mark=ce.getMark();

              if(dot!=mark)
{
              selectedText=ta.getSelectedText();
cut.setEnabled(true);
copy.setEnabled(true);
delete.setEnabled(true);
}
              else 
{
selectedText=null;
cut.setEnabled(false);
copy.setEnabled(false);
delete.setEnabled(false);
}

   }
public static void main(String a[])
{
Notepad1 p=new Notepad1("Consolas","Regular","12","",0,"","Untitled");
p.setSize(1370,730);
p.setTitle("Untitled - Notepad");
p.setVisible(true);
}
public void actionPerformed(ActionEvent e) 
{
if(exit.isArmed()) System.exit(0);
if(open.isArmed()) this.openFile();
if(saveas.isArmed()) this.saveasFile();
if(save.isArmed())this.saveFile();
if(new1.isArmed())
{
Notepad1 p=new Notepad1("Consolas","Regular","12","",0,"","Untitled");
p.setSize(1370,730);
p.setTitle("Untitled - Notepad1");
p.setVisible(true);
this.dispose();
}
if(time.isArmed())
{
LocalDate date=LocalDate.now();
int dd=date.getDayOfMonth();
int mm=date.getMonthValue();
int yy=date.getYear();
LocalTime time=LocalTime.now();
int h=time.getHour();
int m=time.getMinute();
String str=""+h+":"+m+" "+dd+"-"+mm+"-"+yy;
int i=ta.getCaretPosition();
ta.insert(str,i);
}
if(delete.isArmed())
{
if(mark<dot)
{
ta.replaceRange("",mark,dot);
}
else
{
ta.replaceRange("",dot,mark);
}
}
if(cut.isArmed())
{
s7=selectedText;
if(mark<dot)
{
ta.replaceRange("",mark,dot);
}
else
{
ta.replaceRange("",dot,mark);
}
}
if(copy.isArmed())
{
s7=selectedText;
}
if(font.isArmed()) 
{
this.fontFile();
}
if(paste.isArmed())
{
int i=ta.getCaretPosition();
ta.insert(s7,i);
}
if(selectall.isArmed())
{
ta.selectAll();
}
if(about.isArmed())this.aboutFile();
if(wordwrap.getModel().isSelected()) ta.setLineWrap(true);
else ta.setLineWrap(false);
}
public void keyPressed(KeyEvent e)
{
if((e.getKeyCode()==KeyEvent.VK_O)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0))
this.openFile();
if((e.getKeyCode()==KeyEvent.VK_S)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0))
this.saveFile();
if((e.getKeyCode()==KeyEvent.VK_Z)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
if((e.getKeyCode()==KeyEvent.VK_X)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
if((e.getKeyCode()==KeyEvent.VK_C)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
if((e.getKeyCode()==KeyEvent.VK_V)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
if((e.getKeyCode()==KeyEvent.VK_F)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
if((e.getKeyCode()==KeyEvent.VK_H)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
if((e.getKeyCode()==KeyEvent.VK_G)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
if((e.getKeyCode()==KeyEvent.VK_A)&&((e.getModifiers()&KeyEvent.CTRL_MASK)!=0)){}
}
public void keyReleased(KeyEvent e)
{
}
public void keyTyped(KeyEvent e){}
void openFile()
{
JFileChooser jc=new JFileChooser();
int i=jc.showOpenDialog(this);
if(i==JFileChooser.APPROVE_OPTION)
{
File f=jc.getSelectedFile();
String fname=f.getPath();
try{
BufferedReader br=new BufferedReader(new FileReader(fname));
while((str=br.readLine())!=null)
str1+=str+"\n";
ta.setText(str1);
br.close();
}
catch(Exception e){}
}
}
void saveasFile() 
{
try
{
JFileChooser fc=new JFileChooser();
int i=fc.showSaveDialog(this);
str2=fc.getSelectedFile()+".txt";
File st=fc.getSelectedFile();
r1=fc.getName(st);
FileWriter fw=new FileWriter(str2);
String s=ta.getText();
fw.write(s);
this.setTitle(r1+" - Notepad");
fw.close();
}
catch(Exception e){}
}
void saveFile()
{
if(gg==0)
{
try
{
JFileChooser fc=new JFileChooser();
int i=fc.showSaveDialog(this);
str2=fc.getSelectedFile()+".txt";
File st=fc.getSelectedFile();
r1=fc.getName(st);
FileWriter fw=new FileWriter(str2);
String s=ta.getText();
fw.write(s);
this.setTitle(r1+" - Notepad");
fw.close();
gg++;
}
catch(Exception e){}
}
else
{
try
{
FileWriter fw=new FileWriter(str2);
String s=ta.getText();
fw.write(s);
fw.close();
}
catch(Exception e){}
}
}
void fontFile()
{
String s6=ta.getText();
this.dispose();
MyFont f=new MyFont(s6,d,o,h,gg,str2,r1);
f.setTitle("Font");
f.setSize(400,450);
f.setVisible(true);
}
void aboutFile()
{
About b=new About();
b.setTitle("About Notepad");
b.setSize(520,420);
b.setVisible(true);
}
}
class MyFont extends JDialog implements ActionListener,ListSelectionListener
{
JLabel font,fontstyle,size,lbl;
JTextField j1,j2,j3;
JList f1,f2,f3;
JButton b1,b2;
JComboBox b;
String s1,s2,s3,s4,s5,we1;
int n1,n2,kk;
MyFont(String g,String s,String r,String w,int gg,String str6,String we)
{
Container c=getContentPane();
c.setLayout(null);
s1=s;
s2=r;
s3=w;
s4=g;
kk=gg;
we1=we;
s5=str6;
String str[]={"Arial","Arial Rounded MT","Arial Unicode MS","Bodni MT","Consolas","Copper","Courier","Latin","Sanserif"};
String str1[]={"Regular","Italic","Bold","Bold Italic"};
String str2[]={"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
font=new JLabel("Font:");
font.setBounds(10,10,40,10);
fontstyle=new JLabel("Font style:");
fontstyle.setBounds(177,10,80,13);
size=new JLabel("Size:");
size.setBounds(293,10,40,10);
c.add(font);
c.add(fontstyle);
c.add(size);
f1=new JList(str);
f2=new JList(str1);
f3=new JList(str2);
JScrollPane s1=new JScrollPane();
JScrollPane s2=new JScrollPane();
JScrollPane s3=new JScrollPane();
s1.getViewport().add(f1);
s2.getViewport().add(f2);
s3.getViewport().add(f3);
s1.setBounds(10,47,150,100);
s2.setBounds(177,47,100,100);
s3.setBounds(293,47,70,100);
c.add(s1);
c.add(s2);
c.add(s3);
j1=new JTextField(s);
j2=new JTextField(r);
j3=new JTextField(w);
j1.setBounds(10,25,150,25);
j2.setBounds(177,25,100,25);
j3.setBounds(293,25,70,25);
c.add(j1);
c.add(j2);
c.add(j3);
b1=new JButton("OK");
b2=new JButton("Cancel");
b1.setBounds(200,380,80,25);
b2.setBounds(290,380,80,25);
c.add(b1);
c.add(b2);
String str3[]={"Western","Greek","Turkish","Baltic","Central European","Cyrillic","Vietnamese"};
b=new JComboBox(str3);
lbl=new JLabel("Script:");
lbl.setBounds(160,250,50,18);
c.add(lbl);
b.setBounds(160,270,210,20);
c.add(b);
b1.addActionListener(this);
b2.addActionListener(this);
f1.addListSelectionListener(this);
f2.addListSelectionListener(this);
f3.addListSelectionListener(this);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}
public void valueChanged(ListSelectionEvent e)
{
if(f3.isSelectionEmpty())
{
j3.setText(s3);
}
else
{
s3=(String)f3.getSelectedValue(); 
j3.setText(s3);
}
if(f1.isSelectionEmpty())
{
j1.setText(s1);
}
else
{
s1=(String)f1.getSelectedValue();
j1.setText(s1);
}
if(f2.isSelectionEmpty())
{
j2.setText(s2);
}
else
{
s2=(String)f2.getSelectedValue();
j2.setText(s2);
}
}
public void actionPerformed(ActionEvent e) 
{
if(b2==e.getSource())
{
j3.setText(s3);
j1.setText(s1);
j2.setText(s2);
Notepad1 obj=new Notepad1(s1,s2,s3,s4,kk,s5,we1);
obj.setSize(1370,730);
obj.setTitle(we1+" - Notepad");
obj.setVisible(true);
this.dispose();
}
if(b1==e.getSource()) 
{
if(f3.isSelectionEmpty())
{
j3.setText(s3);
}
if(f1.isSelectionEmpty())
{
j1.setText(s1);
}
if(f2.isSelectionEmpty())
{
j2.setText(s2);
}
n2=Integer.parseInt(s3);
if(s2.equals("Regular"))
{
n1=(int)Font.PLAIN;
}
if(s2.equals("Italic"))
{
n1=(int)Font.ITALIC;
}
if(s2.equals("Bold"))
{
n1=(int)Font.BOLD;
}
if(s2.equals("Bold Italic"))
{
n1=(int)(Font.BOLD+Font.ITALIC);
}
Notepad1 obj=new Notepad1(s1,s2,s3,s4,kk,s5,we1);
obj.setSize(1370,730);
obj.setTitle(we1+" - Notepad");
obj.setVisible(true);
this.dispose();
}
}
}
class About extends JDialog implements ActionListener
{
JButton b;
JLabel lbl1,lbl2,lbl7,lbl8,lbl9,lbl10;
About()
{
Container c=getContentPane();
c.setLayout(null);
lbl1=new JLabel();
lbl1.setText("Name - Manoj Kumar");
lbl1.setBounds(250,60,300,15);
lbl2=new JLabel("College - NIT Hamirpur(B.Tech-ECE)");
lbl2.setBounds(250,80,300,15);
lbl7=new JLabel();
lbl7.setText("Contact - 8894403071");
lbl7.setBounds(250,105,300,15);
c.add(lbl1);
c.add(lbl2);
c.add(lbl7);
b=new JButton("OK");
b.setBounds(380,340,100,25);
c.add(b);
lbl9=new JLabel();
ImageIcon img=new ImageIcon("11.jpg");
lbl9.setIcon(img);
lbl9.setBounds(5,5,250,250);
c.add(lbl9);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(b==e.getSource())this.dispose();
}
}

