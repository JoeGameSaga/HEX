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
public class Lucy {
    
    private static Vector3f position = new Vector3f(0,0,0);
    private Spatial lucy = null;
    private float xWitdh = 86;
    private float yHeight = (xWitdh/2)-1;
    private float zLenght = 150;
    private Material mat = null;
    
    
    
    private Lucy(AssetManager assetManager, Vector3f pos){
        position=pos;
        loadLucy(assetManager);
    }
    
    
    public static Lucy createDefaultLucy(AssetManager assetManager){        
        return new Lucy(assetManager, position);
    }
    
    public static Lucy createLucy(AssetManager assetManager, Vector3f pos){        
        return new Lucy(assetManager, pos);
    }
    
    private void loadLucy(AssetManager assetManager){
        lucy = assetManager.loadModel("Models/Lucy/lucy.j3o");
        lucy.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
       
        mat = new Material( 
            assetManager, "Common/MatDefs/Light/Lighting.j3md");
        TextureKey textureKey = new TextureKey("Models/Lucy/lucy.png", true);
        textureKey.setAnisotropy(4);
        textureKey.setGenerateMips(true);
        Texture loadTexture = assetManager.loadTexture(textureKey);
        loadTexture.setMagFilter(Texture.MagFilter.Nearest);
        mat.setBoolean("UseMaterialColors",true);
        mat.setTexture("DiffuseMap", loadTexture);
        mat.setColor("Specular",ColorRGBA.White);
        mat.setColor("Diffuse",ColorRGBA.White);
        mat.setFloat("Shininess", 0f);
        
        lucy.setMaterial(mat);
                
        lucy.setLocalTranslation(Vector3f.ZERO);
        lucy.scale(50);
        lucy.move(0, 0, 0);
    }
    
    
     public void setPosition(float x, float y, float z){
        lucy.move(x, y, z);
    }
    
    public Vector3f getPosition(){
        return position;
    }
    
    public void attachToNode(Node n){
        n.attachChild(lucy);
    }
    
    public Spatial getLucy() {
        return lucy;
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
