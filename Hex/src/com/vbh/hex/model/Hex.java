/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vbh.hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.bounding.BoundingBox;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;

/**
 *
 * @author ossah
 */
public class Hex {
    private Spatial hex;
    
    public Hex(AssetManager assetManager, Vector3f location){
        hex = assetManager.loadModel("Models/Hex/hex.obj");
        hex.setLocalTranslation(location);
        hex.scale(1);
    }

    public Spatial getSpatial(){
        return this.hex;
    }
}
