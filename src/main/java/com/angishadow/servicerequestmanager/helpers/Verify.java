package com.angishadow.servicerequestmanager.helpers;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class Verify {
    List<String> mxServers;
    public Verify(){
     mxServers = new ArrayList<String>();
    }
     /**
      * 
      * @param email
      * @return domain of email
      */
     public String getDomain(String email) {
         String domain = email.split("@")[1];
         return domain;
     }
    
 
     /**
      * 
      * @param domain
      * @return MX servers of domain (if any)
      */
     public Attribute getMxServers(String domain) {
         try {
             InitialDirContext initDir = new InitialDirContext();
             Attributes attrs = initDir.getAttributes("dns:/"+domain,new String[]{"MX"});
             Attribute mxAttr = attrs.get("MX");
 
         if(mxAttr == null){
             System.out.println("No MX servers for domain "+domain);
             return null;
         }
         else {
             return mxAttr;
         }
         }
         catch (NamingException e) {
             System.out.println(domain + " Domain not found");
             return null;
         }
         
     }
 
     /**
      * 
      * @param attr
      * @return server with highest preference
      */
     public void parseServers (Attribute attr){
         try {     
 
         for(int i = 0; i<attr.size();i++){
             String[] details =(""+ attr.get(i)).split("\s+");
             mxServers.add(details[1]);
         }
         }
         catch(NamingException e){
             e.printStackTrace();
         }
     }
 
     public boolean pingServer(String server){
         try {
             
             InetAddress host = InetAddress.getByName(server);
             return host.isReachable(1000);
         }
         catch(UnknownHostException e){
             return false;
         }
         catch(IOException e){
             return false;
         }
     }
 
     public boolean checkEmail(String email){
         String domain = getDomain(email);
         Attribute attr = getMxServers(domain);
 
         if(attr == null){
             return false;
         }
         else{
             parseServers(attr);
             boolean valid = mxServers.stream().map(Tserver -> pingServer(Tserver)).filter(res -> res==true).findFirst().orElse(false);
             System.out.println(valid);
             return valid;
         }
     }
}
