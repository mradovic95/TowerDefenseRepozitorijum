package graphics;

import java.awt.image.BufferedImage;

public class Animation
{
    public BufferedImage[] frames;//niz frejmova animacije
    private int currentFrame;//index niza frejmova
    private long startTime;//poecetno vreme animacije
    private long delay;//vreme posle koga se prelazi na sledeci frejm
    public boolean playedonce;//da li se izvrsio jedan ciklus animacije

    //metoda za ucitavanje frejmova animacije
    public void setFrames(BufferedImage[] frames)
    {
        this.frames=frames;
        currentFrame=0;
        startTime=System.nanoTime();
    }

    public void setDelay(long d)
    {
        delay=d;
    }
    public void setCurrentFrame(int frame)
    {
        this.currentFrame=frame;
    }
    public void update()
    {
        long elapsed=(System.nanoTime()-startTime)/1000000;//vreme koje je proslo otkako se preslo na trenutni frejm(deli se sa hiljadu da bi se nanosekunde pretvorile u milisekunde)
        if(elapsed>delay)//ako je vreme od otkako se preslo na ovaj frejm vece od vremena predvidjenog za frejm preci na sledeci frejm i resetovati vreme
        {
            currentFrame++;
            startTime=System.nanoTime();
        }
        if(currentFrame==frames.length)//ako su se svi frejmovi izvrteli vraca se na pocetni frejm
        {
            currentFrame=0;
            playedonce=true;
        }
    }
    public BufferedImage getFrame()
    {
        return frames[currentFrame];
    }//dobijanje zeljenog frejma iz niza frejmova

    public int getCurrentFrame() {
        return currentFrame;
    }

    public boolean isPlayedonce() {
        return playedonce;
    }
}

