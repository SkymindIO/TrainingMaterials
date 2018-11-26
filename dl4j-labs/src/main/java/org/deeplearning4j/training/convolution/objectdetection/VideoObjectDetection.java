package org.deeplearning4j.training.convolution.objectdetection;


import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.layers.objdetect.DetectedObject;
import org.deeplearning4j.zoo.model.TinyYOLO;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.*;
import org.nd4j.linalg.api.ndarray.INDArray;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.bytedeco.javacpp.opencv_core.FONT_HERSHEY_DUPLEX;
import static org.bytedeco.javacpp.opencv_imgproc.putText;
import static org.bytedeco.javacpp.opencv_imgproc.rectangle;

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

    private static double detectionThreshold = 0.5;


    public static void main(String[] args) throws Exception {

        String videoPath = "//Users//wei//Desktop//Skymind//Videos//videoSample.mp4";
        FrameGrabber grabber = FrameGrabber.createDefault(videoPath);
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();

        grabber.start();

        String winName = "Object Detection";
        CanvasFrame canvas = new CanvasFrame(winName);
        canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight());

        ComputationGraph model = (ComputationGraph)TinyYOLO.builder().build().initPretrained();

        org.deeplearning4j.nn.layers.objdetect.Yolo2OutputLayer yout =
                (org.deeplearning4j.nn.layers.objdetect.Yolo2OutputLayer)model.getOutputLayer(0);

        NativeImageLoader loader = new NativeImageLoader();

        while (true)
        {
            try {
                Frame frame = grabber.grab();

                opencv_core.Mat matFrame = converter.convert(frame);

                //if a thread is null, create new thread
                if (thread == null)
                {
                    thread = new Thread(() ->
                    {
                        while (frame != null)
                        {
                            INDArray inputArr = null;

                            try
                            {
                                inputArr = loader.asRowVector(matFrame);
                            }
                            catch(IOException e)
                            {

                            }



                        }
                    });
                    thread.start();
                }

                //continous get the max suppression of all the threads and display it.
                //TinyYoloPrediction.getINSTANCE().markWithBoundingBox(matFrame, frame.imageWidth, frame.imageHeight, false);



                /*
                INDArray results = model.outputSingle(inputArr);
                List<DetectedObject> objs = yout.getPredictedObjects(results, detectionThreshold);

                for (DetectedObject obj : objs) {
                    double[] xy1 = obj.getTopLeftXY();
                    double[] xy2 = obj.getBottomRightXY();
                    String label = labels.get(obj.getPredictedClass());
                    int x1 = (int) Math.round(w * xy1[0] / gridWidth);
                    int y1 = (int) Math.round(h * xy1[1] / gridHeight);
                    int x2 = (int) Math.round(w * xy2[0] / gridWidth);
                    int y2 = (int) Math.round(h * xy2[1] / gridHeight);
                    rectangle(image, new opencv_core.Point(x1, y1), new opencv_core.Point(x2, y2), opencv_core.Scalar.RED);
                    putText(image, label, new opencv_core.Point(x1 + 2, y2 - 2), FONT_HERSHEY_DUPLEX, 1, opencv_core.Scalar.GREEN);
                }
                canvas.setTitle(new File(metadata.getURI()).getName() + " - HouseNumberDetection");
                canvas.setCanvasSize(w, h);
                canvas.showImage(converter.convert(image));

                canvas.showImage(converter.convert(matFrame));

                KeyEvent t = canvas.waitKey(25);

                if ((t != null) && (t.getKeyCode() == KeyEvent.VK_Q)) {
                    break;
                }
                */
            }
            catch(FrameGrabber.Exception e)
            {
                break;
            }
        }

        canvas.dispose();

    }

}

