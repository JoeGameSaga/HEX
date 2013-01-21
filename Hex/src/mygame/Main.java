package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import hex.loader.ModelLoader;
import hex.ui.HUI;
import hex.ui.camera.HCam;


/**
 * @author Joseph
 */
public class Main extends SimpleApplication {
    
    
       ModelLoader modelLoader = null;
       HUI hexUI = null;
       HCam hCam = null;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {  
       modelLoader = ModelLoader.create(this.getRootNode(), this.getAssetManager(), this.viewPort);
       hCam = HCam.create(this.getViewPort().getCamera(), this.getFlyByCamera());
       hexUI = HUI.create(hCam, this.getAssetManager(), this.getGuiNode(), this.guiFont); 
       hexUI.writeText("Hello Lucy!");
    }
    
    
    @Override
    public void simpleUpdate(float tpf) {
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
