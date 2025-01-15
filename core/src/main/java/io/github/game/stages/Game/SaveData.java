package io.github.game.stages.Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
    private static SaveData save;
        
    public static SaveData instance(){
        if(save == null){
            save = new SaveData();
        }   
        return save;
    }

    public void Save(int typelevel, int position){
        try  {
            FileWriter file = new FileWriter("Save/data");
            BufferedWriter writer = new BufferedWriter(file);

            if(position == 1){
                switch (typelevel) {
                    case 1:
                        //unlock car 2
                        writer.write("true,true,false");
                        break;
                
                    case 2:
                        //unlock car 3
                        writer.write("true,true,true");
                        break;
                        
                    case 3:
                        //unlock all
                        writer.write("true,true,true");
                        break;
                }
            }
            if(position != 1){
                switch (typelevel) {
                    case 1:
                        //unlock car 1 
                        writer.write("true,false,false");
                        break;
                
                    case 2:
                        //unlock car 1 and car 2
                        writer.write("true,true,false");
                        break;
                        
                    case 3:
                        //unlock all
                        writer.write("true,true,true");
                        break;
                }
            }
        
            writer.close();
            file.close();
            
        } catch (IOException e) {
           
        }

    }

    public boolean[] Load(){
       try(BufferedReader reader = new BufferedReader(new FileReader("Save/data"))) {
            String line = reader.readLine();
            String [] data = line.split(",");
            reader.close();
            return new boolean[]{Boolean.parseBoolean(data[0]), Boolean.parseBoolean(data[1]), Boolean.parseBoolean(data[2])};
        
       } catch (Exception e) {
           e.printStackTrace(); 
           return null;
        }
    }

}
