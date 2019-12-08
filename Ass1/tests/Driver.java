public class Driver {

    public static ProjectManagmentBridge getBridge(){
        ProxyBridge bridge = new ProxyBridge();
        /*
        RealBridge b = new RealBridge();
        bridge.setBridge(b);
         */
        return bridge;
    }
}
