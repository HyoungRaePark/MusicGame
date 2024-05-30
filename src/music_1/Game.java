package src.music_1;

import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

//게임이 시작이되면 이 게임의 인스턴수 변수로 게임을 컨트롤한다
public class Game extends Thread
{
    //게임 배경화면 이미지
    private Image noteRouteLineImage = new ImageIcon(musicmain.class.getResource("../imges/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(musicmain.class.getResource("../imges/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(musicmain.class.getResource("../imges/gameInfo.png")).getImage();
    //키보드 눌렀을때의 노트 이미지 변경
    private Image noteRouteSImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
    //키보드 판정 이미지 
    private Image blueFlareImage;
    private Image judgeImage;
    //키보드 판정 이미지 (개별)
    private Image keyPadSImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    private Image keyPadDImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    private Image keyPadFImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    private Image keyPadSpace1Image = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    private Image keyPadSpace2Image = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    private Image keyPadJImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    private Image keyPadKImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    private Image keyPadLImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();



    
    //실행되는 타이틀의 이름
    private String titleName;
    //실제로 고른 난이도 이름
    private String difficulty;
    private String musicTitle;
    private music gameMusic;

    //노트이미지가 표현되는 배열 함수
    ArrayList<Note> noteList = new ArrayList<Note>();

   

    public Game(String titleName, String difficulty, String musicTitle)
    {
      this.titleName = titleName;
      this.difficulty = difficulty;
      this.musicTitle = musicTitle;
      gameMusic = new music(this.musicTitle,false);
    }
    public void screenDraw(Graphics2D g)
    {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
        g.drawImage(noteRouteLineImage, 224, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 432, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgementLineImage, 0, 580, null);
        for(int i = 0; i < noteList.size(); i++)
        {
            Note note = noteList.get(i);
            if(note.getY() > 620)
            {
               judgeImage = new ImageIcon(musicmain.class.getResource("../imges/judgeMiss.png")).getImage();
            }
            if(!note.isProceeded())
            {
               noteList.remove(i);
               i--;
            }
            else
            {
               note.screenDraw(g);
            }
            note.screenDraw(g);
        }
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Malgun Gothic", Font.BOLD,30));
        g.drawString(titleName,20,702);
        g.drawString(difficulty,1190,702);
        g.setFont(new Font("Arial", Font.PLAIN,26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space Bar",580,609);
        g.drawString("J",784,609);
        g.drawString("K",889,609);
        g.drawString("L",993,609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD,30));
        g.drawString("000000",565,702);
        g.drawImage(blueFlareImage, 460, 430,null);
        g.drawImage(judgeImage, 460, 420,null);
        g.drawImage(keyPadSImage, 228, 580,null);
        g.drawImage(keyPadDImage, 332, 580,null);
        g.drawImage(keyPadFImage, 436, 580,null);
        g.drawImage(keyPadSpace1Image, 540, 580,null);
        g.drawImage(keyPadSpace2Image, 640, 580,null);
        g.drawImage(keyPadJImage, 744, 580,null);
        g.drawImage(keyPadKImage, 848, 580,null);
        g.drawImage(keyPadLImage, 952, 580,null);
    }

    public void pressS()
    {
       judge("S");
       noteRouteSImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       keyPadSImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       new music("../backmusic/Keymusic2.mp3",false).start();
    }
    public void releaseS()
    {
       noteRouteSImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       keyPadSImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    }

    public void pressD()
    {
       judge("D");
       noteRouteDImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       keyPadDImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       new music("../backmusic/Keymusic2.mp3",false).start();
    }
    public void releaseD()
    {
       noteRouteDImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       keyPadDImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    }

    public void pressF()
    {
       judge("F");
       noteRouteFImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       keyPadFImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       new music("../backmusic/Keymusic2.mp3",false).start();
    }
    public void releaseF()
    {
       noteRouteFImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       keyPadFImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    }

    public void pressSpace()
    {
       judge("Space");
       noteRouteSpace1Image = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       noteRouteSpace2Image = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       keyPadSpace1Image = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       keyPadSpace2Image = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       new music("../backmusic/Spacemusic.mp3",false).start();
    }
    public void releaseSpace()
    {
       noteRouteSpace1Image = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       noteRouteSpace2Image = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       keyPadSpace1Image = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
       keyPadSpace2Image = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    }

    public void pressJ()
    {
       judge("J");
       noteRouteJImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       keyPadJImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       new music("../backmusic/Keymusic2.mp3",false).start();
    }
    public void releaseJ()
    {
       noteRouteJImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       keyPadJImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    }

    public void pressK()
    {
       judge("K");
       noteRouteKImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       keyPadKImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       new music("../backmusic/Keymusic2.mp3",false).start();
    }
    public void releaseK()
    {
       noteRouteKImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       keyPadKImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    }

    public void pressL()
    {
       judge("L");
       noteRouteLImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoutePressed.png")).getImage();
       keyPadLImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadPressed.png")).getImage();
       new music("../backmusic/Keymusic2.mp3",false).start();
    }
    public void releaseL()
    {
       noteRouteLImage = new ImageIcon(musicmain.class.getResource("../imges/noteRoute.png")).getImage();
       keyPadLImage = new ImageIcon(musicmain.class.getResource("../imges/keyPadBasic.png")).getImage();
    }


    @Override
    public void run()
    {
      dropNotes();
    }

    //뒤로가기 했을때 음악 꺼지게하기
    public void close()
    {
      gameMusic.close();
      this.interrupt();
    }
    //노트 이미지 배열 함수 각각의 노트들이 떨어질수있도록만듬
    public void dropNotes()
    {
      Beat[] beats = null;
      if(titleName.equals("고민중독"))
      {
         //시작시간
         int startTime = 0;
         //노트사이의 갭
         int gap = 125;
         beats = new Beat[]
         {
            new Beat(startTime + gap * 4, "S"),
            new Beat(startTime + gap * 6, "K"),
            new Beat(startTime + gap * 7, "D"),
            new Beat(startTime + gap * 9, "J"),
            new Beat(startTime + gap * 10, "F"),
            new Beat(startTime + gap * 12, "J"),
            new Beat(startTime + gap * 13, "Space"),
            new Beat(startTime + gap * 14, "S"),
            new Beat(startTime + gap * 15, "D"),
            new Beat(startTime + gap * 16, "K"),
            new Beat(startTime + gap * 18, "J"),
            new Beat(startTime + gap * 19, "L"),
            new Beat(startTime + gap * 20, "D"),
            new Beat(startTime + gap * 22, "Space"),
            new Beat(startTime + gap * 23, "S"),
            new Beat(startTime + gap * 24, "F"),
            new Beat(startTime + gap * 26, "S"),
            new Beat(startTime + gap * 27, "J"),
            new Beat(startTime + gap * 28, "D"),
            new Beat(startTime + gap * 29, "S"),
            new Beat(startTime + gap * 31, "Space"),
            new Beat(startTime + gap * 32, "L"),
            new Beat(startTime + gap * 33, "D"),
            new Beat(startTime + gap * 34, "K"),
            new Beat(startTime + gap * 35, "S"),
            new Beat(startTime + gap * 36, "J"),
            new Beat(startTime + gap * 38, "S"),
            new Beat(startTime + gap * 39, "Space"),
            new Beat(startTime + gap * 40, "L"),
            new Beat(startTime + gap * 42, "D"),
            new Beat(startTime + gap * 43, "K"),
            new Beat(startTime + gap * 44, "S"),
            new Beat(startTime + gap * 46, "J"),
            new Beat(startTime + gap * 47, "L"),
            new Beat(startTime + gap * 48, "Space"),
            new Beat(startTime + gap * 50, "S"),
            new Beat(startTime + gap * 51, "Space"),
            new Beat(startTime + gap * 54, "L"),
            new Beat(startTime + gap * 56, "D"),
            new Beat(startTime + gap * 59, "K"),
            new Beat(startTime + gap * 60, "S"),
            new Beat(startTime + gap * 62, "J"),
            new Beat(startTime + gap * 63, "L"),
            new Beat(startTime + gap * 67, "Space"),
            new Beat(startTime + gap * 68, "S"),
            new Beat(startTime + gap * 69, "F"),
            new Beat(startTime + gap * 72, "S"),
            new Beat(startTime + gap * 74, "J"),
            new Beat(startTime + gap * 75, "D"),
            new Beat(startTime + gap * 76, "S"),
            new Beat(startTime + gap * 77, "Space"),
            new Beat(startTime + gap * 79, "L"),
            new Beat(startTime + gap * 81, "D"),
            new Beat(startTime + gap * 82, "K"),
            new Beat(startTime + gap * 83, "S"),
            new Beat(startTime + gap * 84, "J"),
            new Beat(startTime + gap * 85, "D"),
            new Beat(startTime + gap * 87, "J"),
            new Beat(startTime + gap * 88, "F"),
            new Beat(startTime + gap * 92, "J"),
            new Beat(startTime + gap * 93, "Space"),
            new Beat(startTime + gap * 97, "S"),
            new Beat(startTime + gap * 99, "D"),
            new Beat(startTime + gap * 102, "K"),
            new Beat(startTime + gap * 105, "J"),
            new Beat(startTime + gap * 109, "L"),
            new Beat(startTime + gap * 111, "D"),
            new Beat(startTime + gap * 113, "Space"),
            new Beat(startTime + gap * 114, "S"),
            new Beat(startTime + gap * 116, "K"),
            new Beat(startTime + gap * 117, "D"),
            new Beat(startTime + gap * 119, "J"),
            new Beat(startTime + gap * 120, "F"),
            new Beat(startTime + gap * 122, "J"),
            new Beat(startTime + gap * 123, "Space"),
            new Beat(startTime + gap * 124, "S"),
            new Beat(startTime + gap * 125, "D"),
            new Beat(startTime + gap * 126, "K"),
            new Beat(startTime + gap * 128, "J"),
            new Beat(startTime + gap * 129, "L"),
            new Beat(startTime + gap * 136, "J"),
            new Beat(startTime + gap * 137, "L"),
            new Beat(startTime + gap * 138, "Space"),
            new Beat(startTime + gap * 143, "S"),
            new Beat(startTime + gap * 144, "F"),
            new Beat(startTime + gap * 146, "S"),
            new Beat(startTime + gap * 147, "J"),
            new Beat(startTime + gap * 148, "D"),
            new Beat(startTime + gap * 149, "S"),
            new Beat(startTime + gap * 151, "Space"),
            new Beat(startTime + gap * 152, "L"),
            new Beat(startTime + gap * 153, "D"),
            new Beat(startTime + gap * 154, "K"),
            new Beat(startTime + gap * 155, "S"),
         };
      }
      else if(titleName.equals("최종화"))
      {
         int startTime = 0;
         int gap = 125;
         beats = new Beat[]
         {
            new Beat(startTime + gap * 4, "S"),
            new Beat(startTime + gap * 6, "K"),
            new Beat(startTime + gap * 7, "D"),
            new Beat(startTime + gap * 9, "J"),
            new Beat(startTime + gap * 10, "F"),
            new Beat(startTime + gap * 12, "J"),
            new Beat(startTime + gap * 13, "Space"),
            new Beat(startTime + gap * 14, "S"),
            new Beat(startTime + gap * 15, "D"),
            new Beat(startTime + gap * 16, "K"),
            new Beat(startTime + gap * 18, "J"),
            new Beat(startTime + gap * 19, "L"),
            new Beat(startTime + gap * 20, "D"),
            new Beat(startTime + gap * 22, "Space"),
            new Beat(startTime + gap * 23, "S"),
            new Beat(startTime + gap * 24, "F"),
            new Beat(startTime + gap * 26, "S"),
            new Beat(startTime + gap * 27, "J"),
            new Beat(startTime + gap * 28, "D"),
            new Beat(startTime + gap * 29, "S"),
            new Beat(startTime + gap * 31, "Space"),
            new Beat(startTime + gap * 32, "L"),
            new Beat(startTime + gap * 33, "D"),
            new Beat(startTime + gap * 34, "K"),
            new Beat(startTime + gap * 35, "S"),
            new Beat(startTime + gap * 36, "J"),
            new Beat(startTime + gap * 38, "S"),
            new Beat(startTime + gap * 39, "Space"),
            new Beat(startTime + gap * 40, "L"),
            new Beat(startTime + gap * 42, "D"),
            new Beat(startTime + gap * 43, "K"),
            new Beat(startTime + gap * 44, "S"),
            new Beat(startTime + gap * 46, "J"),
            new Beat(startTime + gap * 47, "L"),
            new Beat(startTime + gap * 48, "Space"),
            new Beat(startTime + gap * 50, "S"),
            new Beat(startTime + gap * 51, "Space"),
            new Beat(startTime + gap * 54, "L"),
            new Beat(startTime + gap * 56, "D"),
            new Beat(startTime + gap * 59, "K"),
            new Beat(startTime + gap * 60, "S"),
            new Beat(startTime + gap * 62, "J"),
            new Beat(startTime + gap * 63, "L"),
            new Beat(startTime + gap * 67, "Space"),
            new Beat(startTime + gap * 68, "S"),
            new Beat(startTime + gap * 69, "F"),
            new Beat(startTime + gap * 72, "S"),
            new Beat(startTime + gap * 74, "J"),
            new Beat(startTime + gap * 75, "D"),
            new Beat(startTime + gap * 76, "S"),
            new Beat(startTime + gap * 77, "Space"),
            new Beat(startTime + gap * 79, "L"),
            new Beat(startTime + gap * 81, "D"),
            new Beat(startTime + gap * 82, "K"),
            new Beat(startTime + gap * 83, "S"),
            new Beat(startTime + gap * 84, "J"),
            new Beat(startTime + gap * 85, "D"),
            new Beat(startTime + gap * 87, "J"),
            new Beat(startTime + gap * 88, "F"),
            new Beat(startTime + gap * 92, "J"),
            new Beat(startTime + gap * 93, "Space"),
            new Beat(startTime + gap * 97, "S"),
            new Beat(startTime + gap * 99, "D"),
            new Beat(startTime + gap * 102, "K"),
            new Beat(startTime + gap * 105, "J"),
            new Beat(startTime + gap * 109, "L"),
            new Beat(startTime + gap * 111, "D"),
            new Beat(startTime + gap * 113, "Space"),
            new Beat(startTime + gap * 114, "S"),
            new Beat(startTime + gap * 116, "K"),
            new Beat(startTime + gap * 117, "D"),
            new Beat(startTime + gap * 119, "J"),
            new Beat(startTime + gap * 120, "F"),
            new Beat(startTime + gap * 122, "J"),
            new Beat(startTime + gap * 123, "Space"),
            new Beat(startTime + gap * 124, "S"),
            new Beat(startTime + gap * 125, "D"),
            new Beat(startTime + gap * 126, "K"),
            new Beat(startTime + gap * 128, "J"),
            new Beat(startTime + gap * 129, "L"),
            new Beat(startTime + gap * 136, "J"),
            new Beat(startTime + gap * 137, "L"),
            new Beat(startTime + gap * 138, "Space"),
            new Beat(startTime + gap * 143, "S"),
            new Beat(startTime + gap * 144, "F"),
            new Beat(startTime + gap * 146, "S"),
            new Beat(startTime + gap * 147, "J"),
            new Beat(startTime + gap * 148, "D"),
            new Beat(startTime + gap * 149, "S"),
            new Beat(startTime + gap * 151, "Space"),
            new Beat(startTime + gap * 152, "L"),
            new Beat(startTime + gap * 153, "D"),
            new Beat(startTime + gap * 154, "K"),
            new Beat(startTime + gap * 155, "S"),

         };
      }
      else if(titleName.equals("마에스트로"))
      {
         int startTime = 0;
         int gap = 125;
         beats = new Beat[]
         {
            new Beat(startTime + gap * 4, "S"),
            new Beat(startTime + gap * 6, "K"),
            new Beat(startTime + gap * 7, "D"),
            new Beat(startTime + gap * 9, "J"),
            new Beat(startTime + gap * 10, "F"),
            new Beat(startTime + gap * 12, "J"),
            new Beat(startTime + gap * 13, "Space"),
            new Beat(startTime + gap * 14, "S"),
            new Beat(startTime + gap * 15, "D"),
            new Beat(startTime + gap * 16, "K"),
            new Beat(startTime + gap * 18, "J"),
            new Beat(startTime + gap * 19, "L"),
            new Beat(startTime + gap * 20, "D"),
            new Beat(startTime + gap * 22, "Space"),
            new Beat(startTime + gap * 23, "S"),
            new Beat(startTime + gap * 24, "F"),
            new Beat(startTime + gap * 26, "S"),
            new Beat(startTime + gap * 27, "J"),
            new Beat(startTime + gap * 28, "D"),
            new Beat(startTime + gap * 29, "S"),
            new Beat(startTime + gap * 31, "Space"),
            new Beat(startTime + gap * 32, "L"),
            new Beat(startTime + gap * 33, "D"),
            new Beat(startTime + gap * 34, "K"),
            new Beat(startTime + gap * 35, "S"),
            new Beat(startTime + gap * 36, "J"),
            new Beat(startTime + gap * 38, "S"),
            new Beat(startTime + gap * 39, "Space"),
            new Beat(startTime + gap * 40, "L"),
            new Beat(startTime + gap * 42, "D"),
            new Beat(startTime + gap * 43, "K"),
            new Beat(startTime + gap * 44, "S"),
            new Beat(startTime + gap * 46, "J"),
            new Beat(startTime + gap * 47, "L"),
            new Beat(startTime + gap * 48, "Space"),
            new Beat(startTime + gap * 50, "S"),
            new Beat(startTime + gap * 51, "Space"),
            new Beat(startTime + gap * 54, "L"),
            new Beat(startTime + gap * 56, "D"),
            new Beat(startTime + gap * 59, "K"),
            new Beat(startTime + gap * 60, "S"),
            new Beat(startTime + gap * 62, "J"),
            new Beat(startTime + gap * 63, "L"),
            new Beat(startTime + gap * 67, "Space"),
            new Beat(startTime + gap * 68, "S"),
            new Beat(startTime + gap * 69, "F"),
            new Beat(startTime + gap * 72, "S"),
            new Beat(startTime + gap * 74, "J"),
            new Beat(startTime + gap * 75, "D"),
            new Beat(startTime + gap * 76, "S"),
            new Beat(startTime + gap * 77, "Space"),
            new Beat(startTime + gap * 79, "L"),
            new Beat(startTime + gap * 81, "D"),
            new Beat(startTime + gap * 82, "K"),
            new Beat(startTime + gap * 83, "S"),
            new Beat(startTime + gap * 84, "J"),
            new Beat(startTime + gap * 85, "D"),
            new Beat(startTime + gap * 87, "J"),
            new Beat(startTime + gap * 88, "F"),
            new Beat(startTime + gap * 92, "J"),
            new Beat(startTime + gap * 93, "Space"),
            new Beat(startTime + gap * 97, "S"),
            new Beat(startTime + gap * 99, "D"),
            new Beat(startTime + gap * 102, "K"),
            new Beat(startTime + gap * 105, "J"),
            new Beat(startTime + gap * 109, "L"),
            new Beat(startTime + gap * 111, "D"),
            new Beat(startTime + gap * 113, "Space"),
            new Beat(startTime + gap * 114, "S"),
            new Beat(startTime + gap * 116, "K"),
            new Beat(startTime + gap * 117, "D"),
            new Beat(startTime + gap * 119, "J"),
            new Beat(startTime + gap * 120, "F"),
            new Beat(startTime + gap * 122, "J"),
            new Beat(startTime + gap * 123, "Space"),
            new Beat(startTime + gap * 124, "S"),
            new Beat(startTime + gap * 125, "D"),
            new Beat(startTime + gap * 126, "K"),
            new Beat(startTime + gap * 128, "J"),
            new Beat(startTime + gap * 129, "L"),
            new Beat(startTime + gap * 136, "J"),
            new Beat(startTime + gap * 137, "L"),
            new Beat(startTime + gap * 138, "Space"),
            new Beat(startTime + gap * 143, "S"),
            new Beat(startTime + gap * 144, "F"),
            new Beat(startTime + gap * 146, "S"),
            new Beat(startTime + gap * 147, "J"),
            new Beat(startTime + gap * 148, "D"),
            new Beat(startTime + gap * 149, "S"),
            new Beat(startTime + gap * 151, "Space"),
            new Beat(startTime + gap * 152, "L"),
            new Beat(startTime + gap * 153, "D"),
            new Beat(startTime + gap * 154, "K"),
            new Beat(startTime + gap * 155, "S"),

         };
      }

      int i = 0;
      gameMusic.start();
      while (i<beats.length && !isInterrupted()) 
      {
         boolean dropped = false;
         if(beats[i].getTime() <= gameMusic.getTime())
         {
            Note note = new Note(beats[i].getNoteName());
            note.start();
            noteList.add(note);
            i++;
            dropped = true;
         }
         if(!dropped)
         {
            try 
            {
               Thread.sleep(5);
            } catch (Exception e) 
            {
               e.printStackTrace();
            }

         }
      }
    }

    public void judge(String input)
    {
      for(int i = 0; i < noteList.size(); i++)
      {
         Note note = noteList.get(i);
         if (input.equals(note.getNoteType())) 
         {
            judgeEvent(note.judge());
            break;
         }
      }
    }
    
    public void judgeEvent(String judge)
    {
      if(!judge.equals("None"))
      {
         blueFlareImage = new ImageIcon(musicmain.class.getResource("../imges/blueFlare.png")).getImage();
      }
      if(judge.equals("Miss"))
      {
         judgeImage = new ImageIcon(musicmain.class.getResource("../imges/judgeMiss.png")).getImage();
      }
      else if(judge.equals("Late"))
      {
         judgeImage = new ImageIcon(musicmain.class.getResource("../imges/judgeLate.png")).getImage();
      }
      else if(judge.equals("Good"))
      {
         judgeImage = new ImageIcon(musicmain.class.getResource("../imges/judgeGood.png")).getImage();
      }
      else if(judge.equals("Great"))
      {
         judgeImage = new ImageIcon(musicmain.class.getResource("../imges/judgeGreat.png")).getImage();
      }
      else if(judge.equals("Perfect"))
      {
         judgeImage = new ImageIcon(musicmain.class.getResource("../imges/judgePerfect.png")).getImage();
      }
      else if(judge.equals("Early"))
      {
         judgeImage = new ImageIcon(musicmain.class.getResource("../imges/judgeEarly.png")).getImage();
      }
    }

    
}
