package py

import com.googlecode.javacv.cpp.opencv_highgui._
import com.googlecode.javacv.cpp.opencv_core._
//import com.googlecode.javacv.cpp.opencv_core.CORE
import com.googlecode.javacv.cpp.opencv_features2d._
import java.io.File
import com.googlecode.javacv.CanvasFrame
import com.googlecode.javacv.cpp.opencv_nonfree.SIFT
import com.googlecode.javacv.cpp.opencv_imgproc._
import com.googlecode.javacv.CanvasFrame
import com.googlecode.javacv.cpp.opencv_highgui._
import javax.swing.JFrame._
import OpenCVUtils._
//import com.googlecode.javacv.cpp.opencv_core.Core

object Hello{
  def main(args:Array[String]){
    // load image
    val image = loadAndShowOrExit(new File("boldt.jpg"))
    
    // Detect SIFT features.
    val keyPoints = new KeyPoint()
    val nFeatures = 0
    val nOctaveLayers = 3
    val contrastThreshold = 0.03
    val edgeThreshold = 10
    val sigma = 1.6
    val sift = new SIFT(nFeatures, nOctaveLayers, contrastThreshold, edgeThreshold, sigma)
    sift.detect(image, null, keyPoints)

    // Draw keyPoints
    val featureImage = cvCreateImage(cvGetSize(image), image.depth(), 3)
    drawKeypoints(image, keyPoints, featureImage, CvScalar.WHITE, DrawMatchesFlags.DRAW_RICH_KEYPOINTS)
    show(featureImage, "SIFT Features")

  }
}
