public class Test {
    public static void main(String[] args) {
        int[] a = {2,64,4,4,2};
        String[] l = {"s","l","l","s"};
        Network network = new Network(5, a,l);
        int dataCnt = 100000;
        double ratio =0.1;
        double steps = 10000;
        double[][] inputs = new double[dataCnt][2];
        double[][] expecteds = new double[dataCnt][2];
        Global.createData(inputs, expecteds);
        int generalCnt = 0;
        for(int i = 0;i<dataCnt/steps;i++){
            double corrects = 0;
            int cnt = 0;
            while(cnt<steps*ratio){
                network.calculateOutput(inputs[generalCnt]);
                if(compare(network.getOutputs(), expecteds[generalCnt])) corrects++;
                generalCnt++;
                cnt++;
            }
            System.out.println("Accuracy:" +(corrects/steps/ratio*100.0));
            while(cnt<steps*(1-ratio)){
                network.calculateOutput(inputs[generalCnt]);
                network.modify(expecteds[generalCnt++], 0.1 );
                cnt++;
            }
        }
    }
    public static boolean compare(double[] a, double[] b){
        boolean equals = true;
            for(int j = 0;j<2;j++){
                if((b[j] == 1 && a[j]<0.99999999999)|| (b[j]==0 && a[j]>0.000001) ){equals = false;}
        }
        return equals;
    }
}
