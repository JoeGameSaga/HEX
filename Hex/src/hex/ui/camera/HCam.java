/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.ui.camera;

import com.jme3.input.FlyByCamera;
import com.jme3.renderer.Camera;

/**
 *
 * @author Joseph
 */
public class HCam {
    
    private static Camera camera = null;
    private static FlyByCamera flyByCamera = null;
    
    private HCam(Camera c, FlyByCamera fbc, int fbcMoveSpeed, int renderDistance){
        camera = c;
        flyByCamera = fbc;
        
        flyByCamera.setMoveSpeed(fbcMoveSpeed);
        camera.setFrustumFar(renderDistance);
        camera.onFrameChange();
    }

    public static HCam createDefault() {
        camera = new Camera();
        return new HCam(camera, new FlyByCamera(camera), 400, 5000);
    }
    public static HCam create(Camera c, FlyByCamera fbc) {
        return new HCam(c, fbc, 900, 5000);
    }
    
    public Camera getCamera(){
        return camera;
    }
    
}
