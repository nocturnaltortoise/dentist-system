import views.ApplicationSelectorView;

import javax.swing.*;

public class GraphicsController {

    public static void main(String[] args){
//        setLookAndFeel("cross platform");
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
            System.err.println("Look and Feel not supported.");
        }catch(InstantiationException e){
            e.printStackTrace();
            System.err.println("Look and Feel couldn't be instantiated.");
        }catch(IllegalAccessException e){
            e.printStackTrace();
            System.err.println("Can't access look and feel. Maybe the program doesn't have correct access rights?");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.err.println("Can't find look and feel.");
        }

    }

}
