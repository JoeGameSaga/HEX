/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.ui;

import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import hex.ui.camera.HCam;

/**
 *
 * @author Joseph
 */
public class HUI {
    
    private static AssetManager assetManager;
    private static Node guiNode;
    private static BitmapFont guiFont;
    private Camera cam;
    
    
    private HUI(Camera c, AssetManager am, Node gn, BitmapFont gf){
       cam = c;
       assetManager=am;
       guiNode=gn;
       guiFont=gf;
       guiNode.detachAllChildren();
    }

    public static HUI create(HCam c, AssetManager am, Node gn, BitmapFont gf) {
      return new HUI(c.getCamera(), am, gn, gf);
    }
     
    public void writeText(String s){
        writeText(s, cam.getHeight()/2, cam.getWidth()/2);
    }
    
    public void writeText(String s, float x, float y){
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText text = new BitmapText(guiFont, false);
        text.setSize(guiFont.getCharSet().getRenderedSize());
        text.setText(s);
        text.setLocalTranslation(x, y, 0);
        guiNode.attachChild(text);
    }
    
}
