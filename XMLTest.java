// Example Code for parsing XML file
// Dr. Moushumi Sharmin
// CSCI 345

import org.w3c.dom.Document;


public class XMLTest{

   public static void main(String args[]){
   
      Document boardDoc = null;
      Document cardsDoc = null;
      ParseXML parsing = new ParseXML();
      try{
      
         boardDoc = parsing.getDocFromFile("board.xml");
         parsing.readBoardData(boardDoc);

         cardsDoc = parsing.getDocFromFile("cards.xml");
         parsing.readCardData(cardsDoc);
      
      }catch (Exception e){
      
         System.out.println("Error = "+e);
      
      }
      
   
   }
}
