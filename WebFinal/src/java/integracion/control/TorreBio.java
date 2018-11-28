package integracion.control;

import integracion.VO.Achievements;
import jdk.nashorn.internal.parser.JSONParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
import integracion.util.TorreApi;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
public class TorreBio {
    
    public Achievements consultarLogros(String userid) throws IOException, JSONException{
        String url = "https://torre.bio/api/bios/"+userid+"/achievements";
        String resp = TorreApi.consultarTorre(url, "GET");
        resp = resp.substring(1, resp.length()-1);
        JSONObject jsonObj = new JSONObject(resp);
        Achievements obj_Achievements=new Achievements();
        obj_Achievements.setCategory(jsonObj.getString("category"));
        obj_Achievements.setId(jsonObj.getString("id"));
        obj_Achievements.setName(jsonObj.getString("name"));
        obj_Achievements.setContributions(jsonObj.getString("contributions"));
        return obj_Achievements;
    }
            
    
}
