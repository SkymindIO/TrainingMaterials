package mnist_client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import mnist_client.auth.Authorization;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.datavec.image.data.ImageWritable;
import org.datavec.image.transform.ImageTransformProcess;
import org.json.JSONObject;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.io.ClassPathResource;
import org.nd4j.serde.base64.Nd4jBase64;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Build uber jar and run with
java -jar SKIL-bin.jar --endpoint http://localhost:9008/endpoints/mnist/model/model2/default/ --input /Desktop/2.jpg
 */

public class MnistInference {

    @Parameter(names="--endpoint", description="Endpoint for classification", required=true)
    private String skilInferenceEndpoint = ""; // EXAMPLE: "http://localhost:9008/endpoints/mnist/model/mnistmodel/default/";

    @Parameter(names="--input", description="image input file", required=false)
    private String inputImageFile = "";//"blank"

    public void run() throws Exception, IOException {

        ImageTransformProcess imgTransformProcess = new ImageTransformProcess.Builder().seed(12345)
                .build();

        File imageFile = null;
        INDArray finalRecord = null;

        if ("blank".equals(inputImageFile)) {

            finalRecord = Nd4j.zeros( 1, 28 * 28 );

            System.out.println( "Generating blank test image ..." );

        }else if(inputImageFile.isEmpty())
        {
            imageFile = new ClassPathResource("mnist/71.png").getFile();

            ImageWritable img = imgTransformProcess.transformFileUriToInput( imageFile.toURI() );
            finalRecord = imgTransformProcess.executeArray( img ).reshape(1, 28 * 28);
        }
        else {

            imageFile = new File( inputImageFile );

            if (!imageFile.exists() || !imageFile.isFile()) {
                System.err.format("unable to access file %s\n", inputImageFile);
                System.exit(2);
            } else {

                System.out.println( "Inference for: " + inputImageFile );

            }

            ImageWritable img = imgTransformProcess.transformFileUriToInput( imageFile.toURI() );
            finalRecord = imgTransformProcess.executeArray( img ).reshape(1, 28 * 28);

        }

        String imgBase64 = Nd4jBase64.base64String(finalRecord);

        //System.out.println( imgBase64 );

        //System.out.println( "Finished image conversion" );

        skilClientGetImageInference( imgBase64 );

    }

    private void skilClientGetImageInference( String imgBase64 ) {

        Authorization auth = new Authorization();
        String auth_token = auth.getAuthToken( "admin", "admin" );

        /*
        System.out.println("********************************login********************************");
        try {

            String temp =
                    Unirest.post( "http://localhost:9008/login")
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .body(new JSONObject() //Using this because the field functions couldn't get translated to an acceptable json
                                    .put( "userId", "admin" )
                                    .put("password", "admin")
                                    .toString())
                            .asJson().getBody().getObject().toString();


            System.out.println( "Login returns: " + temp );

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        System.out.println("********************************get deployment id********************************");
        try {

            HttpResponse<JsonNode> temp =
                    Unirest.get("http://localhost:9008/deployments")
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .header( "Authorization", "Bearer " + auth_token)
                            .asJson();


            System.out.println( "Get deployment id returns: " + temp.getBody().toString());

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        System.out.println("********************************multiclassify********************************");

        */


        try {


            JSONObject obj  =
                    Unirest.post( skilInferenceEndpoint + "multiclassify" )
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .header( "Authorization", "Bearer " + auth_token)
                            .body(new JSONObject() //Using this because the field functions couldn't get translated to an acceptable json
                                    .put( "id", "some_id" )
                                    .put("prediction", new JSONObject().put("array", imgBase64))
                                    .toString())
                            .asJson()
                            .getBody().getObject();


            System.out.println( "Classification return: "  + obj.toString() );

            Object label = obj.get("maxOutcomes");
            System.out.println("Predicted number: " + label.toString());


        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        MnistInference m = new MnistInference();

        JCommander.newBuilder()
                .addObject(m)
                .build()
                .parse(args);

        m.run();
    }


}