public class Global {
    public static double[] randomBiases(int length,double min,double max){
        double[] results = new double[length];
        for(int i =0;i<results.length;i++){
            results[i] = Math.random()* (double)(max-min) + min;
        }
        return results; 
    }
    public static double[] randomBiases(int length){
        return randomBiases(length,Double.MIN_VALUE,Double.MAX_VALUE);
    }
    public static double[][] randomWeights(int input,int node,double min,double max){
        double[][] results = new double[input][node];
        for(int i =0;i<results.length;i++){
            for(int j = 0;j<results[i].length;j++){
                results[i][j]=  Math.random()* (double)(max-min) + min;
            } 
        }
        return results; 
    }
    public static double[][] randomWeights(int input,int node){
        return randomWeights(input, node,Double.MIN_VALUE,Double.MAX_VALUE);
    }
}

