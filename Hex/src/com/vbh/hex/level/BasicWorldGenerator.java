/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vbh.hex.level;

import com.vbh.hex.config.*;
/**
 *
 * @author ossah
 */
public class BasicWorldGenerator implements WorldGenerator {
    private enum Block{ AIR, DIRT};
    
    public char [] generate(int worldX, int worldY, int worldZ, int maxGround){
        char [] map = new char[worldX * worldY * worldZ];
        for(int i = 0; i < (worldX * worldY * worldZ); i++){
            // 
        }
        return map;
    } 
}
