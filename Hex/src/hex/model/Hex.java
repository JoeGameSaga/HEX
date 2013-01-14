/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Joseph
 */
public class Hex {
    
    private static Vector3f position = new Vector3f(0,0,0);
    private Spatial hex = null;
    private float xWitdh = 86;
    private float yHeight = xWitdh/2;
    private float zLenght = 150;

    private Hex(AssetManager assetManager, Vector3f pos){
        position=pos;
        loadBasicHex(assetManager);
    }
    
    public static Hex createDefaultHex(AssetManager assetManager){        
        return new Hex(assetManager, position);
    }
    
    public static Hex createHex(AssetManager assetManager, Vector3f pos){        
        return new Hex(assetManager, pos);
    }
    
    private void loadBasicHex(AssetManager assetManager){
       hex = assetManager.loadModel("Models/Hex/hex.j3o");
        
        //hex = assetManager.loadModel("Models/Teapot/Teapot.obj");       
        Material mat = new Material( 
            assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setTexture("ColorMap", 
            assetManager.loadTexture("Textures/hex.png"));
         mat.setTexture("ColorMap", 
            assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));
        hex.setMaterial(mat);
        
        hex.setLocalTranslation(Vector3f.ZERO);
        hex.scale(100);
        hex.move(position);
    }
    
    public void setPosition(float x, float y, float z){
        hex.move(x, y, z);
    }
    
    public Vector3f getPosition(){
        return position;
    }
    
    public void attachToNode(Node n){
        n.attachChild(hex);
    }
    
    public Spatial getHex() {
        return hex;
    }
    
    public float getxWitdh() {
        return xWitdh;
    }

    public float getyHeight() {
        return yHeight;
    }

    public float getzLenght() {
        return zLenght;
    }
    
}
