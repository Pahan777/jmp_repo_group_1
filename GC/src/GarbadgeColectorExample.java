
public class GarbadgeColectorExample {

    public static void main(String[] args) throws Exception {
        Integer index = 0;
        while (true) {
            GarbadgeColectorExample o = new GarbadgeColectorExample() ;
            o = null;
            index++;
            System.out.println("Iterations: "+index);
        }
    }
}
