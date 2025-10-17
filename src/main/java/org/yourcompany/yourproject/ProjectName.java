/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import org.yourcompany.yourproject.entities.*;
import org.yourcompany.yourproject.services.*;

public class ProjectName {
    
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        
        Salle salle1 = new Salle("A1");
        Salle salle2 = new Salle("B2");

        salleService.create(salle1);
        salleService.create(salle2);
    }
}