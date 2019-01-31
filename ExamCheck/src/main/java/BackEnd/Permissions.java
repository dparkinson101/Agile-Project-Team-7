/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.Serializable;

/**
 *
 * @author Douglas
 */
public class Permissions implements Serializable{
    public boolean admin = false;
    public boolean examSetter = false;
    public boolean internalModerator = false;
    public boolean examVetCommittee = false;
    public boolean externalModerator = false;
    public boolean office = false;
    
    public String userPK = "";
    public boolean login = false;
}
