package db;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageRepositoryInMemory {
    private HashMap<String, BufferedImage> images;

    public ImageRepositoryInMemory() {
        images = new HashMap<>();
    }

    public BufferedImage getImage(String key){
        return images.get(key);
    }

    public void addImage(String key, BufferedImage image){
        images.put(key,image);
        File file = new File("src/main/resources/uploadedImages/"+ key);
        try {
            ImageIO.write(image, "jpg", file);
            System.out.println("image saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<BufferedImage> getAll(){
        ArrayList<BufferedImage> result = new ArrayList<>();
        for (BufferedImage image: images.values()) {
            result.add(image);
        }
        return result;
    }

    public List<String> getAllKeys(){
        ArrayList<String> result = new ArrayList<>();
        for (String key: images.keySet()){
            result.add(key);
        }
        return result;
    }
}
