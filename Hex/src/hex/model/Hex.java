/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.MatParamTexture;
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
public class Hex {
    
    private static Vector3f position = new Vector3f(0,0,0);
    private Spatial hex = null;
    private float xWitdh = 86;
    private float yHeight = (xWitdh/2)-1;
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
        
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        
        TextureKey textureKey = new TextureKey("Models/Hex/hex.png", true);
        textureKey.setAnisotropy(4);
        textureKey.setGenerateMips(true);
        Texture loadTexture = assetManager.loadTexture(textureKey);
        loadTexture.setMagFilter(Texture.MagFilter.Nearest);
        mat.setTexture("ColorMap", loadTexture);
        //relates to debug mode later
        //mat.setColor("ColorMap", ColorRGBA.Blue); 
        
        /*mat.setTexture("DiffuseMap", loadTexture);
        mat.setBoolean("UseMaterialColors",true);
        mat.setColor("Specular",ColorRGBA.White);
        mat.setColor("Diffuse",ColorRGBA.White);
        mat.setFloat("Shininess", 0f);*/
        
        
        hex.setMaterial(mat);
        hex.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
                
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
