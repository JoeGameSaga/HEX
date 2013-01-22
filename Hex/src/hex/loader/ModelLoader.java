/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.loader;

import com.jme3.asset.AssetManager;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;
import com.jme3.shadow.BasicShadowRenderer;
import com.jme3.util.TangentBinormalGenerator;
import hex.model.HexBlock;
import hex.model.Lantern;
import hex.model.Lover;
import hex.model.Lucy;
import hex.model.Sun;
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
    private Sun sun = null;
    
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
        
        
        //createTestSphere();
        
        Lantern lantern = Lantern.createLantern(am, new Vector3f(270, 500, 1150));
        lantern.attachToNode(rn);
        Lantern lantern2 = Lantern.createLantern(am, new Vector3f(180, 900, 500));
        lantern2.attachToNode(rn);
        sun = Sun.createDefaultSun(am, rn, vp);
    }
    
    private void createTestSphere(){
            Sphere rock = new Sphere(32,32, 2f);
            Geometry shiny_rock = new Geometry("Shiny rock", rock);
            
    Material mat_lit = new Material(am, "Common/MatDefs/Light/Lighting.j3md");
    //mat_lit.setTexture("DiffuseMap", am.loadTexture("Textures/Terrain/Pond/Pond.jpg"));
    //mat_lit.setTexture("NormalMap", am.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
    mat_lit.setBoolean("UseMaterialColors",true);    
    mat_lit.setColor("Specular",ColorRGBA.White);
    mat_lit.setColor("Diffuse",ColorRGBA.White);
    mat_lit.setColor("Ambient",ColorRGBA.White);
    mat_lit.setFloat("Shininess", 5f); // [1,128]    
    shiny_rock.setMaterial(mat_lit);
    shiny_rock.setLocalTranslation(300, 602, 1400); // Move it a bit
    shiny_rock.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    shiny_rock.scale(50);
    rn.attachChild(shiny_rock);
    
    }
    
    
   
    
}