package designpatternscomposite.concreteClasses;

import designpatternscomposite.abstractClasses.SongComponent;

public class DiskJockey {
     SongComponent songList;

    public DiskJockey(SongComponent songList) {
        this.songList = songList;
    }
     
     public void getSongList(){
         songList.displaySongInfo();
     }
}
