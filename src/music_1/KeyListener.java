package src.music_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter
{
    @Override
    public void keyPressed(KeyEvent e)
    {
        //만약 다이나믹베타의 게임(시작)값이 null 이라면 아래의 그 어떤 값도 입력되지않도록 설정한다
        if(DynamicBeta.game == null)
        {
            return;
        }
        if(e.getKeyCode()==KeyEvent.VK_S)
        {
            DynamicBeta.game.pressS();
        }
        else if(e.getKeyCode()==KeyEvent.VK_D)
        {
            DynamicBeta.game.pressD();
        }
        else if(e.getKeyCode()==KeyEvent.VK_F)
        {
            DynamicBeta.game.pressF();
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            DynamicBeta.game.pressSpace();            
        }
        else if(e.getKeyCode()==KeyEvent.VK_J)
        {
            DynamicBeta.game.pressJ();
        }
        else if(e.getKeyCode()==KeyEvent.VK_K)
        {
            DynamicBeta.game.pressK();
        }
        else if(e.getKeyCode()==KeyEvent.VK_L)
        {
            DynamicBeta.game.pressL();  
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
         //만약 다이나믹베타의 게임(시작)값이 null 이라면 아래의 그 어떤 값도 입력되지않도록 설정한다
        if(DynamicBeta.game == null)
        {
            return;
        }
        if(e.getKeyCode()==KeyEvent.VK_S)
        {
            DynamicBeta.game.releaseS();
        }
        else if(e.getKeyCode()==KeyEvent.VK_D)
        {
            DynamicBeta.game.releaseD();
        }
        else if(e.getKeyCode()==KeyEvent.VK_F)
        {
            DynamicBeta.game.releaseF();
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            DynamicBeta.game.releaseSpace();
        }
        else if(e.getKeyCode()==KeyEvent.VK_J)
        {
            DynamicBeta.game.releaseJ();            
        }
        else if(e.getKeyCode()==KeyEvent.VK_K)
        {
            DynamicBeta.game.releaseK();
        }
        else if(e.getKeyCode()==KeyEvent.VK_L)
        {
            DynamicBeta.game.releaseL();
        }

    }
    
}
