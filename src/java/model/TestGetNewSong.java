/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author mmPC
 */
public class TestGetNewSong {
    public static void main(String[] args) {
        try {
            Document d = Jsoup.connect("http://music.sanook.com/music/newsong/")
                    .userAgent("Mozilla").timeout(10000).get();
            Elements e = d.select("div.row--multipost").select("div.post");
            Elements thumb = e.select("div.post__thumbnail").not("div.post__thumbnail--vip");
            
            Elements details = e.select("div.post__thumbnail");
            System.out.println(details);
        } catch (IOException ex) {
            Logger.getLogger(TestGetNewSong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
