/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;

/**
 *
 * @author Joseph
 * 
 * A lover is a being of pure energy formed from lucys amulet
 * when a lover strays too far from lucy its heart begins to empty
 * and it dies. If lucy dies or exits the level all lovers die.
 * Lovers are meant for 4 player multiplayer.
 * presumably, these are boyfriends lucy had in the past who died.
 * Blue (Depression)
 * Red (Anger)
 * Green (Jealousy)
 * 
 */
public class Lover {
    
    private static Vector3f position = new Vector3f(0,0,0);
    private Spatial lover = null;
    private String name = "depression";
    private float xWitdh = 86;
    private float yHeight = (xWitdh/2)-1;
    private float zLenght = 150;
    
    
    
    private Lover(AssetManager assetManager, Vector3f pos){
        position=pos;
        //loadDepressedLover(assetManager);
    }
    
    
    public static Lover createDefaultLover(AssetManager assetManager){        
        return new Lover(assetManager, position);
    }
    
    public static Lover createLover(AssetManager assetManager, Vector3f pos){        
        return new Lover(assetManager, pos);
    }
    
    
    public void loadDepressedLover(AssetManager assetManager){
        loadLover(assetManager, "depression");        
    }
    
    public void loadAngryLover(AssetManager assetManager){
        loadLover(assetManager, "anger");
    }
    
    public void loadJealousLover(AssetManager assetManager){
        loadLover(assetManager, "jealousy");
    }    
    
    
    private void loadLover(AssetManager assetManager, String n){
        name = n;
        lover = assetManager.loadModel("Models/Lover/lover.j3o");
        
        Material mat = new Material( 
            assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey textureKey = new TextureKey("Models/Lover/lightSpiritDense.png", true);
        //textureKey.setAnisotropy(4);
        //textureKey.setGenerateMips(true);
        Texture loadTexture = assetManager.loadTexture(textureKey);
        loadTexture.setMagFilter(Texture.MagFilter.Nearest);
        mat.setTexture("ColorMap", loadTexture);
        
        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Additive); 
        if(name.contentEquals("depression")){
           mat.setColor("Color", new ColorRGBA(.2f,.2f,1f, 1f));
        }
        else if(name.contentEquals("anger")){
           mat.setColor("Color", new ColorRGBA(1f,0f,0.5f, 1f));
        }
        else{
           mat.setColor("Color", new ColorRGBA(.5f,1f,.5f, 1f)); 
        }
        
        lover.setMaterial(mat);
        lover.setQueueBucket(RenderQueue.Bucket.Transparent);
        lover.setShadowMode(RenderQueue.ShadowMode.Cast);
        
                
        lover.setLocalTranslation(Vector3f.ZERO);
        lover.scale(50);
        lover.move(0, 0, 0);
    }
    
    
     public void setPosition(float x, float y, float z){
        lover.move(x, y, z);
    }
    
    public Vector3f getPosition(){
        return position;
    }
    
    public void attachToNode(Node n){
        n.attachChild(lover);
    }
    
    public Spatial getLover() {
        return lover;
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
