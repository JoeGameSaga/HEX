/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.model;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class HexBlock {
    
    private static int blockSize = 5;
    private float x = 0;
    private float y = 0;
    private float z = 0;
    
    private Node rn = null;
    private AssetManager am = null;
    
    private ArrayList<Hex> hexGrid = new ArrayList<Hex>();
    
    private HexBlock(Node rootNode, AssetManager assetManager, int xc, int yc, int zc){
        am = assetManager;
        rn = rootNode;
      
        float x = 86;
        float y = 44;
        float z = 150;
        
        /*
        createHex(x*0,y*0,z*0);
        createHex(x*1,y*0,z*1);
        createHex(x*2,y*0,z*0);
        createHex(x*3,y*0,z*1);
        createHex(x*4,y*0,z*0);
        createHex(x*5,y*0,z*1);
        createHex(x*6,y*0,z*0);
        createHex(x*7,y*0,z*1);
        
        createHex(x*0,y*1,z*0);
        createHex(x*1,y*1,z*1);
        createHex(x*2,y*1,z*0);
        createHex(x*3,y*1,z*1);
        createHex(x*0,y*1,z*2);
        createHex(x*1,y*1,z*3);
        createHex(x*2,y*1,z*2);
        createHex(x*3,y*1,z*3);
        createHex(x*0,y*1,z*4);
        createHex(x*1,y*1,z*5);
        createHex(x*2,y*1,z*4);
        createHex(x*3,y*1,z*5);
        */
                
        populateHexGrid(xc,yc,zc);
    }
    
     public static HexBlock createDefault(Node rootNode, AssetManager assetManager) {
       return new HexBlock(rootNode, assetManager, 0, 0, 0);
    }
     
     public static HexBlock create(Node rootNode, AssetManager assetManager, int xc, int yc, int zc) {
       return new HexBlock(rootNode, assetManager, xc, yc, zc);
    }
    
    
    private void populateHexGrid(int xc, int yc, int zc){
        boolean zig = true;
        for(int z = zc; z <= (zc+blockSize);z=z+2){
        for(int y = yc; y<=(yc+blockSize);y++){
            zig = true;
            for(int x = xc; x<=(xc+blockSize);x++){
                if(zig){
                createHex(x,y,z);
                }
                else{           
                createHex(x,y,z+1);
                }
                zig = !zig;
            }
        }
        }        
    }
    
    public void createHex(float x, float y, float z){        
        hexGrid.add(Hex.createDefaultHex(am)); 
        int hexPos = hexGrid.size()-1;
        hexGrid.get(hexPos).setPosition(hexGrid.get(hexPos).getxWitdh()*x, hexGrid.get(hexPos).getyHeight()*y,hexGrid.get(hexPos).getzLenght()*z);
        //hexGrid.get(hexPos).setPosition(x,y,z);
        hexGrid.get(hexPos).attachToNode(rn);
    }
    
    
}
