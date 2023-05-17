public class Layer{
    private int numberOfInputs;
    private int numberOfOutputs;
    private double[] biases;
    private double[][] weights;
    public Layer(int in,int out){
        this(in,out,null,null);
    }
    public Layer(int in,int out,double[] bias,double[][] weight){
        numberOfInputs = in;
        numberOfOutputs = out;
        biases = bias;
        weights= weight;
    }


    public double[] calculateOutput(double[] input){
        if(input.length != numberOfInputs){
            return null;
        }
        double[] results = new double[numberOfOutputs];
        for(int out = 0;out<numberOfOutputs;out++){
            double result = biases[out];
            for(int in = 0;in<numberOfInputs;in++){
                result += input[in] * weights[in][out];
            }
            results[out] = result;
        }
        return results;
    }

    public int getNumberOfOutputs(){return numberOfOutputs;}
}