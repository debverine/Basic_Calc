import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;


public class C1 {

	protected Shell shlCalc;
	private Text text;
	private Text text_1;

	public static void main(String[] args) {
		try {
			C1 window = new C1();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCalc.open();
		shlCalc.layout();
		while (!shlCalc.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	boolean dot=false,op_present=false,next_op=false,answer;
	String V1,V2,R;
	int op_num;
	
	public void equalTo(){
		double d1,d2,d3=0;
		d1=Double.parseDouble(V1);
		d2=Double.parseDouble(V2);
		switch( op_num){
			case 1: d3=d1+d2;break;
			case 2: d3=d1-d2;break;
			case 3: d3=d1*d2;break;
			case 4: d3=d1/d2;break;
		}
		R=Double.toString(d3);
	}
	

	protected void createContents() {
		shlCalc = new Shell();
		shlCalc.setImage(SWTResourceManager.getImage("C:\\Users\\Lenovo\\Desktop\\icon.bmp"));
		shlCalc.setSize(274, 233);
		shlCalc.setText("CALC");
		shlCalc.setLayout(null);
		
		
		
		
		text = new Text(shlCalc, SWT.BORDER | SWT.RIGHT);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		text.setBounds(10, 30, 182, 25);
		
		text_1 = new Text(shlCalc, SWT.BORDER | SWT.RIGHT);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		text_1.setBackground(SWTResourceManager.getColor(224, 255, 255));
		text_1.setBounds(10, 12, 182, 18);
		
		Button buttonDot = new Button(shlCalc, SWT.NONE);
		
		buttonDot.setBounds(10, 162, 52, 25);
		buttonDot.setText(".");
		
		Button button_0 = new Button(shlCalc, SWT.NONE);
		button_0.setText("0");
		button_0.setBounds(73, 162, 52, 25);
		
		Button button_1 = new Button(shlCalc, SWT.NONE);
		
		button_1.setText("1");
		button_1.setBounds(10, 129, 52, 25);
		
		Button button_2 = new Button(shlCalc, SWT.NONE);
		button_2.setText("2");
		button_2.setBounds(73, 129, 52, 25);
		
		Button button_3 = new Button(shlCalc, SWT.NONE);
		button_3.setText("3");
		button_3.setBounds(140, 129, 52, 25);
		
		Button button_4 = new Button(shlCalc, SWT.NONE);
		button_4.setText("4");
		button_4.setBounds(10, 98, 52, 25);
		
		Button button_5 = new Button(shlCalc, SWT.NONE);
		button_5.setText("5");
		button_5.setBounds(73, 98, 52, 25);
		
		Button button_6 = new Button(shlCalc, SWT.NONE);
		button_6.setText("6");
		button_6.setBounds(140, 98, 52, 25);
		
		Button button_7 = new Button(shlCalc, SWT.NONE);
		button_7.setText("7");
		button_7.setBounds(10, 67, 52, 25);
		
		Button button_8 = new Button(shlCalc, SWT.NONE);
		button_8.setText("8");
		button_8.setBounds(73, 67, 52, 25);
		
		Button button_9 = new Button(shlCalc, SWT.NONE);
		button_9.setText("9");
		button_9.setBounds(140, 67, 52, 25);
		
		Button button_E = new Button(shlCalc, SWT.NONE);
		
		button_E.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		button_E.setText("=");
		button_E.setBounds(140, 162, 52, 25);
		
		Button button_A = new Button(shlCalc, SWT.NONE);
		
		button_A.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		button_A.setBounds(207, 148, 45, 39);
		button_A.setText("+");
		
		Button button_S = new Button(shlCalc, SWT.NONE);
		
		button_S.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		button_S.setText("-");
		button_S.setBounds(207, 103, 45, 39);
		
		Button button_M = new Button(shlCalc, SWT.NONE);
		button_M.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		button_M.setText("*");
		button_M.setBounds(207, 56, 45, 39);
		
		Button button_D = new Button(shlCalc, SWT.NONE);
		button_D.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		button_D.setText("/");
		button_D.setBounds(207, 10, 45, 39);
		
		buttonDot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String txt=text_1.getText();
				if(dot)
					return;
				if(txt.isEmpty()||(op_present&&!next_op))
				{
					next_op=true;
					txt+="0.";
				}
				else
					txt+=".";
				dot=true;
				text_1.setText(txt);
			}
		});
		
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String txt=text_1.getText();
				if(!txt.isEmpty() ){
					if( (op_present&&!next_op))
						return;
					txt=txt+'0';
					text_1.setText(txt);
				}
				
			}
		});
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();				
				txt=txt+'1';
				text_1.setText(txt);
			}
		});
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'2';
				text_1.setText(txt);
			}
		});
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'3';
				text_1.setText(txt);
			}
		});
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'4';
				text_1.setText(txt);
			}
		});
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'5';
				text_1.setText(txt);
			}
		});
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'6';
				text_1.setText(txt);
			}
		});
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'7';
				text_1.setText(txt);
			}
		});
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'8';
				text_1.setText(txt);
			}
		});
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(op_present&& !next_op)
					next_op=true;
				String txt=text_1.getText();
				txt=txt+'9';
				text_1.setText(txt);
			}
		});
		button_A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text_1.getText().isEmpty() && answer){
					V1=text.getText();
					text.setText("");
					text_1.setText(V1+"+");
					op_num=1;
					op_present=true;
				}
				else if(!op_present){
					op_present=true;
					next_op=false;
					dot=false;
					String txt=text_1.getText();
					V1=txt;
					op_num=1;
					txt+="+";
					text_1.setText(txt);
				}else if(op_present && !next_op){
					if(op_num!=1){
						op_num=1;
						String txt=text_1.getText();
						int l=txt.length();
						txt=txt.substring(0, l-1)+"+";
						text_1.setText(txt);
					}
						
				}else{// else condition for calculation and then add
					V2=text_1.getText();
					V2=V2.substring(V1.length()+1,V2.length());
					equalTo();
					text_1.setText(R+"+");
					op_num=1;
					op_present=true;
					next_op=false;
					V1=R;
				}
					
			}
		});
		
		button_S.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text_1.getText().isEmpty() && answer){
					V1=text.getText();
					text.setText("");
					text_1.setText(V1+"-");
					op_num=2;
					op_present=true;
				}
				else if(!op_present){
					op_present=true;
					next_op=false;
					dot=false;
					String txt=text_1.getText();
					V1=txt;
					op_num=2;
					txt+="-";
					text_1.setText(txt);
				}else if(op_present && !next_op){
					if(op_num!=2){
						op_num=2;
						String txt=text_1.getText();
						int l=txt.length();
						txt=txt.substring(0, l-1)+"-";
						text_1.setText(txt);
					}
						
				}else{// else condition for calculation and then add
					V2=text_1.getText();
					V2=V2.substring(V1.length()+1,V2.length());
					equalTo();
					text_1.setText(R+"-");
					op_num=2;
					op_present=true;
					next_op=false;
					V1=R;
				}
					
			}
		});
		

		button_M.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text_1.getText().isEmpty() && answer){
					V1=text.getText();
					text.setText("");
					text_1.setText(V1+"*");
					op_num=3;
					op_present=true;
				}
				else if(!op_present){
					op_present=true;
					next_op=false;
					dot=false;
					String txt=text_1.getText();
					V1=txt;
					op_num=3;
					txt+="*";
					text_1.setText(txt);
				}else if(op_present && !next_op){
					if(op_num!=3){
						op_num=3;
						String txt=text_1.getText();
						int l=txt.length();
						txt=txt.substring(0, l-1)+"*";
						text_1.setText(txt);
					}
						
				}else{// else condition for calculation and then add
					V2=text_1.getText();
					V2=V2.substring(V1.length()+1,V2.length());
					equalTo();
					text_1.setText(R+"*");
					op_num=3;
					op_present=true;
					next_op=false;
					V1=R;
				}
					
			}
		});
		

		button_D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text_1.getText().isEmpty() && answer){
					V1=text.getText();
					text.setText("");
					text_1.setText(V1+"/");
					op_num=4;
					op_present=true;
				}
				else if(!op_present){
					op_present=true;
					next_op=false;
					dot=false;
					String txt=text_1.getText();
					V1=txt;
					op_num=4;
					txt+="/";
					text_1.setText(txt);
				}else if(op_present && !next_op){
					if(op_num!=4){
						op_num=4;
						String txt=text_1.getText();
						int l=txt.length();
						txt=txt.substring(0, l-1)+"/";
						text_1.setText(txt);
					}
						
				}else{// else condition for calculation and then add
					V2=text_1.getText();
					V2=V2.substring(V1.length()+1,V2.length());
					equalTo();
					text_1.setText(R+"/");
					op_num=4;
					op_present=true;
					next_op=false;
					V1=R;
				}
					
			}
		});
		
		
		button_E.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(!op_present && !next_op){
					String txt=text_1.getText();
					if(txt.isEmpty())
						txt="";
					text.setText(txt);
					text_1.setText("");
					return;
				}else if(op_present && !next_op){
					text.setText(V1);
					text_1.setText("");
					op_num=0;
					op_present=false;
					answer=true;
				}else{
					V2=text_1.getText();
					V2=V2.substring(V1.length()+1,V2.length());
					text_1.setText("");
					equalTo();
					text.setText(R);
					answer=true;
					next_op=false;
					dot=false;
					op_present=false;
					op_num=0;
				}
			}
		});
	}
}
