/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Computer
 */
public class Song {

    private String songName;
    private String songArtist;
    private String songUrl;
    private int songPlaytime;
    private String songPic;
    private String songPlaytimeString;
    private String songId;

    public boolean setSong(String title, String artist, String url) {
        boolean result = false;
        try {
            Connection con = ConnectionBuilder.getConnectionBuilder();
            String sql = "insert into song(song_title,song_artist,song_url) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, artist);
            ps.setString(3, url);
            result = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static List<Song> getSongFromJOOX(String url) {
        List<Song> ls = null;
        try {
            Document d = Jsoup.connect(url)
                    .timeout(10000).userAgent("chrome").get();
            Elements e = d.select("tr.song-table__row").select("input");

            int count = 0;
            for (Element ee : e) {
                String id = ee.attr("data-songid");
                if (id.length() > 0) {
                    //System.out.println(ee.attr("data-songid"));
                    String songUrlz = "http://music.sanook.com/music/" + id;
                    if (ls == null) {
                        ls = new ArrayList();
                    }
                    Song s = new Song();
                    s.setSongName(ee.attr("data-songname"));
                    s.setSongArtist(ee.attr("data-artist"));
                    s.setSongPlaytime(Integer.parseInt(ee.attr("data-playtime")));
                    s.setSongUrl(songUrlz);
                    s.setSongPic(getImageByJOOXurl(songUrlz));
                    ls.add(s);
                    count++;
                }
            }
            //System.out.println(count);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public static String getImageByJOOXurl(String url) {
        String img = "";
        try {
            Document d = Jsoup.connect(url).userAgent("chrome").timeout(10000).get();
            String e = d.select("img#album_pic").attr("src");
            img = e;
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public int getSongPlaytime() {
        return songPlaytime;
    }

    public void setSongPlaytime(int songPlaytime) {
        this.songPlaytime = songPlaytime;
    }

    public String getSongPic() {
        return songPic;
    }

    public void setSongPic(String songPic) {
        this.songPic = songPic;
    }

    public static void orm(ResultSet rs, Song s) throws SQLException {
        s.setSongName(rs.getString("song_name"));
        s.setSongArtist(rs.getString("song_artist"));
        s.setSongPlaytime(Integer.parseInt(rs.getString("song_playtime")));
        s.setSongUrl(rs.getString("song_url"));
        s.setSongPic(rs.getString("song_pic"));

    }

    public static boolean updateTop100() {
        boolean result = false;
        try {

            String url = "http://music.sanook.com/music/chart/42/";
            List<Song> listsong = getSongFromJOOX(url);
            for (Song s : listsong) {
                String sql = "insert into songtop100(song_name,song_artist,song_playtime,song_url,song_pic) values(?,?,?,?,?)";
                Connection con = ConnectionBuilder.getConnectionBuilder();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, s.getSongName());
                ps.setString(2, s.getSongArtist());
                ps.setInt(3, s.getSongPlaytime());
                ps.setString(4, s.getSongUrl());
                ps.setString(5, s.getSongPic());
                ps.execute();
                con.close();
            }
            result = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean updateTop50Thai() {
        boolean result = false;
        try {

            String url = "http://music.sanook.com/music/chart/43/";
            List<Song> listsong = getSongFromJOOX(url);
            for (Song s : listsong) {
                String sql = "insert into songtop50thai(song_name,song_artist,song_playtime,song_url,song_pic) values(?,?,?,?,?)";
                Connection con = ConnectionBuilder.getConnectionBuilder();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, s.getSongName());
                ps.setString(2, s.getSongArtist());
                ps.setInt(3, s.getSongPlaytime());
                ps.setString(4, s.getSongUrl());
                ps.setString(5, s.getSongPic());
                ps.execute();
                con.close();
            }
            result = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean updateTop50Inter() {
        boolean result = false;
        try {

            String url = "http://music.sanook.com/music/chart/44/";
            List<Song> listsong = getSongFromJOOX(url);
            for (Song s : listsong) {
                String sql = "insert into songtop50inter(song_name,song_artist,song_playtime,song_url,song_pic) values(?,?,?,?,?)";
                Connection con = ConnectionBuilder.getConnectionBuilder();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, s.getSongName());
                ps.setString(2, s.getSongArtist());
                ps.setInt(3, s.getSongPlaytime());
                ps.setString(4, s.getSongUrl());
                ps.setString(5, s.getSongPic());
                ps.execute();
                con.close();
            }
            result = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean updateTop50Indy() {
        boolean result = false;
        try {

            String url = "http://music.sanook.com/music/chart/45/";
            List<Song> listsong = getSongFromJOOX(url);
            for (Song s : listsong) {
                String sql = "insert into songtop50indy(song_name,song_artist,song_playtime,song_url,song_pic) values(?,?,?,?,?)";
                Connection con = ConnectionBuilder.getConnectionBuilder();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, s.getSongName());
                ps.setString(2, s.getSongArtist());
                ps.setInt(3, s.getSongPlaytime());
                ps.setString(4, s.getSongUrl());
                ps.setString(5, s.getSongPic());
                ps.execute();
                con.close();
            }
            result = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean updateTop50Looktung() {
        boolean result = false;
        try {

            String url = "http://music.sanook.com/music/chart/46/";
            List<Song> listsong = getSongFromJOOX(url);
            for (Song s : listsong) {
                String sql = "insert into songtop50looktung(song_name,song_artist,song_playtime,song_url,song_pic) values(?,?,?,?,?)";
                Connection con = ConnectionBuilder.getConnectionBuilder();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, s.getSongName());
                ps.setString(2, s.getSongArtist());
                ps.setInt(3, s.getSongPlaytime());
                ps.setString(4, s.getSongUrl());
                ps.setString(5, s.getSongPic());
                ps.execute();
                con.close();
            }
            result = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static List<Song> getSongFromTable(String table,int limit,boolean withPic){
        List<Song> listsong = null;
        try {
            String sql = "select * from "+table+" limit "+limit;
            Connection con = ConnectionBuilder.getConnectionBuilder();
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(sql);
            while(rs.next()){
                if (listsong == null) {
                    listsong = new ArrayList<Song>();
                }
                Song s = new Song();
                orm(rs, s);
                if(withPic == true){
                    s.setSongPic(getPicUrl(s.getSongUrl()));
                }
                int time = s.getSongPlaytime();
                int t1 = time/60;
                int t2 = time%60;
                String tt1 = "";
                String tt2 = "";
                if(t1<=9){
                    tt1 = "0"+t1;
                }else{
                    tt1 = t1+"";
                }
                if(t2<=9){
                    tt2 = "0"+t2;
                }else{
                    tt2 = t1+"";
                }
                String tt3 = tt1+":"+tt2;
                String songId = s.getSongUrl().substring(30,s.getSongUrl().length()-2);
                s.setSongPlaytimeString(tt3);
                s.setSongId(songId);
                listsong.add(s);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsong;
    }
    
    public static List<Song> getNewSong(){
        List<Song> listsong = null;
        try {
            String sql = "select * from songtop100 limit 8";
            Connection con = ConnectionBuilder.getConnectionBuilder();
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(sql);
            while(rs.next()){
                if (listsong == null) {
                    listsong = new ArrayList<Song>();
                }
                Song s = new Song();
                orm(rs, s);
                //s.setSongPic(getPicUrl(s.getSongUrl()));
                String songId = s.getSongUrl().substring(30,s.getSongUrl().length()-2);
                s.setSongId(songId);
                listsong.add(s);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsong;
    }
    
    public static String getPicUrl(String songurl){
        String picurl = "";
        try {
            Document d = Jsoup.connect(songurl).userAgent("Mozilla").timeout(10000).get();
            picurl = d.select("img#album_pic").attr("src");
            
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return picurl;
    }
    
    public static String getM4AFromSongId(String songid){
        String m4a = "";
        try{
            String url = "http://api.joox.sanook.com/web-fcgi-bin/web_get_songinfo?country=th&lang=en&songid="+songid;
            
            Document d = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla").timeout(10000).get();
            int da = d.text().indexOf("\"m4aUrl\":\"");
            String s2 = d.text().substring(da+10,d.text().length());
            m4a = s2.substring(0, s2.indexOf("\""));
            
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m4a;
    }
    public static List<Song> findBySongName(String songname){
        List<Song> listsong = null;
        try {
            Connection con = ConnectionBuilder.getConnectionBuilder();
            //String sql = "select * from songtop100 where lower(song_name) like ?";
            String sql = "select song_name,song_artist,song_playtime,song_url,song_pic from songtop100 where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50thai where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50inter where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50indy where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50looktung where lower(song_name) like ? ";
            //select * from songtop100 where song_name like '%เรื่อง%' union select * from songtop50thai where song_name like '%เรื่อง%';
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+songname.toLowerCase()+"%");
            ps.setString(2, "%"+songname.toLowerCase()+"%");
            ps.setString(3, "%"+songname.toLowerCase()+"%");
            ps.setString(4, "%"+songname.toLowerCase()+"%");
            ps.setString(5, "%"+songname.toLowerCase()+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (listsong == null) {
                    listsong = new ArrayList<Song>();
                }
                Song s = new Song();
                orm(rs, s);
                listsong.add(s);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsong;
    }
    
    public static List<Song> findBySongArtist(String songartist){
        List<Song> listsong = null;
        try {
            Connection con = ConnectionBuilder.getConnectionBuilder();
            //String sql = "select * from songtop100 where lower(song_name) like ?";
            String sql = "select song_name,song_artist,song_playtime,song_url,song_pic from songtop100 where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50thai where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50inter where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50indy where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50looktung where lower(song_artist) like ? ";
            //select * from songtop100 where song_name like '%เรื่อง%' union select * from songtop50thai where song_name like '%เรื่อง%';
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+songartist.toLowerCase()+"%");
            ps.setString(2, "%"+songartist.toLowerCase()+"%");
            ps.setString(3, "%"+songartist.toLowerCase()+"%");
            ps.setString(4, "%"+songartist.toLowerCase()+"%");
            ps.setString(5, "%"+songartist.toLowerCase()+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (listsong == null) {
                    listsong = new ArrayList<Song>();
                }
                Song s = new Song();
                orm(rs, s);
                listsong.add(s);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsong;
    }
    
    public static List<Song> findByAll(String str){
        List<Song> listsong = null;
        try {
            Connection con = ConnectionBuilder.getConnectionBuilder();
            //String sql = "select * from songtop100 where lower(song_name) like ?";
            String sql = "select song_name,song_artist,song_playtime,song_url,song_pic from songtop100 where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50thai where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50inter where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50indy where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50looktung where lower(song_artist) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop100 where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50thai where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50inter where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50indy where lower(song_name) like ? "
                    + "union select song_name,song_artist,song_playtime,song_url,song_pic from songtop50looktung where lower(song_name) like ? ";
            //select * from songtop100 where song_name like '%เรื่อง%' union select * from songtop50thai where song_name like '%เรื่อง%';
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+str.toLowerCase()+"%");
            ps.setString(2, "%"+str.toLowerCase()+"%");
            ps.setString(3, "%"+str.toLowerCase()+"%");
            ps.setString(4, "%"+str.toLowerCase()+"%");
            ps.setString(5, "%"+str.toLowerCase()+"%");
            ps.setString(6, "%"+str.toLowerCase()+"%");
            ps.setString(7, "%"+str.toLowerCase()+"%");
            ps.setString(8, "%"+str.toLowerCase()+"%");
            ps.setString(9, "%"+str.toLowerCase()+"%");
            ps.setString(10, "%"+str.toLowerCase()+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (listsong == null) {
                    listsong = new ArrayList<Song>();
                }
                Song s = new Song();
                orm(rs, s);
                String songId = s.getSongUrl().substring(30,s.getSongUrl().length()-2);
                s.setSongId(songId);
                listsong.add(s);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsong;
    }
    
    public static void main(String[] args) {
        
        List<Song> list = Song.findByAll("เรื่อง");
        int count = 0;
        for(Song s : list){
            System.out.println(s.getSongName()+" "+s.getSongArtist());
            count++;
        }
        System.out.println(count);
    }

    public String getSongPlaytimeString() {
        return songPlaytimeString;
    }

    public void setSongPlaytimeString(String songPlaytimeString) {
        this.songPlaytimeString = songPlaytimeString;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }
}
