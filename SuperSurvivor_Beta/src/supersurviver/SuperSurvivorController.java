/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersurviver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Nkwabo Saleh
 */
public class SuperSurvivorController {
    
    private DatabaseBean model;
    private SuperSurvivorView view;
    private ActionListener actionListener;
    private MouseListener mouseListener;
//    SignInPanel signin;
    
    public SuperSurvivorController(DatabaseBean model, SuperSurvivorView view) {
        this.model = model;
        this.view = view;
        
        start();
        //Uncomment the function calls once every thing is done or when you want to test one of them out, otherwise things wont work.
        signInStuff();
        registerStuff();
        /*
        menuStuff();
        beginningStoryStuff();
        cabinStuff();
        winStuff();
        */
    }
    
    public void start() {
        view.signin = new SignInPanel(view);
        view.registerframe = new RegisterInternalFrame();
        view.add(view.signin);
        view.centerMe();
//        view.validate();
        view.pack();
        view.setVisible(true);
        System.out.println("Testing to see what happens");
    }
    
    //This is where the functions in SignInPanel are implemented.
    public void signInStuff() {
        
        
        
        //This is what happends when you click the submit button
        //Its supposed to sign the user from the database in with their database values and go to the menu page
        //Use the evt.getSource() method  and cast it to a button to get the source of where the action is being performed. This will be similar for the remaining functions below.
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton b=(JButton) evt.getSource();
                System.out.println(b.getText());
                User user = DatabaseBean.RetrieveUser(1);
                String userName;
                String userPass;
                for(int i = 1; i < 7; i++) {
                    user = DatabaseBean.RetrieveUser(i);
                    userName = user.getUname();
                    userPass = user.getPass();
                    if (userName.equals(view.signin.getUserName()) && userPass.equals(view.signin.getUserPassword())) {
                        view.menupanel = new MenuPanel(view);
                        view.remove(view.signin);
                        view.validate();
                        view.repaint();
                        view.menupanel.setUserLabel(userName);
                        break;
                    }
                    else{
                        System.out.println("Incorrect login");
                    }
                    
                }
//                
                
            }
        };
        
        //This is what happends when you click the "click here" label. You only need to to implement the mouseClicked method and ignore the rest.
        //Its supposed to open up the register window
        mouseListener = new MouseListener() {
            @Override
            //This is the only one that needs to be overridden. For some reason, the rest have to be defined.
            public void mouseClicked(MouseEvent e) {
//                view.registerframe = new RegisterInternalFrame();
                view.remove(view.signin);
                view.add(view.registerframe);
                view.validate();
                view.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        view.signin.addsubmitListener(actionListener);
        view.signin.addregisterListener(mouseListener);
    }
    
    //This is where the functions in RegisterInternalFrame are implemented.
    public void registerStuff() {
        //This is what happends when you click the submit button
        //Its supposed to create a new user in the database with default values, sign the user in by going to the menu page
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton b=(JButton) evt.getSource();
                view.menupanel = new MenuPanel(view);
                view.remove(view.registerframe);
//                view.add(view.menupanel);
                view.validate();
                view.repaint();
                System.out.println(b.getText());
                User user = new User(674, view.registerframe.getUserName(), view.registerframe.getUserPassword().toString());
                DatabaseBean.WriteUser(user);
                String userName = user.getUname();
                view.menupanel.setUserLabel(userName);
                
            }
        };
        view.registerframe.addsubmitListener(actionListener);
    }
    
    //This is where the functions in MenuPanel are implemented.
    public void menuStuff() {
        //This is what happends when you click the play or exit button
        //Its supposed to go on to the beginningstorypanel when you click play and go to signinpanel page when you click exit
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            }
        };
        
        view.menupanel.addPlayListener(actionListener);
        view.menupanel.addExitListener(actionListener);
    }
    
    //This is where the functions in BeginningStoryPanel are implemented.
    public void beginningStoryStuff() {
        //This is what happends when you click any of the options in the beginningstorypanel
        //Its supposed to handle the flowout of the story. So basically what happens after you click an option or click the txtStory jtextarea
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            }
        };
        
        view.beginningpanel.firsBtntOptListener(actionListener);
        view.beginningpanel.secondBtnOptListener(actionListener);
        view.beginningpanel.thirdBtnOptListener(actionListener);
        view.beginningpanel.txtStoryListener(actionListener);
    }
    
    //This is where the functions in BeginningStoryPanel are implemented.
    public void cabinStuff() {
        //This is what happends when you click any of the options in the cabinpanel
        //Its supposed to handle the flowout of the story. So basically what happens after you click an option or click the txtStory jtextarea
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            }
        };
        
        view.cabinpanel.firsBtntOptListener(actionListener);
        view.cabinpanel.secondBtnOptListener(actionListener);
        view.cabinpanel.thirdBtnOptListener(actionListener);
        view.cabinpanel.txtStoryListener(actionListener);
    }
    
    //This is where the functions in winpanel are implemented.
    public void winStuff() {
        //This is what happends when you click anything on winpanel
        //Its supposed direct back to the menupanel
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            }
        };
        
        view.winpanel.addWinListener(actionListener);
    }
    
}
