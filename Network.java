import java.util.Arrays;
public class Network {
    private Layer[] layers;
    private double[] outputs;
    public Network(int layerCnt, int[] numberOfNodes,String[] types){  
        layers = new Layer[layerCnt-1];
        for(int i = 0;i<layers.length;i++){
            layers[i] = new Layer(numberOfNodes[i],numberOfNodes[i+1],types[i],Global.randomBiases(numberOfNodes[i+1],-25,25),Global.randomWeights(numberOfNodes[i],numberOfNodes[i+1],-25,25));
        }
    }
    public void calculateOutput(double[] input){
        for(int i =0;i<layers.length-1;i++){
            input = layers[i].calculateOutput(input);
        }
        outputs = layers[layers.length-1].calculateOutput(input);
    }

    public double nodeCost(double expected,double real){
        return (expected-real) * (expected-real);
    }
    public double Cost(double[] expected){
        double cost = 0;
        for(int i =0;i<outputs.length;i++){
            cost += nodeCost(outputs[i],expected[i]);
        }
        return cost;
    }

    public void modify(double[] expected,double lRate){
        double[] errors = Global.substract(expected, outputs);
        for(int i = layers.length-1;i>0;i--){
            Layer temp = layers[i];
            double[][] weights = temp.getWeights();
            double[] biases = temp.getBiases();
            for(int j =0;j<weights.length;j++){
                for(int k = 0;k<weights[j].length;k++){
                    double gradient = errors[k]*lRate * temp.getDeriatives()[k];
                    weights[j][k] -= gradient * temp.getInputs()[j];
                    if(j ==0){biases[k] -= gradient;}
                }
                
            }
            double[] tempArr = new double[temp.getInputs().length];
            Arrays.fill(tempArr,0);
            //Yeni Errorlar hesaplanacak.
            for(int j =0;j<weights.length;j++){
                for(int k = 0;k<weights[j].length;k++){
                    tempArr[j] += weights[j][k] * errors[k];
                }
            }
            errors = tempArr;
        }
    }

    public double[] getOutputs(){return outputs;}
    // dW = r * E * d(Output)/d(Input) . I^T
}
