/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;

/**
 *
 * @author Joseph
 */
public class Tree {
    
    private static Vector3f position = new Vector3f(0,0,0);
    private Spatial tree = null;
    private float xWitdh = 86;
    private float yHeight = (xWitdh/2)-1;
    private float zLenght = 150;
    private Material mat = null;
    
    
    
    private Tree(AssetManager assetManager, Vector3f pos){
        position=pos;
        loadTree(assetManager);
    }
    
    
    public static Tree createDefaultTree(AssetManager assetManager){        
        return new Tree(assetManager, position);
    }
    
    public static Tree createTree(AssetManager assetManager, Vector3f pos){        
        return new Tree(assetManager, pos);
    }
    
    private void loadTree(AssetManager assetManager){
        tree = assetManager.loadModel("Models/Tree/tree.j3o");
        
        mat = new Material( 
            assetManager, "Common/MatDefs/Light/Lighting.j3md");
        TextureKey textureKey = new TextureKey("Models/Tree/tree.png", true);
        textureKey.setAnisotropy(4);
        textureKey.setGenerateMips(true);
        Texture loadTexture = assetManager.loadTexture(textureKey);
        loadTexture.setMagFilter(Texture.MagFilter.Nearest);
        //mat.setTexture("ColorMap", loadTexture);
        
        mat.setTexture("DiffuseMap", loadTexture);
        mat.setBoolean("UseMaterialColors",true);
        mat.setColor("Specular",ColorRGBA.White);
        mat.setColor("Diffuse",ColorRGBA.White);
        mat.setFloat("Shininess", 0f);
        
        tree.setMaterial(mat);
        tree.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
                
        tree.setLocalTranslation(Vector3f.ZERO);
        tree.scale(100);
        tree.move(0, 0, 0);
    }
    
    
     public void setPosition(float x, float y, float z){
        tree.move(x, y, z);
    }
    
    public Vector3f getPosition(){
        return position;
    }
    
    public void attachToNode(Node n){
        n.attachChild(tree);
    }
    
    public Spatial getTree() {
        return tree;
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
