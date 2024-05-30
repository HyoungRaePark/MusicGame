package src.music_1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread
{
    private Image noteBasicImage = new ImageIcon(musicmain.class.getResource("../imges/noteBasic.png")).getImage();
    //현재 노트가 어느 위치에있는지보여줌
    private int x, y = 580-(1000 / musicmain.SLEEP_TIME * musicmain.NOTE_SPEED) * musicmain.REACH_TIME;
    private String noteType;
    private boolean proceeded = true;

    public String getNoteType()
    {
        return noteType;
    }

    public boolean isProceeded()
    {
        return proceeded;
    }
    public void close()
    {
        proceeded = false;
    }

    public Note(String noteType)
    {
        if(noteType.equals("S"))
        {
            x = 228;
        }
        else if(noteType.equals("D"))
        {
            x = 332;
        }
        else if(noteType.equals("F"))
        {
            x = 436;
        }
        else if(noteType.equals("Space"))
        {
            x = 540;
        }
        else if(noteType.equals("J"))
        {
            x = 744;
        }
        else if(noteType.equals("K"))
        {
            x = 848;
        }
        else if(noteType.equals("L"))
        {
            x = 952;
        }
        this.noteType = noteType;
    }
    //하나의 노트이미지를 그릴수있도록 스크린드로우를 추가함
    public void screenDraw(Graphics2D g)
    {
        //만약 노트 타입이 space 이라면
        if(noteType.equals("Space"))
        {
            g.drawImage(noteBasicImage, x, y,null);
            //스페이스 바를 염두에 둔 함수
            g.drawImage(noteBasicImage, x+100, y,null);
        }
        else
        {
          //이미지 좌표를 그려지도록한다 현재 자신이 위치하는공간에
           g.drawImage(noteBasicImage, x, y,null);

        }
    }

    public void drop()
    {
        y += musicmain.NOTE_SPEED;
        if(y > 620)
        {
            System.out.println("Miss");
            close();
        }
    }

    @Override
    public void run()
    {
        try 
        {
            //무한으로 반복한다 노트를 떨어트리는것을
            while (true) 
            {
                drop();
                if(proceeded)
                {
                    Thread.sleep(musicmain.SLEEP_TIME);
                }
                else
                {
                    interrupt();
                    break;
                }
                // sleep 는 0.01을 기준으로한다
                //1초에 700px 만큼 아래로 내려간다
                Thread.sleep(musicmain.SLEEP_TIME);
            }
            
        } catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }

    }

    public String judge()
    {
        if(y >= 613)
        {
            System.out.println("Late");
            close();
            return "Late";
        }
        else if(y >= 600)
        {
            System.err.println("Good");
            close();
            return "Good";
        }
        else if(y >= 587)
        {
            System.err.println("Great");
            close();
            return "Great";
        }
        else if(y >= 573)
        {
            System.err.println("Perfect");
            close();
            return "Perfect";
        }
        else if(y >= 565)
        {
            System.err.println("Great");
            close();
            return "Great";
        }
        else if(y >= 550)
        {
            System.err.println("Good");
            close();
            return "Good";
        }
        else if(y >= 535)
        {
            System.err.println("Early");
            close();
            return "Early";
        }
        return "None";

    }

    public int getY()
    {
        return y;

    }

    
}
