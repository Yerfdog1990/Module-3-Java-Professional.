package structuralpattern.adaptor;

public class PlayMP4 implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
    }
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
