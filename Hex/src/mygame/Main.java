package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.vbh.hex.model.Hex;
import java.util.ArrayList;
import java.util.List;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        final int MAX_X = 10;
        final int MAX_Z = 10;
        
        final float MOD_X = (1f * 0.75f);
        final float MOD_Z = (1f * 0.5f);
        
        List<Hex> hexes = new ArrayList<Hex>();
        
        for(int i = 0; i < MAX_Z; i++){
            Hex previousHex = null;
            for(int j = 0; j < MAX_X; j++){
                Vector3f location;
                
                if(j == 0){
                    // first hex. Place at (0,0,0)
                    location = new Vector3f();
                }else if(j % 2 == 0){
                    // move hex up z axis (negative MOD_Z)
                    location = new Vector3f(j * MOD_X, 0, MOD_Z);
                    
                }else{
                    // move hex down z axis (positive MOD_Z)
                    location = new Vector3f(j * MOD_X, 0, (-1 * MOD_Z));
                }
                
                previousHex = new Hex(assetManager, location);
                hexes.add(previousHex);
            }
        }
        
        for(Hex hex : hexes){
            rootNode.attachChild(hex.getSpatial());
            String msg = "X: " + hex.getSpatial().getWorldTranslation().x +
                    ", Y: " + hex.getSpatial().getWorldTranslation().y + 
                    ", Z: " + hex.getSpatial().getWorldTranslation().z;
            System.out.println(msg);
        }
        
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    private void initKeys(){
        
    }
}
