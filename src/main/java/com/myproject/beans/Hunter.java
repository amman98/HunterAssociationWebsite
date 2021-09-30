package com.myproject.beans;

/**
*
* @author Amman Nega
*/
public class Hunter {
   private int id;
   private String firstName;
   private String lastName = "";
   private String nenAffinity;
   private String occupation;
   private String status;
   private String description;

   /**
    * @return the id
    */
   public int getId() {
       return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(int id) {
       this.id = id;
   }

   /**
    * @return the firstName
    */
   public String getFirstName() {
       return firstName;
   }

   /**
    * @param firstName the firstName to set
    */
   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

   /**
    * @return the lastName
    */
   public String getLastName() {
       return lastName;
   }

   /**
    * @param lastName the lastName to set
    */
   public void setLastName(String lastName) {
       this.lastName = lastName;
   }

   /**
    * @return the nenAffinity
    */
   public String getNenAffinity() {
       return nenAffinity;
   }

   /**
    * @param nenAffinity the nenAffinity to set
    */
   public void setNenAffinity(String nenAffinity) {
       this.nenAffinity = nenAffinity;
   }

   /**
    * @return the occupation
    */
   public String getOccupation() {
       return occupation;
   }

   /**
    * @param occupation the occupation to set
    */
   public void setOccupation(String occupation) {
       this.occupation = occupation;
   }

   /**
    * @return the status
    */
   public String getStatus() {
       return status;
   }

   /**
    * @param status the status to set
    */
   public void setStatus(String status) {
       this.status = status;
   }

   /**
    * @return the description
    */
   public String getDescription() {
       return description;
   }

   /**
    * @param description the description to set
    */
   public void setDescription(String description) {
       this.description = description;
   }
   
   @Override
   public String toString() {
       String hunterInfo = "Name: " + getFirstName() + " " + getLastName() + "\n" +
                   "Nen Affinity: " + getNenAffinity() + "\n" +
                   "Occupation: " + getOccupation() + "\n" + 
                   "Status: " + getStatus();
       if(getDescription() != null) {
           hunterInfo = hunterInfo +  "\n" + "Description: " + getDescription();
       }
       
       return hunterInfo;
   }
}
