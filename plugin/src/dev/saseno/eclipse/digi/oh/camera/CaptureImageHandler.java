package dev.saseno.eclipse.digi.oh.camera;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class CaptureImageHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		boolean success = WebcamImageCapture.captureImage("captured-image.png");
		if (success) {
			// Inform user (use Eclipse dialogs, status bar, etc.)
			System.out.println("Image captured successfully!");
		} else {
			System.out.println("Image capture failed.");
		}
		return null;
	}
}