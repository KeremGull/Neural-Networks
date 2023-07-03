import java.util.Random;
public class Global {
    static Random rand = new Random(System.currentTimeMillis());
    public static double[] randomBiases(int length,double min,double max){
        double[] results = new double[length];
        for(int i =0;i<results.length;i++){
            results[i] = rand.nextDouble() * (double)(max-min) + min;
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
                results[i][j]=  rand.nextDouble()* (double)(max-min) + min;
            } 
        }
        return results; 
    }
    public static double[][] randomWeights(int input,int node){
        return randomWeights(input, node,Double.MIN_VALUE,Double.MAX_VALUE);
    }


    public static double sigmoid(double a){
        return 1/(1+Math.exp(-a));
    }
    public static double[] substract(double[] a,double[] b){
        double[] result = new double[a.length];
        for(int i =0;i<a.length;i++){
            result[i] = a[i]-b[i];
        }
        return result;
    }
    public static void createData(double[][] data,double[][] expected){
        for(int i =0;i < data.length;i++){
            double sum = 0;
            for(int j = 0;j<data[i].length;j++){
                data[i][j] = rand.nextDouble() * 4.0;
                sum += data[i][j];
            }
            double[] temp = {0,0};
            if((sum < 3 && sum >1.7 )|| (sum >5.5 && sum< 7.7)){
                temp[0] = 1;
            }else{temp[1] = 1;}
            expected[i] = temp;
        }
    }
}

