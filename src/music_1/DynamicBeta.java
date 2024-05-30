package src.music_1;

import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class DynamicBeta extends JFrame {
    private Image screenImage;
    private Graphics screenGraphic;

    // 버튼 이미지 아이콘
    private ImageIcon exitButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/exitButtonEntered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/exitButtonBasic.png"));
    // Start버튼 이미지 아이콘
    private ImageIcon startButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/startButtonEntered.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/startButtonBasic.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/quitButtonEntered.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/quitButtonBasic.png"));
    //게임 화면 좌우 넘기기 버튼
    private ImageIcon leftButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/leftButtonEntered.png"));
    private ImageIcon leftButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/leftButtonBasic.png"));
    private ImageIcon rightButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/rightButtonEntered.png"));
    private ImageIcon rightButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/rightButtonBasic.png"));

    //난이도 조절 버튼
    private ImageIcon easyButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/easyButtonEntered.png"));
    private ImageIcon easyButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/easyButtonBasic.png"));
    private ImageIcon hardButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/hardButtonEntered.png"));
    private ImageIcon hardButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/hardButtonBasic.png"));

    //뒤로 가기 버튼
    private ImageIcon backButtonBasicImage = new ImageIcon(musicmain.class.getResource("../imges/backButtonBasic.png"));
    private ImageIcon backButtonEnteredImage = new ImageIcon(musicmain.class.getResource("../imges/backButtonEntered.png"));
    
    // 배경 이미지
    private Image background = new ImageIcon(musicmain.class.getResource("../imges/introBackground(Title).png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(musicmain.class.getResource("../imges/menuBar.png")));

    // 종료 버튼
    private JButton exitButton = new JButton(exitButtonBasicImage);
    //시작하기버튼
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);

    //게임 화면 좌우 버튼
    private JButton leftButton = new JButton(leftButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);
    
    //게임 뒤로가기 버튼
    private JButton backButton = new JButton(backButtonBasicImage);

    //게임 난이도 조절  버튼
    private JButton easyButton = new JButton(easyButtonBasicImage);
    private JButton hardButton = new JButton(hardButtonBasicImage);

    // 마우스 좌표
    private int mouseX, mouseY;

    
    // 메인화면 이 바뀌었을떄

    private boolean isMainScreen = false;

    //게임 화면으로 들어갔을때
    //현재 게임 화면으로 넘어왔는지에 대한 변수
    private boolean isGameScreen = false;

    //트랙 연동시키기
    ArrayList<Track> trackList = new ArrayList<Track>();

    
    // 코드 간결하게 함수로 지정해놓기
    private music selectedMusic;

    // 타이틀 이미지
    private Image titleImage;

    //게임 이 시작되었을때 이미지
    private Image selectedImage;

    // 트랙 실행시 초기화
    private int nowSelected = 0;

    //메인화면 배경음악
    private music introMusic = new music("../backmusic/intromusic.mp3", true);

    //게임 화면의 변수 Game.java 연동//퍼블릭 스태틱으로 전체에서 사용하는 변수로만듬
    public static Game game;
    // 생성자
    public DynamicBeta() 
    {
        //트랙 정보넣기
        //0 초기값
        trackList.add(new Track("../imges/Energy Title Image.png", "../imges/Energy Start Image.jpg", "../imges/Energy Game Image.jpg", "../backmusic/고민중독 미리듣기.mp3","../backmusic/고민중독.mp3","고민중독"));
        //index -1
        trackList.add(new Track("../imges/Mighty Love Title Image.png", "../imges/Mighty Love Start Image.jpg", "../imges/Mighty Love Game Image.jpg", "../backmusic/최종화 미리듣기.mp3","../backmusic/최종화.mp3","최종화"));
        //index -2
        trackList.add(new Track("../imges/Wild Flower Title Image.png", "../imges/Wild Flower Start Image.jpg", "../imges/Wild Flower Game Image.jpg", "../backmusic/마에스트로 미리듣기.mp3","../backmusic/마에스트로.mp3","마에스트로"));

        // 프레임 설정
        setUndecorated(true);
        setTitle("Hyoung Rae");
        setSize(musicmain.SCREEN_WIDTH, musicmain.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null); 

        //키 입력시 이벤트 발생 함수
        addKeyListener(new KeyListener());

        introMusic.start();

        // JLayeredPane 생성
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, musicmain.SCREEN_WIDTH, musicmain.SCREEN_HEIGHT);
        add(layeredPane);

        // 메뉴 바 설정
        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() 
        {
            @Override
            public void mouseDragged(MouseEvent e) 
            {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });

        // 종료 버튼 설정
        exitButton.setBounds(1250, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);

        exitButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                exitButton.setIcon(exitButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                exitButton.setIcon(exitButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                System.exit(0);  // 프로그램 종료
            }
        });

        startButton.setBounds(40, 200, 400, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);

        startButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                startButton.setIcon(startButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                startButton.setIcon(startButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                //게임이벤트 시작+시작되면 인트로 뮤직꺼지기
                enterMain();
                startButton.setIcon(startButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
        });

        quitButton.setBounds(40, 330, 400, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);

        quitButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                quitButton.setIcon(quitButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                quitButton.setIcon(quitButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                System.exit(0);  // 프로그램 종료
            }
        });

        //버튼 위치+시작화면서 안보이기
        leftButton.setVisible(false);
        leftButton.setBounds(140, 310, 60, 60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);

        leftButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                leftButton.setIcon(leftButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                leftButton.setIcon(leftButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                // 왼쪽으로 넘기는 이벤트
                selectLeft();
            }
        });

        rightButton.setVisible(false);
        rightButton.setBounds(1080, 310, 60, 60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);

        rightButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                rightButton.setIcon(rightButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                rightButton.setIcon(rightButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                // 오른쪽으로 넘기는 이벤트
                selectRight();
            }
        });

        easyButton.setVisible(false);
        easyButton.setBounds(655, 580, 250, 67);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);

        easyButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                easyButton.setIcon(easyButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                easyButton.setIcon(easyButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                //난이도 변경 이벤트
                gameStart(nowSelected, "Easy");
                
            }
        });

        hardButton.setVisible(false);
        hardButton.setBounds(375, 580, 250, 67);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);

        hardButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                hardButton.setIcon(hardButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                hardButton.setIcon(hardButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                gameStart(nowSelected, "Hard");
                
            }
        });

        backButton.setVisible(false);
        backButton.setBounds(20, 50, 60, 60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                backButton.setIcon(backButtonEnteredImage);
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                backButton.setIcon(backButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                music buttonEnteredMusic = new music("../backmusic/buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
                //뒤로가기이벤트 발생 메인화면으로 돌아갑니다
                backmain();
            }
        });


        // JLayeredPane에 컴포넌트 추가
        layeredPane.add(menuBar, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(exitButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(startButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(quitButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(leftButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(rightButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(easyButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(hardButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(backButton, JLayeredPane.PALETTE_LAYER);
    }

    // 화면을 그리는 메서드
    @Override
    public void paint(Graphics g) 
    {
        screenImage = createImage(musicmain.SCREEN_WIDTH, musicmain.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw((Graphics2D)screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics2D g) 
    {
        g.drawImage(background, 0, 0, null);
        if(isMainScreen)
        {
            g.drawImage(selectedImage, 340, 100, null);
            //타이틀 위치
            g.drawImage(titleImage, 340, 70, null);
        }
        //게임 화면 이미지에 대한 함수값
        if(isGameScreen)
        { 
            game.screenDraw(g);
        }
        paintComponents(g);
        try 
        {
            Thread.sleep(5);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        this.repaint();
    }

    public void selectTrack(int nowSelected)
    {
        if(selectedMusic != null)
        selectedMusic.close();
        titleImage = new ImageIcon(musicmain.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(musicmain.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new music(trackList.get(nowSelected).getStartMusic(),true);
        selectedMusic.start();
    }

    //왼쪽 버튼을 눌렀을때 트랙 이벤트
    public void selectLeft()
    {
        if(nowSelected == 0)
        nowSelected = trackList.size()-1;
        else
        {  
            nowSelected--;
        }
        selectTrack(nowSelected);
    }
    //오른쪽 버튼을 눌렀을때 트랙 이벤트
    public void selectRight()
    {
        if(nowSelected == trackList.size()-1)
        nowSelected = 0;
        else
        {
            nowSelected++;
        }
        selectTrack(nowSelected);
    }


    //시작했을때 게임 화면 구성
    public void gameStart(int nowSelected,String difficulty)
    {
        if(selectedMusic != null)
        selectedMusic.close();
        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        background = new ImageIcon(musicmain.class.getResource("../imges/" + trackList.get(nowSelected).getGameImage())).getImage();
        backButton.setVisible(true);
        //게임 화면 배경 이미지 구성
        isGameScreen = true;
        game = new Game(trackList.get(nowSelected).getTitleName(),difficulty,trackList.get(nowSelected).getGameMusic());
        game.start();
        setFocusable(true); //키 이벤트의 포커스를 받을 수있는 컴포넌트가 여러개있을때 우선적으로 입력받기위해 설정
        requestFocus(); //키 이벤트를 받을 컴포넌트를 강제로 설정
    }

    //뒤로가기 눌렀을떄 화면 구성
    public void backmain()
    {
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        background = new ImageIcon(musicmain.class.getResource("../imges/mainBackground.jpg")).getImage();
        backButton.setVisible(false);
        selectTrack(nowSelected);
        //다시 화면이 돌아왔으니 게임  화면을 숨김
        isGameScreen = false;
        game.close();
    }
    public void enterMain()
    {
        startButton.setVisible(false);
        quitButton.setVisible(false);
        isMainScreen = true;
        background = new ImageIcon(musicmain.class.getResource("../imges/mainBackground.jpg")).getImage();
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        introMusic.close();
        selectTrack(0);
    }
}