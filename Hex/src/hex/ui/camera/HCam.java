/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.ui.camera;

import com.jme3.input.FlyByCamera;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
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
        camera.setLocation(new Vector3f(-500,1000,2000));
        camera.lookAt(new Vector3f(270,402,1100), new Vector3f(0,0,0));
        camera.setFrustumFar(renderDistance);
        camera.onFrameChange();
    }

    public static HCam createDefault() {
        camera = new Camera();
        return new HCam(camera, new FlyByCamera(camera), 400, 5000);
    }
    public static HCam create(Camera c, FlyByCamera fbc) {
        return new HCam(c, fbc, 600, 5000);
    }
    
    public Camera getCamera(){
        return camera;
    }
    
}
