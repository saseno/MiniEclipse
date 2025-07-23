package dev.saseno.eclipse.digi.oh.camera;

import javax.swing.JFrame;

import com.github.eduramiba.webcamcapture.drivers.NativeDriver;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

public class WebcamSwingDemo {

	public static void main(String[] args) {

//		System.err.println("----");
		
		Webcam.setDriver(new NativeDriver());
		Webcam webcam = Webcam.getDefault();

		webcam.open();
		WebcamPanel panel = new WebcamPanel(webcam);
		JFrame window = new JFrame("Preview");
		window.add(panel);
		window.pack();
		window.setVisible(true);

//		Webcam webcam = Webcam.getDefault();
//		if (webcam != null) {
//			System.out.println("Webcam: " + webcam.getName());
//		} else {
//			System.out.println("No webcam detected");
//		}
	}
	
//	public static void main(String[] args) {
//		System.out.println("-------------------------");
//		System.out.println("Starting now...");
//		System.out.println("-------------------------");
//
//	}
}