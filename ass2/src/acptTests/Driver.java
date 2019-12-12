package acptTests;

import bridgeProject.BridgeProject;
import bridgeProject.BridgeProxy;
import bridgeProject.RealProxy;

public abstract class Driver {

	public static BridgeProject getBridge() {
		BridgeProxy bridge = new BridgeProxy();
		bridge.setRealBridge(new RealProxy()); // add real bridge here
		return bridge;
	}	
}