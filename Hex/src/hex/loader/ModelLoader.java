/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.loader;

import com.jme3.asset.AssetManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import hex.model.HexBlock;
import hex.model.Lucy;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Joseph
 */
public class ModelLoader {
    
    private static AssetManager am;
    private static Node rn;
    private DirectionalLight sun = null;
    
    private ArrayList<HexBlock> hexBlockGrid = new ArrayList<HexBlock>();
    private Lucy lucy = null;
    
    private ModelLoader(){
        createDemoHex();
    }

    public static ModelLoader create(Node rootNode, AssetManager assetManager) {
       am = assetManager;
       rn = rootNode;
       return new ModelLoader();
    }
    
    
    public void createDemoHex(){
        hexBlockGrid.clear();
        hexBlockGrid.add(HexBlock.createDefault(rn, am));
        hexBlockGrid.add(HexBlock.create(rn, am, 6, 0, 0));
        hexBlockGrid.add(HexBlock.create(rn, am, 0, 0, 6));
        hexBlockGrid.add(HexBlock.create(rn, am, 6, 0, 6));
        hexBlockGrid.add(HexBlock.create(rn, am, 2, 6, 2));
        
        lucy = Lucy.createLucy(am, new Vector3f());
        lucy.setPosition(270,410,1100);
        lucy.attachToNode(rn);
        sun = createSunlight();
    }
    
    
    private DirectionalLight createSunlight(){
        
        DirectionalLight s = new DirectionalLight();
        s.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rn.addLight(s);
        
        return s;
    }
    
   
    
    
    
            

    
}
