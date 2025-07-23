package dev.saseno.eclipse.digi.oh.camera;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.openimaj.video.capture.VideoCapture;

import com.github.eduramiba.webcamcapture.drivers.NativeDriver;
import com.github.sarxos.webcam.Webcam;

public class WebcamView extends ViewPart {
	public static final String ID = "dev.saseno.eclipse.digi.oh.camera.WebcamView.id";
	private VideoCapture vc;
	private JLabel previewLabel;
//	private MBFImage lastFrame;
	private volatile boolean running = true;

	public void createPartControlw(Composite parent) {

		// Embed AWT/Swing panel in SWT
//		Composite composite = new Composite(parent, SWT.EMBEDDED);
//
//		Webcam webcam = Webcam.getDefault();
//		webcam.open();
//		WebcamPanel panel = new WebcamPanel(webcam);

	}

	@Override
	public void createPartControl(Composite parent) {
		// Embed AWT/Swing panel in SWT
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		Frame frame = SWT_AWT.new_Frame(composite);

		JPanel mainPanel = new JPanel(new BorderLayout());
		previewLabel = new JLabel();
		previewLabel.setPreferredSize(new Dimension(640, 480));
		mainPanel.add(previewLabel, BorderLayout.CENTER);

		JButton captureButton = new JButton("Capture Image");
		mainPanel.add(captureButton, BorderLayout.SOUTH);

//		captureButton.addActionListener(e -> {
//			if (lastFrame != null) {
//				try {
//					ImageUtilities.write(lastFrame, new File("captured-image.png"));
//					JOptionPane.showMessageDialog(mainPanel, "Image captured and saved as captured-image.png");
//				} catch (IOException ex) {
//					JOptionPane.showMessageDialog(mainPanel, "Error saving image: " + ex.getMessage());
//				}
//			}
//		});

		frame.add(mainPanel);

		// Start webcam preview thread
		try {
			

			Webcam.setDriver(new NativeDriver());
			Webcam webcam = Webcam.getDefault();

			webcam.open();
			
			vc = new VideoCapture(640, 480);
//			Thread previewThread = new Thread(() -> {
//				while (running) {
//					lastFrame = vc.getNextFrame();
//					BufferedImage img = ImageUtilities.createBufferedImageForDisplay(lastFrame);
//					SwingUtilities.invokeLater(() -> previewLabel.setIcon(new ImageIcon(img)));
//					try {
//						Thread.sleep(30);
//					} catch (InterruptedException ignored) {
//					}
//				}
//				vc.stopCapture();
//			});
//			previewThread.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(mainPanel, "Could not start webcam: " + e.getMessage());
		}
	}

	@Override
	public void setFocus() {

	}

	@Override
	public void dispose() {
		running = false;
		super.dispose();
	}
}