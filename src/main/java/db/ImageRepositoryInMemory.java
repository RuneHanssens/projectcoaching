package db;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageRepositoryInMemory {
    private ArrayList<String> images;

    public ImageRepositoryInMemory() {
        images = new ArrayList<>();
    }


    public void addImage(String key){
        images.add(key);
    }

    public List<String> getAllKeys(){
        return images;
    }
}
