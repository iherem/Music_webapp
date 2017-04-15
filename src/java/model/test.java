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
 * @author Computer
 */
public class test {
    public static void main(String[] args) {
        try {
            Document d = Jsoup.connect("http://music.sanook.com/music/78dyoFMbZ00L7z5l09jV2A==").userAgent("chrome").timeout(10000).get();
            String e = d.select("img#album_pic").attr("src");
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
