package adapterdesign;

public class MediaAdaptor implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdaptor(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new PlayVLC();
        }
        else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new PlayMP4();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
