public class Test {
    public static void main(String[] args) {
        int[] a = {2,3,2};
        Network network = new Network(3, a);
        double[] b = {1.1,2.3};
        double[] c = network.calculateOutput(b);
        for(int i =0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
}
