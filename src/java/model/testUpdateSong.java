/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.Song.updateTop100;
import static model.Song.updateTop50Indy;
import static model.Song.updateTop50Inter;
import static model.Song.updateTop50Looktung;
import static model.Song.updateTop50Thai;

/**
 *
 * @author mmPC
 */
public class testUpdateSong {
    public static void main(String[] args) {
        
        Runnable r = new Runnable() {
            public void run() {
                System.out.println(updateTop100());
            }
        };
        new Thread(r).start();
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println(updateTop50Thai());
            }
        };
        new Thread(r2).start();
        Runnable r3 = new Runnable() {
            public void run() {
                System.out.println(updateTop50Indy());
            }
        };
        new Thread(r3).start();
        Runnable r4 = new Runnable() {
            public void run() {
                System.out.println(updateTop50Looktung());
            }
        };
        new Thread(r4).start();
        Runnable r5 = new Runnable() {
            public void run() {
                System.out.println(updateTop50Inter());
            }
        };
        new Thread(r5).start();
    }
}
