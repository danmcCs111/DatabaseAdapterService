package DriverAdapter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatabaseDriverConsole extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private static final String
		TITLE = "Database Driver",
		CLOSE_BTN_TEXT = "Close",
		IMG_ICON_LOCATION = System.getProperty("user.dir")+"/images/database-sm.png";
	private static final Dimension
		MIN_DIMENSION = new Dimension(350, 125);
	private JLabel
		statusLabel = new JLabel("Disconnected."),
		errorLabel = new JLabel();
	private JButton
		closeButton;

	public DatabaseDriverConsole()
	{
		buildWidgets();
	}
	
	private void buildWidgets()
	{
		Image img;
		try {
			img = ImageIO.read(new File(IMG_ICON_LOCATION));
			this.setIconImage(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		scrollPane.setViewportView(consoleOutput);
		JPanel 
			controlPanel = new JPanel(),
			connectPanel = new JPanel();
		
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		controlPanel.setLayout(fl);
		FlowLayout f2 = new FlowLayout(FlowLayout.RIGHT);
		connectPanel.setLayout(f2);
		
		closeButton = new JButton(CLOSE_BTN_TEXT);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		controlPanel.add(statusLabel);
		
		connectPanel.add(closeButton);
		
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setMinimumSize(MIN_DIMENSION);
		
//		this.add(scrollPane, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(errorLabel, BorderLayout.CENTER);
		this.add(connectPanel, BorderLayout.SOUTH);
		centerOnScreen(this);
		this.setVisible(true);
	}
	
	public void setStatus(String status)
	{
		statusLabel.setText(status);
	}
	
	public void setError(String error)
	{
		errorLabel.setText(error);
	}
	
	public static void centerOnScreen(Component comp)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point loc = new Point(0, 0);
		
		double 
			rw = screenSize.getWidth(),
			rh = screenSize.getHeight(),
			w = comp.getWidth(),
			h = comp.getHeight();
		int
			x = loc.x + (int)((rw/2.0) - (w / 2.0)),
			y = loc.y + (int)((rh/2.0) - (h/2.0));
		y=(y<0)?0:y;
		
		comp.setLocation(x, y);
	}
}
