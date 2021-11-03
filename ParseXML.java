// Example Code for parsing XML file
// Dr. Moushumi Sharmin
// CSCI 345

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.util.*;

public class ParseXML{

   
        // building a document from the XML file
        // returns a Document object after loading the book.xml file.
        public Document getDocFromFile(String filename)
        throws ParserConfigurationException{
        {
            
                  
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder db = dbf.newDocumentBuilder();
           Document doc = null;
           
           try{
               doc = db.parse(filename);
           } catch (Exception ex){
               System.out.println("XML parse failure");
               ex.printStackTrace();
           }
           return doc;
        } // exception handling
        
        }  
        
        // reads data from XML file and prints data
        public void readBoardData(Document d){
        
            Element root = d.getDocumentElement();
            
            NodeList sets = root.getElementsByTagName("set");
            
            for (int i=0; i<sets.getLength();i++){
                
                System.out.println("Printing information for set "+(i+1));
                
                //reads data from the nodes
                Node set = sets.item(i);
                String setName = set.getAttributes().getNamedItem("name").getNodeValue();
                GameBoard.get().board[i+2].name = setName;
                System.out.println("Set = "+setName);
                
                //reads data
                                             
                NodeList children = set.getChildNodes();
                
                for (int j=0; j< children.getLength(); j++){
                    
                  Node sub = children.item(j);
                  
		              NodeList grandchildren = sub.getChildNodes();
		  
                  if("neighbors".equals(sub.getNodeName())){
                    
		                for (int k = 0; k < grandchildren.getLength(); k++) {
			               Node sub2 = grandchildren.item(k);
			
			               if ("neighbor".equals(sub2.getNodeName())) {
			                 String neighborName = sub2.getAttributes().getNamedItem("name").getNodeValue();
                       GameBoard.get().board[k+2].neighborLocations.add(neighborName);
			                 System.out.println(setName + "'s neighbor is " + neighborName);
			               }

		                }

                  }
                  
                  else if("area".equals(sub.getNodeName())){

		                int x = Integer.parseInt(sub.getAttributes().getNamedItem("x").getNodeValue());
                    int y = Integer.parseInt(sub.getAttributes().getNamedItem("y").getNodeValue());
                    int h = Integer.parseInt(sub.getAttributes().getNamedItem("h").getNodeValue());
                    int w = Integer.parseInt(sub.getAttributes().getNamedItem("w").getNodeValue());

                    GameBoard.get().board[j+2].area_x = x;
                    GameBoard.get().board[j+2].area_y = y;
                    GameBoard.get().board[j+2].area_h = h;
                    GameBoard.get().board[j+2].area_w = w;
                     
                  }
                  else if("takes".equals(sub.getNodeName())){
                     
                  }
                  else if("parts".equals(sub.getNodeName())){
		                for (int l = 0; l < grandchildren.getLength(); l++) {
                      Node sub3 = grandchildren.item(l);

                      NodeList greatGrandchildren = sub3.getChildNodes();

                      if ("part".equals(sub3.getNodeName())) {
                        String partName = sub3.getAttributes().getNamedItem("name").getNodeValue();
                        int level = Integer.parseInt(sub3.getAttributes().getNamedItem("level").getNodeValue());

                        GameBoard.get().board[l+2].offCardRoles.add(new Role(partName, level, false));

                        for (int m = 0; m < greatGrandchildren.getLength(); m++) {
                          Node sub4 = greatGrandchildren.item(m);

                          if ("area".equals(sub4.getNodeName())) {
                            int x = Integer.parseInt(sub4.getAttributes().getNamedItem("x").getNodeValue());
                            int y = Integer.parseInt(sub4.getAttributes().getNamedItem("y").getNodeValue());
                            int h = Integer.parseInt(sub4.getAttributes().getNamedItem("h").getNodeValue());
                            int w = Integer.parseInt(sub4.getAttributes().getNamedItem("w").getNodeValue());

                            GameBoard.get().board[l+2].offCardRoles.get(l).area_x = x;
                            GameBoard.get().board[l+2].offCardRoles.get(l).area_y = y;
                            GameBoard.get().board[l+2].offCardRoles.get(l).area_h = h;
                            GameBoard.get().board[l+2].offCardRoles.get(l).area_w = w;

                          } else if ("line".equals(sub4.getNodeName())){
                            String line = sub4.getTextContent();

                            GameBoard.get().board[l+2].offCardRoles.get(l).line = line;

                          }
                        }

		                  }

                    }
                     
                  }
                                 
                
                } //for childnodes
                
                System.out.println("\n");
                
            }//for set nodes
        
        }// method
        

                // reads data from XML file and prints data
        public void readCardData(Document d){
        
            Element root = d.getDocumentElement();
            
            NodeList cards = root.getElementsByTagName("card");
            
            for (int i=0; i<cards.getLength();i++){
                
                System.out.println("Printing information for card "+(i+1));
                
                //reads data from the nodes
                Node card = cards.item(i);

                String cardName = card.getAttributes().getNamedItem("name").getNodeValue();
                String img = card.getAttributes().getNamedItem("img").getNodeValue();
                int budget = Integer.parseInt(card.getAttributes().getNamedItem("budget").getNodeValue());

                Controller.get().sets.add(new Scene(cardName, budget));
                
                //reads data
                                             
                NodeList children = card.getChildNodes();
                
                for (int j=0; j< children.getLength(); j++){
                    
                  Node sub = children.item(j);
                  
                  NodeList grandchildren = sub.getChildNodes();
      
                  if("scene".equals(sub.getNodeName())){
                    
                    int sceneNum = Integer.parseInt(sub.getAttributes().getNamedItem("number").getNodeValue());


                  }
                  else if("part".equals(sub.getNodeName())){

                    String partName = sub.getAttributes().getNamedItem("name").getNodeValue();
                        int level = Integer.parseInt(sub.getAttributes().getNamedItem("level").getNodeValue());

                        GameBoard.get().board[j+2].todaysScene.onCardRoles.add(new Role(partName, level, true));

                        for (int k = 0; k < grandchildren.getLength(); k++) {
                          Node sub2 = grandchildren.item(k);

                          if ("area".equals(sub2.getNodeName())) {
                            int x = Integer.parseInt(sub2.getAttributes().getNamedItem("x").getNodeValue());
                            int y = Integer.parseInt(sub2.getAttributes().getNamedItem("y").getNodeValue());
                            int h = Integer.parseInt(sub2.getAttributes().getNamedItem("h").getNodeValue());
                            int w = Integer.parseInt(sub2.getAttributes().getNamedItem("w").getNodeValue());

                            GameBoard.get().board[k+2].todaysScene.onCardRoles.get(k).area_x = x;
                            GameBoard.get().board[k+2].todaysScene.onCardRoles.get(k).area_y = y;
                            GameBoard.get().board[k+2].todaysScene.onCardRoles.get(k).area_h = h;
                            GameBoard.get().board[k+2].todaysScene.onCardRoles.get(k).area_w = w;

                          } else if ("line".equals(sub2.getNodeName())){
                            String line = sub2.getTextContent();

                            GameBoard.get().board[k+2].offCardRoles.get(k).line = line;

                          }
                        }
                    }              
                
                } //for childnodes
                
                System.out.println("\n");
                
            }//for card nodes
        
        }// method
    



}//class
