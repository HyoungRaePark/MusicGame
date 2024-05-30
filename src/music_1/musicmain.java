package src.music_1;

public class musicmain
{
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    // 노트가 떨어지는속도
    public static final int NOTE_SPEED = 7;
    //노트가 떨어지는 주기의 시간
    public static final int SLEEP_TIME = 10;
    //노트가 생성되고 나서 판정되기까지의 시간
    public static final int REACH_TIME = 2;
    public static void main(String[] args) 
    {
        new DynamicBeta();
    }
    
}
 