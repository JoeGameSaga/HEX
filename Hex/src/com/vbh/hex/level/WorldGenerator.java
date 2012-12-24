/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vbh.hex.level;

import java.util.List;

/**
 *
 * @author ossah
 */
public interface WorldGenerator {
    public char [] generate(int worldX, int worldY, int worldZ, int maxGround);
}
