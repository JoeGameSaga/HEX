/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;

/**
 *
 * @author Joseph
 */
public class Lantern {
    
    private static Vector3f position = new Vector3f(0,0,0);
    
    private PointLight lamp_light;
    private Geometry lamp;
    private ParticleEmitter fire;
    
    private Lantern(AssetManager assetManager, Vector3f pos){
        position=pos;
        loadLamp(assetManager);
    }
    
    
    public static Lantern createDefaultLantern(AssetManager assetManager){        
        return new Lantern(assetManager, position);
    }
    
    public static Lantern createLantern(AssetManager assetManager, Vector3f pos){        
        return new Lantern(assetManager, pos);
    }
    
    
    private void loadLamp(AssetManager am){
        float x = position.x;
        float y = position.y;
        float z = position.z;
        
        lamp_light = new PointLight();
        lamp_light.setColor(ColorRGBA.Yellow);
        lamp_light.setRadius(100f);
        lamp_light.setPosition(new Vector3f(x,y,z));
        
        
        Sphere s = new Sphere(32,32, 2f);
        lamp = new Geometry("Shiny rock", s);
        Material mat = new Material(am, "Common/MatDefs/Misc/Unshaded.j3md");   
        mat.setColor("Color", ColorRGBA.Yellow);
        lamp.setMaterial(mat);
        lamp.setLocalTranslation(x,y+10,z);
        lamp.scale(2);
    
        createFireAt(am, x,y+10,z);
        
    }
      
    
    private void createFireAt(AssetManager am, float x, float y, float z){
        
    fire = new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 30);
    Material mat_red = new Material(am, "Common/MatDefs/Misc/Particle.j3md");
    mat_red.setTexture("Texture", am.loadTexture("Effects/Explosion/flame.png"));
    fire.setMaterial(mat_red);
    fire.setImagesX(2); 
    fire.setImagesY(2); // 2x2 texture animation
    fire.setEndColor(new ColorRGBA(1f, 0f, 0f, 1f));   // red
    fire.setStartColor(new ColorRGBA(1f, 1f, 0f, 0.5f)); // yellow
    fire.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 15, 0));
    //fire.setStartSize(1.5f);
    fire.setStartSize(10f);
    fire.setEndSize(0.1f);
    fire.setGravity(0, 0, 0);
    fire.setLowLife(1f);
    fire.setHighLife(3f);
    fire.getParticleInfluencer().setVelocityVariation(0.3f);
    fire.setLocalTranslation(x, y, z);
    }
    
            

    
    public void attachToNode(Node n){
        n.addLight(lamp_light);
        n.attachChild(lamp);
        n.attachChild(fire);
    }
    
}

