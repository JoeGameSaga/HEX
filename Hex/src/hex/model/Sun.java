/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.shadow.BasicShadowRenderer;

/**
 *
 * @author Joseph
 */
public class Sun {
    
    
    AssetManager am = null;
    Node rn = null;
    ViewPort vp = null;
    float x = 0;
    float y = 0;
    float z = 0;
   
    private Sun(AssetManager assetManager, Node rootNode, ViewPort viewPort, float dx, float dy, float dz) {
        am = assetManager;
        rn = rootNode;
        vp = viewPort;
        x = dx;
        y = dy;
        z = dz;
        
        //createSunlight();//disabling sun for now to test other lights
        createShadows();
    }
    
     public static Sun createDefaultSun(AssetManager assetManager, Node rn, ViewPort vp ){        
        return new Sun(assetManager, rn, vp, -0.1f, -0.7f, -1.0f);
    }     
     
     
     public static Sun createSun(AssetManager assetManager, Node rn, ViewPort vp, float dx, float dy, float dz) {        
        return new Sun(assetManager, rn, vp, dx, dy, dz);
    }

     private DirectionalLight createSunlight(){
        
        DirectionalLight s = new DirectionalLight();
        s.setDirection(new Vector3f(x, y, z).normalizeLocal());
        rn.addLight(s);
        
        return s;
    }
    
    private BasicShadowRenderer createShadows(){
        BasicShadowRenderer bsr = new BasicShadowRenderer(am, 256);
        bsr.setDirection(new Vector3f(x, y, z).normalizeLocal());
        
        vp.addProcessor(bsr);
        
        return bsr;
    }
    
}
