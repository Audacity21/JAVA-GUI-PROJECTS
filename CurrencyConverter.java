package Applications;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SwingConstants;
import java.awt.Color;

public class CurrencyConverter extends JFrame 
{
	DateFormat dateformat =new SimpleDateFormat("dd-MM-YY");
	Date dxt=new Date();
	Calendar cal=Calendar.getInstance();
	private JPanel contentPane;
	private JTextField val;
	private JTextField result;

	JLabel l2,l3,l4,l5;
	JComboBox<String> cb1,cb2;
	JButton b1;
	private JButton r1;
	private JButton r2;
	private JTextField txt1;
	private JTextField txt2;
	private JButton reset;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField date;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter frame = new CurrencyConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CurrencyConverter() 
	{
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Currency Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l2 = new JLabel("Enter value: ");
		l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		l2.setBounds(10, 10, 100, 28);
		contentPane.add(l2);
		
		l3 = new JLabel("Convert from:");
		l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		l3.setBounds(10, 48, 100, 28);
		contentPane.add(l3);
		
		l4 = new JLabel("Convert to: ");
		l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		l4.setBounds(10, 110, 100, 28);
		contentPane.add(l4);
		
		l5 = new JLabel("Result: ");
		l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		l5.setBounds(10, 172, 100, 28);
		contentPane.add(l5);
		
		val = new JTextField();
		val.setFont(new Font("Tahoma", Font.PLAIN, 15));
		val.setBounds(110, 15, 96, 19);
		contentPane.add(val);
		val.setColumns(10);
		
		result = new JTextField();
		result.setEditable(false);
		result.setFont(new Font("Tahoma", Font.PLAIN, 15));
		result.setColumns(10);
		result.setBounds(110, 177, 96, 19);
		contentPane.add(result);
		
		cb1 = new JComboBox<String>();
		cb1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb1.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "GBP", "JPY", "AUD", "INR"}));
		cb1.setBounds(110, 53, 93, 21);
		contentPane.add(cb1);
		
		cb2 = new JComboBox<String>();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "GBP", "JPY", "AUD", "INR"}));
		cb2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb2.setBounds(110, 115, 93, 21);
		contentPane.add(cb2);
		
		b1 = new JButton("CONVERT");
		b1.setBackground(new Color(255, 255, 224));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == b1)
				{
					int f = 0,g = 0;
					double a=0.0;
					try 
					{
						a=Double.parseDouble(val.getText());
					}
					catch(Exception ef)
					{
						JOptionPane.showMessageDialog(null,"Invalid Input!");
					}
					String x1=(String) cb1.getSelectedItem();
					String x2=(String) cb2.getSelectedItem();
					String m[]={"USD", "EUR", "GBP", "JPY", "AUD", "INR"};
					Double n[]= {73.37, 88.40, 102.17, 0.69, 57.23, 1.0};
					for(int h=0;h<6;h++)
					{
						if(x1.equals(m[h]))
							f=h;
						if(x2.equals(m[h]))
							g=h;
					}
					double amt=(a*n[f])/n[g];
					DecimalFormat df=new DecimalFormat("#.00");
					String x3=df.format(amt);
					result.setText(x3);
				}
			}
		});
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b1.setBounds(10, 225, 93, 28);
		contentPane.add(b1);
		
		r1 = new JButton("Rate");
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == r1)
				{
					int f = 0,g = 0;
					String x1=(String) cb1.getSelectedItem();
					String m[]={"USD", "EUR", "GBP", "JPY", "AUD", "INR"};
					Double n[]= {73.37, 88.40, 102.17, 0.69, 57.23, 1.0};
					for(int h=0;h<6;h++)
					{
						if(x1.equals(m[h]))
							txt1.setText(n[h]+" INR");
					}
				}
			}
		});
		r1.setBounds(223, 54, 72, 21);
		contentPane.add(r1);
		
		r2 = new JButton("Rate");
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == r2)
				{
					int f = 0,g = 0;
					String x1=(String) cb2.getSelectedItem();
					String m[]={"USD", "EUR", "GBP", "JPY", "AUD", "INR"};
					Double n[]= {73.37, 88.40, 102.17, 0.69, 57.23, 1.0};
					for(int h=0;h<6;h++)
					{
						if(x1.equals(m[h]))
							txt2.setText(n[h]+" INR");
					}
				}
			}
		});
		r2.setBounds(223, 116, 72, 21);
		contentPane.add(r2);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt1.setEditable(false);
		txt1.setColumns(10);
		txt1.setBounds(110, 86, 96, 19);
		contentPane.add(txt1);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt2.setEditable(false);
		txt2.setColumns(10);
		txt2.setBounds(110, 148, 96, 19);
		contentPane.add(txt2);
		
		reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val.setText(null);
				result.setText(null);
				txt1.setText(null);
				txt2.setText(null);
			}
		});
		reset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reset.setBounds(117, 224, 93, 28);
		contentPane.add(reset);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 10, 276, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		Object[] column= {"Value", "From", "To", "Result"};
		final Object[] row=new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton save = new JButton("SAVE");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(val.getText().equals("") || result.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Convert First!");
				else
				{
					row[0]=val.getText();
					row[1]=(String) cb1.getSelectedItem();
					row[2]=(String) cb2.getSelectedItem();
					row[3]=result.getText();
					model.addRow(row);
					
					val.setText(null);
					result.setText(null);
					txt1.setText(null);
					txt2.setText(null);
					JOptionPane.showMessageDialog(null,"Saved Successfully!");
				}
			}
		});
		
		save.setFont(new Font("Tahoma", Font.PLAIN, 12));
		save.setBounds(218, 186, 77, 27);
		contentPane.add(save);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=table.getSelectedRow();
				if(i>=0) 
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null,"Deleted Successfully!");
				}
				else
					JOptionPane.showMessageDialog(null,"Select an entry first!");
			}
		});
		delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		delete.setBounds(218, 223, 77, 29);
		contentPane.add(delete);
		
		date = new JTextField();
		date.setBackground(new Color(102, 205, 170));
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setText(" "+ dateformat.format(dxt));
		date.setEditable(false);
		date.setBounds(223, 17, 72, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Designed by Ankit");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		lblNewLabel.setBounds(521, 255, 85, 17);
		contentPane.add(lblNewLabel);
	}
}
