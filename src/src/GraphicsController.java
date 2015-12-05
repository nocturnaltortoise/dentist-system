import javax.swing.*;

public class GraphicsController {

    public static void main(String[] args){
        setLookAndFeel("cross platform");
        new ApplicationSelectorView(500,500);
    }

    private static void setLookAndFeel(String lookAndFeel){
        try{
            if(lookAndFeel.equalsIgnoreCase("system")){
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }else if(lookAndFeel.equalsIgnoreCase("cross platform")){
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            }
        }catch(UnsupportedLookAndFeelException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
