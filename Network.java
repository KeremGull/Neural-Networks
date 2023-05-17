public class Network {
    private Layer[] layers;
    public Network(int layerCnt, int[] numberOfNodes){  
        layers = new Layer[layerCnt-1];
        for(int i = 0;i<layers.length;i++){
            layers[i] = new Layer(numberOfNodes[i],numberOfNodes[i+1],Global.randomBiases(numberOfNodes[i+1],-25,25),Global.randomWeights(numberOfNodes[i],numberOfNodes[i+1],-25,25));
        }
    }
    public double[] calculateOutput(double[] input){
        for(int i =0;i<layers.length-1;i++){
            input = layers[i].calculateOutput(input);
        }
        return layers[layers.length-1].calculateOutput(input);
    }
}
