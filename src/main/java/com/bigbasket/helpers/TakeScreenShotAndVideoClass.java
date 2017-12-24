package com.bigbasket.helpers;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;
import java.awt.Robot;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
public class TakeScreenShotAndVideoClass {
	
	public ScreenRecorder screenRecorder;
	
	public void getScreenShots(AppiumDriver<WebElement>driver){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		
		try{
			File screenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShots, new File(System.getProperty("user.dir")+"//src//main//java//com//bigbasket//screenshots//"+dateFormat.format(calendar)+".png"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void startRecording() throws IOException, AWTException{
		
		GraphicsConfiguration graphicsconfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		this.screenRecorder= new ScreenRecorder(graphicsconfig, new Format(MediaTypeKey,MediaType.FILE,MimeTypeKey, MIME_AVI), 
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey, 
						ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						DepthKey, 24, FrameRateKey, Rational.valueOf(15),
						QualityKey, 1.0f,
						KeyFrameIntervalKey, 15 * 60),
						new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "Black",
						FrameRateKey, Rational.valueOf(30)),
						null);
		this.screenRecorder.start();
		
	}
	public void stopRecording() throws IOException{
		this.screenRecorder.stop();
	}

}
