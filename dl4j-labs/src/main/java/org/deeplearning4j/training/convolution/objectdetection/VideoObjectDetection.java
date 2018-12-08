package org.deeplearning4j.training.convolution.objectdetection;


import org.datavec.image.loader.NativeImageLoader;
import org.datavec.image.transform.ColorConversionTransform;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.layers.objdetect.DetectedObject;
import org.deeplearning4j.nn.layers.objdetect.YoloUtils;
import org.deeplearning4j.zoo.ZooModel;
import org.deeplearning4j.zoo.model.TinyYOLO;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.*;
import org.deeplearning4j.zoo.util.darknet.VOCLabels;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;
import org.nd4j.linalg.factory.Nd4j;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.bytedeco.javacpp.opencv_core.FONT_HERSHEY_DUPLEX;
import static org.bytedeco.javacpp.opencv_imgproc.*;

/**
 * Yolo Detection with video
 *
 * Get Sample video from below
 * https://drive.google.com/open?id=1Xx52YgF4R6BUBjuVo0vWRfTTG9oOoZCs
 * https://drive.google.com/open?id=1qjEBc37E0OBLUdNOGYeHxHbRpPVoU2G0
 *
 */

public class VideoObjectDetection
{
    private static Thread thread;


    private static final int gridWidth = 13;
    private static final int gridHeight = 13;

    private static double detectionThreshold = 0.5;
    private static final int tinyyolowidth = 416;
    private static final int tinyyoloheight = 416;


    public static void main(String[] args) throws Exception {

        String videoPath = "D:\\videoSample.mp4";
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoPath);
        grabber.setFormat("mp4");
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
        grabber.start();

        String winName = "Object Detection";
        CanvasFrame canvas = new CanvasFrame(winName);

        int w = grabber.getImageWidth();
        int h = grabber.getImageHeight();


        canvas.setCanvasSize(w, h);

        ZooModel model = TinyYOLO.builder().numClasses(0).build();
        ComputationGraph initializedModel = (ComputationGraph) model.initPretrained();


        NativeImageLoader loader = new NativeImageLoader(tinyyolowidth, tinyyoloheight, 3, new ColorConversionTransform(COLOR_BGR2RGB));
        ImagePreProcessingScaler scaler = new ImagePreProcessingScaler(0, 1);
        VOCLabels labels = new VOCLabels();

        System.out.println("Start running video");

        while (true)
        {
            Frame frame = grabber.grabImage();
            //if a thread is null, create new thread

            opencv_core.Mat rawImage = converter.convert(frame);
            opencv_core.Mat resizeImage = new opencv_core.Mat();//rawImage);
            resize(rawImage, resizeImage, new opencv_core.Size(tinyyolowidth, tinyyoloheight));
            INDArray inputImage = loader.asMatrix(resizeImage);
            scaler.transform(inputImage);
            INDArray outputs = initializedModel.outputSingle(inputImage);
            List<DetectedObject> objs = YoloUtils.getPredictedObjects(Nd4j.create(((TinyYOLO) model).getPriorBoxes()), outputs, detectionThreshold, 0.4);

            for (DetectedObject obj : objs) {
                double[] xy1 = obj.getTopLeftXY();
                double[] xy2 = obj.getBottomRightXY();
                String label = labels.getLabel(obj.getPredictedClass());
                int x1 = (int) Math.round(w * xy1[0] / gridWidth);
                int y1 = (int) Math.round(h * xy1[1] / gridHeight);
                int x2 = (int) Math.round(w * xy2[0] / gridWidth);
                int y2 = (int) Math.round(h * xy2[1] / gridHeight);
                rectangle(rawImage, new opencv_core.Point(x1, y1), new opencv_core.Point(x2, y2), opencv_core.Scalar.RED, 2, 0, 0);
                putText(rawImage, label, new opencv_core.Point(x1 + 2, y2 - 2), FONT_HERSHEY_DUPLEX, 1, opencv_core.Scalar.GREEN);

            }
            canvas.showImage(converter.convert(rawImage));

            KeyEvent t = canvas.waitKey(33);

            if ((t != null) && (t.getKeyCode() == KeyEvent.VK_Q)) {
                break;
            }
        }

        canvas.dispose();

    }

}

