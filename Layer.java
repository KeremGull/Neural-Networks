import java.util.Arrays;
import java.util.Random;
public class Layer{
    private int numberOfInputs;
    private int numberOfOutputs;
    private double[] biases;
    private double[][] weights;
    private String type;
    private double[] inputs;
    private double[] deriatives;
    public Layer(int in,int out,String func,double[] bias,double[][] weight){
        numberOfInputs = in;
        numberOfOutputs = out;
        biases = bias;
        weights= weight;
        type = func;
        deriatives = new double[numberOfOutputs];
        Arrays.fill(deriatives,1);
    }


    public double[] calculateOutput(double[] input){
        inputs = input;
        if(input.length != numberOfInputs){
            return null;
        }
        double[] results = new double[numberOfOutputs];
        for(int out = 0;out<numberOfOutputs;out++){
            double result = biases[out];
            for(int in = 0;in<numberOfInputs;in++){
                result += input[in] * weights[in][out];
            }
            if(type.equalsIgnoreCase("sigmoid") || type.equalsIgnoreCase("S")){
                result = Global.sigmoid(result);
                deriatives[out] = result*(1-result);
            }
            results[out] = result;
        }
        return results;
    }

    public int getNumberOfOutputs(){return numberOfOutputs;}
    public double[][] getWeights(){return weights;}
    public double[] getBiases(){return biases;}
    public double[] getInputs(){return inputs;}
    public double[] getDeriatives(){return deriatives;}
}