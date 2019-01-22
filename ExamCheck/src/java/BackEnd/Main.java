package BackEnd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas
 */

public class Main {
    
    
    
    public boolean loginHandle(String username, String password){
        if(username.equals("admin") && password.equals("1234")){
            return true;
        }
        else{
            return false;
        }
    } 
}
