/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.loader;

import com.jme3.asset.AssetManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Node;
import com.jme3.shadow.BasicShadowRenderer;
import hex.model.HexBlock;
import hex.model.Lover;
import hex.model.Lucy;
import hex.model.Tree;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Joseph
 */
public class ModelLoader {
    
    private static AssetManager am;
    private static Node rn;
    private static ViewPort vp;
    private DirectionalLight sun = null;
    private BasicShadowRenderer shadow = null;
    
    private ArrayList<HexBlock> hexBlockGrid = new ArrayList<HexBlock>();
    private Lucy lucy = null;
    private Tree tree1 = null;
    private Tree tree2 = null;
    private Tree tree3 = null;
    private Lover depression = null;
    private Lover anger = null;
    private Lover jealousy = null;
    
    private ModelLoader(){
        createDemoHex();
    }

    public static ModelLoader create(Node rootNode, AssetManager assetManager, ViewPort viewPort) {
       am = assetManager;
       rn = rootNode;
       vp = viewPort;
       //rn.setShadowMode(RenderQueue.ShadowMode.Off);
       return new ModelLoader();
    }
    
    
    public void createDemoHex(){
        hexBlockGrid.clear();
        hexBlockGrid.add(HexBlock.createDefault(rn, am));
        hexBlockGrid.add(HexBlock.create(rn, am, 6, 0, 0));
        hexBlockGrid.add(HexBlock.create(rn, am, 0, 0, 6));
        hexBlockGrid.add(HexBlock.create(rn, am, 6, 0, 6));
        hexBlockGrid.add(HexBlock.create(rn, am, 2, 6, 2));
        
        
        //I will clean this up later, just testing models
        lucy = Lucy.createLucy(am, new Vector3f());
        //lucy.setPosition(270,410,1100);
        lucy.setPosition(270,402,1100);
        lucy.attachToNode(rn);
        
        depression = Lover.createLover(am, Vector3f.NAN);
        depression.loadDepressedLover(am);
        depression.setPosition(300, 402, 1000);
        depression.attachToNode(rn);
        
        //need to make hex faces a bit thicker, but so far looking good!
        anger = Lover.createLover(am, Vector3f.NAN);
        anger.loadAngryLover(am);
        anger.setPosition(600, 402, 1500);
        anger.attachToNode(rn);
        
        jealousy = Lover.createLover(am, Vector3f.NAN);
        jealousy.loadJealousLover(am);
        jealousy.setPosition(400, 652, 600);
        jealousy.attachToNode(rn);
        
        tree1 = Tree.createTree(am, new Vector3f());
        tree1.setPosition(900,410,1200);
        tree1.attachToNode(rn);
        
        tree2 = Tree.createTree(am, new Vector3f());
        tree2.setPosition(90,410,900);
        tree2.attachToNode(rn);
        
        tree3 = Tree.createTree(am, new Vector3f());
        tree3.setPosition(150,650,500);
        tree3.attachToNode(rn);
        
        
        sun = createSunlight();
        shadow = createShadows();
    }
    
    
    private DirectionalLight createSunlight(){
        
        DirectionalLight s = new DirectionalLight();
        //s.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f).normalizeLocal());
        s.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f).normalizeLocal());
        rn.addLight(s);
        
        return s;
    }
    
    private BasicShadowRenderer createShadows(){
        BasicShadowRenderer bsr = new BasicShadowRenderer(am, 256);
        //bsr.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f).normalizeLocal()); // light direction
        bsr.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f).normalizeLocal()); // light direction
        
        vp.addProcessor(bsr);
        
        return bsr;
    }
    
   
    
    
    
            

    
}
