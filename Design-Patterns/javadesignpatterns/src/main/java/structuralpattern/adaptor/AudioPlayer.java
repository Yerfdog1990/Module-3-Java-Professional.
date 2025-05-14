package structuralpattern.adaptor;

public class AudioPlayer implements MediaPlayer{
    @Override
    public void play(String audioType, String fileName) {
        // inbuilt support to play mp3 music files
        if(audioType.equalsIgnoreCase("vlc")) {
            AdvancedMediaPlayer advancedMediaPlayer = new PlayVLC();
            advancedMediaPlayer.playVlc(fileName);

            //mediaAdapter is providing support to play other file formats
        } else if(audioType.equalsIgnoreCase("mp4")) {
            AdvancedMediaPlayer advancedMediaPlayer = new PlayMP4();
            advancedMediaPlayer.playMp4(fileName);
        }else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
