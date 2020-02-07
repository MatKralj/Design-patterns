package designpatternscomposite;

import designpatternscomposite.abstractClasses.SongComponent;
import designpatternscomposite.concreteClasses.DiskJockey;
import designpatternscomposite.concreteClasses.Song;
import designpatternscomposite.concreteClasses.SongGroup;

public class DesignPatternsComposite {

    public static void main(String[] args) {
        
        SongComponent industrialMusic = new SongGroup("Industrial", "");
        SongComponent heavyMetalMusic = new SongGroup("HeavyMetalMusic", "");
        SongComponent dubstepMusic = new SongGroup("Dubstep", "");
        
        SongComponent everySong = new SongGroup("Song List", "Every Song Available");
        everySong.add(industrialMusic);
        industrialMusic.add(new Song("Neka pjesma1", "NIN", 1990));
        industrialMusic.add(new Song("Neka pjesma2", "PIPA", 1999));
        
        industrialMusic.add(dubstepMusic);
        dubstepMusic.add(new Song("Neki dub", "dsa", 1990));
        
        everySong.add(heavyMetalMusic);
        heavyMetalMusic.add(new Song("Neka pjesma3", "NIN", 1988));
        heavyMetalMusic.add(new Song("Neka pjesma3", "PIPA", 1993));
        
        DiskJockey crazyLarry = new DiskJockey(everySong);
        
        crazyLarry.getSongList();
    }
    
}
