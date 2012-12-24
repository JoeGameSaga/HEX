/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vbh.hex.level;

import java.util.List;
import com.vbh.hex.config.*;

/**
 *
 * @author ossah
 */
public class WorldManager {
    private static WorldManager manager = null;
    private char[] worldMap;
    
    private WorldManager(){
        BasicWorldGenerator worldGenerator = new BasicWorldGenerator();
        worldMap = worldGenerator.generate(
                Config.WORLD_MAX_X, Config.WORLD_MAX_Y, Config.WORLD_MAX_Z,
                Config.WORLD_SIZE);
        
    }
    
    public static WorldManager getInstance(){
        if(manager == null)
            manager = new WorldManager();
        return manager;
    }
}
