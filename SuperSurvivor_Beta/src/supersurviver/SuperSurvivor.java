/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersurviver;

/**
 *
 * @author Nkwabo Saleh
 */
public class SuperSurvivor {
    
    public static DatabaseBean model;
    public static SuperSurvivorView view;
    public static SuperSurvivorController controller;
            
    public static void main(String[] args) {
        model = new DatabaseBean();
        view = new SuperSurvivorView();
        controller = new SuperSurvivorController(model, view);
//        MenuPanel mp = new MenuPanel(view);
//        SignInPanel sp = new SignInPanel(view);
//        view.add(sp);
//        view.centerMe();
////        view.validate();
//        view.pack();
//        view.setVisible(true);
//        System.out.println("Testing to see what happens");
    }
    
}
